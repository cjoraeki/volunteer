package com.example.volunteer.controller;


import com.example.volunteer.pojo.ApiResponse;
import com.example.volunteer.pojo.user.SignUpRequest;
import com.example.volunteer.services.UserService;
import com.example.volunteer.utils.ResponseProvider;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final ResponseProvider responseProvider;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<Object>> createUser(SignUpRequest request){
        return responseProvider.success(userService.createUser(request));
    }
}
