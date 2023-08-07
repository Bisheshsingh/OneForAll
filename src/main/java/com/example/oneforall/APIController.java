package com.example.oneforall;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class APIController {
    @GetMapping(path="/calculate/{x}/{y}")
    public int calculate(@PathVariable int x, @PathVariable int y) {
        return new Addition().result(new ArrayList<>(Arrays.asList(x,y)));
    }
}
