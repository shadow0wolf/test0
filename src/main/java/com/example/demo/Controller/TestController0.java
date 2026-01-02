package com.example.demo.Controller;

import com.example.demo.Services.TestService0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController0 {
    @Autowired
    TestService0  testService0;

    @GetMapping("/testSquare")
    public Integer testSquare(@RequestParam Integer input){
        return testService0.square(input);
    }
}
