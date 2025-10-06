package com.forum.forum.dto;

import java.time.Instant;
import lombok.*;

import com.forum.forum.dto.resultcode.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
    private boolean success;
    private ResultCode code;
    private String message;
    private T data;
    @Builder.Default
    private Instant timestamp = Instant.now();

    public static <T> ApiResponse<T> ok(ResultCode code, String message, T data){
        return ApiResponse.<T>builder()
                                .success(true)
                                .code(code)
                                .message(message)
                                .data(data)
                                .build();
    }

    public static <T> ApiResponse<T> error(ResultCode code, String message) {
        return ApiResponse.<T>builder()
                            .success(false)
                            .code(code)
                            .message(message)
                            .build();
    }
}
