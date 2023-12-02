package com.mycompany.microservice.controller;

import com.mycompany.microservice.request.AddProductRequest;
import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    public Pageable getPageRequest(int page, int size) {
        return PageRequest.of(page, size);
    }

    @GetMapping("/get")
    public ApiResponse getRandomProduct(@RequestParam(name = "limit", defaultValue = "5") int limit, @RequestParam(name = "start", defaultValue = "0") int start) {
        return productService.getAllProductsByRandom(getPageRequest(start, limit));
    }

    @GetMapping("/get/{category}")
    public ApiResponse getProductByCategory(@PathVariable(name = "category", required = true) int category) {
        return productService.getProductByCategory(category);
    }

    @GetMapping("/get-by-id/{id}")
    public ApiResponse getProductById(@PathVariable(name = "id", required = true) int id) {
        return productService.getProductById(id);
    }

    @PostMapping("/add")
    public ApiResponse addProduct(@RequestBody AddProductRequest addProduct) {
        return productService.addProduct(addProduct);
    }

    @GetMapping("/check/{product_id}")
    public ApiResponse checkProductIsAvailable(@PathVariable(name = "product_id") int productId) {
        return productService.checkProductIdAvailable(productId);
    }

}
