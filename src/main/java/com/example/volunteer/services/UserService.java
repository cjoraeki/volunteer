package com.example.volunteer.services;


import com.example.volunteer.entity.User;
import com.example.volunteer.pojo.user.SignUpRequest;
import com.example.volunteer.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    public User createUser(SignUpRequest request){
//        User newUser = User.builder()
//                .name(request.getName())
//                .email(request.getEmail())
//                .password(request.getPassword()).build();
//        return userRepository.save(newUser);
//    }
}
