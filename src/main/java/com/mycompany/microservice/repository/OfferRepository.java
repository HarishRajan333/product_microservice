package com.mycompany.microservice.repository;

import com.mycompany.microservice.model.Offers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offers, Integer> {

}
