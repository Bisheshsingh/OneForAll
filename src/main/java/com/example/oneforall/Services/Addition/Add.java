package com.example.oneforall.Services.Addition;

import com.example.oneforall.Constants.Enums;
import com.example.oneforall.Exceptions.ServiceException;
import com.example.oneforall.Models.APIRequest;
import com.example.oneforall.Models.APIResponse;
import com.example.oneforall.Models.Service;
import com.example.oneforall.Tools.DataConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Add implements Service {
    public static final String decimalArray = "decimalArray";
    public static final String decimal = "decimal";
    public static final String successMessage = "Add Ran Successfully";

    @Override
    public APIResponse run(final APIRequest request) throws ServiceException {
        final List<Double> list = DataConverter
                .stringToArray(request.find(decimalArray), Double::valueOf);

        final Map<String, String> body = new HashMap<>();
        body.put(decimal, String.valueOf(sum(list)));

        return APIResponse.builder()
                .status(Enums.Status.OK.getCode())
                .message(successMessage)
                .body(body)
                .build();
    }

    private Double sum(final List<Double> arr) throws ServiceException {
        try {
            return arr.stream().reduce(Double::sum).orElse(0.0);
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }
}
