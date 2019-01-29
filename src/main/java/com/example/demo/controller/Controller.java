package com.example.demo.controller;

import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class Controller {

    @GetMapping("/test")
    public void test(@PageableDefault(sort = {"name"}) Search search) {
        System.out.println("search = [" + search + "]");
    }

    @GetMapping("/test-p")
    public void test(SimpleSearch simpleSearch) {
        System.out.println("search = [" + simpleSearch + "]");
    }

}
