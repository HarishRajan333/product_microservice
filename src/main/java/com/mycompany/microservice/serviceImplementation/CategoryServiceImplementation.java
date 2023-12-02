package com.mycompany.microservice.serviceImplementation;

import com.mycompany.microservice.model.Category;
import com.mycompany.microservice.repository.CategoryRepository;
import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public ApiResponse addCategory(String category) {
        Category categoryAdd = Category.builder()
                .categoryName(category)
                .build();
        categoryAdd = categoryRepo.save(categoryAdd);
        return ApiResponse.builder()
                .statusCode(1200)
                .value(categoryAdd)
                .build();
    }

    @Override
    public ApiResponse getCategory() {
        List<Category> categories = categoryRepo.findAll();
        return ApiResponse.builder()
                .statusCode(1200)
                .value(categories)
                .build();
    }

}
