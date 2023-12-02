package com.mycompany.microservice.serviceImplementation;

import com.mycompany.microservice.model.Offers;
import com.mycompany.microservice.model.Product;
import com.mycompany.microservice.repository.OfferRepository;
import com.mycompany.microservice.repository.ProductRepository;
import com.mycompany.microservice.response.ApiResponse;
import com.mycompany.microservice.service.OfferService;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImplementation implements OfferService {
    
    @Autowired
    private OfferRepository offerRepo;
    
    @Autowired
    private ProductRepository productRepo;
    
    @Override
    public ApiResponse addOfferToProduct(int productId, int offerPercentage) {
        Product product = productRepo.findById(productId).get();
        Offers offerAdd = Offers.builder()
                .offerGoingOn(true)
                .offerPercentage(offerPercentage)
                .productId(product)
                .offeringTime(Timestamp.valueOf(LocalDateTime.now()))
                .build();
        
        List<Offers> collect = product.getOffers().stream()
                .map((offer) -> {
                    if (offer.isOfferGoingOn() == true) {
                        offer.setOfferGoingOn(false);
                    }
                    return offer;
                })
                .collect(Collectors.toList());
        offerAdd = offerRepo.save(offerAdd);
        
        collect.add(offerAdd);
        product.setOffers(collect);
        product = productRepo.save(product);
        
        return ApiResponse.builder()
                .statusCode(1200)
                .value(product)
                .build();
    }
    
}
