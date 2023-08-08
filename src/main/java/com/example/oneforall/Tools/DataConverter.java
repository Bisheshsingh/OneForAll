package com.example.oneforall.Tools;

import com.example.oneforall.Exceptions.ServiceException;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DataConverter {
    public static <T> List<T> stringToArray(final String s, Function<String, T> function) throws ServiceException {
        try {
            return Arrays.stream(s.split(" "))
                    .map(function)
                    .collect(Collectors.toList());
        } catch (Throwable e) {
            throw new ServiceException(e);
        }
    }
}
