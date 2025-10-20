package com.example.scaffold.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
    private long timestamp;

    public static <T> ApiResponse<T> ok(T data) {
        return new ApiResponse<>(true, 0, "ok", data, Instant.now().toEpochMilli());
        
    }

    public static ApiResponse<Void> ok() {
        return new ApiResponse<>(true, 0, "ok", null, Instant.now().toEpochMilli());
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(false, code, message, null, Instant.now().toEpochMilli());
    }
}
