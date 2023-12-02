
package com.mycompany.microservice.service;

import com.mycompany.microservice.response.ApiResponse;

public interface OfferService {

    public ApiResponse addOfferToProduct(int productId, int offerPercentage);
    
}
