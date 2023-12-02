package com.mycompany.microservice.serviceImplementation;

import com.mycompany.microservice.model.Category;
import com.mycompany.microservice.model.Product;
import com.mycompany.microservice.repository.CategoryRepository;
import com.mycompany.microservice.repository.ProductRepository;
import com.mycompany.microservice.request.AddProductRequest;
import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.ProductService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    ProductRepository productRepo;

    @Autowired
    CategoryRepository categoryRepo;

    @Override
    public ApiResponse getAllProductsByRandom(Pageable pageRequest) {
        return ApiResponse.builder()
                .statusCode(1200)
                .value(productRepo.findAll(pageRequest))
                .build();
    }

    @Override
    public ApiResponse getProductByCategory(int category) {
        Category categoryProductes = categoryRepo.findById(category).get();
        return ApiResponse.builder()
                .statusCode(1200)
                .value(categoryProductes)
                .build();
    }

    @Override
    public ApiResponse getProductById(int id) {
        Product product = productRepo.findById(id).get();
        return ApiResponse.builder()
                .statusCode(1200)
                .value(product)
                .build();
    }

    @Override
    public ApiResponse addProduct(AddProductRequest addProduct) {

        List<Category> categorys = addProduct.getCategoryId().stream()
                .filter((id) -> categoryRepo.existsById(id))
                .map((id) -> {
                    return categoryRepo.findById(id).get();
                })
                .collect(Collectors.toList());

        Product product = new Product();
//Product.builder()
//                .productName(addProduct.getProductName())
//                .deccription(addProduct.getDeccription())
//                .price(addProduct.getPrice())
//                .categorys(categorys)
//                .build();
        BeanUtils.copyProperties(addProduct, product);
        product.setCategorys(categorys);

        product = productRepo.save(product);

        return ApiResponse.builder()
                .statusCode(1200)
                .value(product)
                .build();
    }

    @Override
    public ApiResponse checkProductIdAvailable(int productId) {
        boolean checkProductIsExists = productRepo.existsById(productId);
        if (checkProductIsExists) {
            System.out.println(productId);
            System.out.println(
                    productRepo.getQuantityById(productId) + ">>>>>>>>>>>>>>>>>>>>>>>>>>"
            );
            int quantityAvailable = productRepo.findQuantityAvailableById(productId);

            if (quantityAvailable == 0) {
                return ApiResponse.builder()
                        .statusCode(1304)
                        .value(false)
                        .errors(Map.of("message", "out of stock"))
                        .build();
            }
            return ApiResponse.builder()
                    .statusCode(1300)
                    .value(true)
                    .build();
        } else {
            return ApiResponse.builder()
                    .statusCode(1305)
                    .value(false)
                    .errors(Map.of("message", "product not available"))
                    .build();
        }
    }

}
