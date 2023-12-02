package com.mycompany.microservice.controller;

import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/offers")
public class OfferController {
    
    @Autowired
    OfferService offerService;

    @PostMapping("/add-offer/{productId}/{offerPercentage}")
    public ApiResponse addOfferToProduct(@PathVariable(name = "productId") int productId,@PathVariable(name = "offerPercentage") int offerPercentage){
        return offerService.addOfferToProduct(productId,offerPercentage);
    }
    
    
}
