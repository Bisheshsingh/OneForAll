package com.example.oneforall;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class APIController {
    @GetMapping(path="/calculate/{x}/{y}")
    public int calculate(@PathVariable int x, @PathVariable int y) {
        return new Addition().result(Arrays.asList(x,y));
    }
}
