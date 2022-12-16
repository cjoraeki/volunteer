package com.example.volunteer.security;

import com.example.volunteer.entity.User;
import com.example.volunteer.entity.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static com.example.volunteer.security.AppUserPermission.COURSE_WRITE;
import static com.example.volunteer.security.AppUserRole.*;


@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(AppUserRole.STUDENT.name())
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAnyAuthority(COURSE_WRITE.getPermission())
                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails chiji = new UserSecurity(User.builder()
                .username("chiji")
                .password(passwordEncoder.encode("password"))

//                .roles(AppUserRole.STUDENT.name())  //ROLE_STUDENT
                .build());

        UserDetails elo = new UserSecurity(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
//                .roles(AppUserRole.ADMIN.name())
                .build());

        UserDetails eji = new UserSecurity(User.builder()
                .username("trainee")
                .password(passwordEncoder.encode("trainee"))
//                .roles(AppUserRole.ADMINTRAINEE.name())
                .build());

        return new InMemoryUserDetailsManager(chiji, elo, eji);
    }

}
