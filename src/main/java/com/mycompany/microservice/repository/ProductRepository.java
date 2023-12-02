package com.mycompany.microservice.repository;

import com.mycompany.microservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    public int findQuantityAvailableById(int productId);

    @Query(name = "select quantity from product where id = :productId limit 1",nativeQuery = true)
    public int getQuantityById(int productId);

}
