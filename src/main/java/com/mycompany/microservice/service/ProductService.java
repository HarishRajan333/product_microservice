package com.mycompany.microservice.service;

import com.mycompany.microservice.request.AddProductRequest;
import com.mycompany.microservice.response.ApiResponse;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    public ApiResponse getAllProductsByRandom(Pageable pageRequest);

    public ApiResponse getProductByCategory(int category);

    public ApiResponse getProductById(int id);

    public ApiResponse addProduct(AddProductRequest addProduct);

    public ApiResponse checkProductIdAvailable(int productId);

}
