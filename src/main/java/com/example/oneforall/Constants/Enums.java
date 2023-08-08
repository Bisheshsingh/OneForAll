package com.example.oneforall.Constants;

import lombok.Getter;

public class Enums {
    public enum Status {
        OK(201),
        BAD(401);

        @Getter
        private final int code;
        private Status(final int code) {
            this.code = code;
        }
    }
}
