package com.mycompany.microservice.controller;

import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public ApiResponse addCategory(@RequestParam(name = "category") String category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/get")
    public ApiResponse getCategorys() {
        return categoryService.getCategory();
    }

}
