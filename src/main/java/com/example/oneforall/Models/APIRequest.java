package com.example.oneforall.Models;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class APIRequest {
    private String serviceName;
    private Map<String, String> input;

    public String find(final String key) {
        return this.input.get(key);
    }
}
