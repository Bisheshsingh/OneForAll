package com.example.oneforall.Exceptions;

public class ServiceException extends Throwable {
    public ServiceException(final Throwable e) {
        super(e);
    }

    public ServiceException(final String message) {
        super(message);
    }
}
