package com.example.wit.controller;

import com.example.wit.model.ResultModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestCalcController{
    @GetMapping(
            value="/sum",
            produces="application/json"
    )
    public ResultModel sum(@RequestParam int a, @RequestParam int b) {
        return new ResultModel("" + a + b);
    }
}