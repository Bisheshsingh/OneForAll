package com.example.oneforall.Models;

import com.example.oneforall.Constants.Enums;
import com.example.oneforall.Exceptions.ServiceException;

import java.util.Arrays;

public interface Service {
    default APIResponse initialize(APIRequest request) {
        try {
            return run(request);
        } catch (final ServiceException e) {
            String message = String.format("API request failed to run %s service \n",
                    request.getServiceName());
            message += String.format("errorMessage : %s \n", e.getMessage());
            message += String.format("errorTrace : %s",
                    Arrays.stream(e.getStackTrace())
                    .map(String::valueOf)
                    .reduce((a,b) -> a+"\n"+b).get());

            return APIResponse.builder()
                    .status(Enums.Status.BAD.getCode())
                    .message(message)
                    .build();
        }
    }
    APIResponse run(APIRequest request) throws ServiceException;
}
