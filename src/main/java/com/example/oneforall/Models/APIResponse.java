package com.example.oneforall.Models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class APIResponse {
    private Integer status;
    private String message;
    private Map<String, String> body;

    public String find(final String key) {
        return this.body.getOrDefault(key, "");
    }
}
