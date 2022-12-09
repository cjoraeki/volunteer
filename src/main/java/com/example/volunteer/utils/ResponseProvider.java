package com.example.volunteer.utils;
import com.example.volunteer.pojo.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResponseProvider {

    public ResponseEntity<ApiResponse<Object>> success(Object payload) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ApiResponse<>("Request Successful", true, payload));
    }

    public ResponseEntity<ApiResponse<Object>> validationFailure(String message) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiResponse<>(message, false, null));
    }

    public ResponseEntity<ApiResponse<Object>> authFailure(String message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                new ApiResponse<>(message, false, null));
    }
}
