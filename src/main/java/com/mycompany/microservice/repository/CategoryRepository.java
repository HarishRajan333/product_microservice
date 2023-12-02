package com.mycompany.microservice.repository;

import com.mycompany.microservice.model.Category;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    public List<Category> findBycategoryName(String category, Pageable pageRequest);

}
