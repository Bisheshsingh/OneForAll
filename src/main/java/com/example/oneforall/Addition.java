package com.example.oneforall;

import java.util.List;

public class Addition implements Operation<List<Integer>, Integer> {

    @Override
    public Integer result(final List<Integer> input) {
        return input.stream().reduce((a, b) -> a+b).get();
    }
}
