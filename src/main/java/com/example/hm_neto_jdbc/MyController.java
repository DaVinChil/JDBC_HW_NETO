package com.example.hm_neto_jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private Repo repo;

    @GetMapping("/products/fetch")
    public String getProduct(@RequestParam("name") String name) {
        return repo.getProductName(name).orElse("Nothing");
    }
}
