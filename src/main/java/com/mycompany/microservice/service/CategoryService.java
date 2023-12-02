package com.mycompany.microservice.service;

import com.mycompany.microservice.response.ApiResponse;

public interface CategoryService {

    public ApiResponse addCategory(String category);

    public ApiResponse getCategory();

    
}
