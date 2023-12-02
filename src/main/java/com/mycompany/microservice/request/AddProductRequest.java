package com.mycompany.microservice.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class AddProductRequest {

    private String productName;
    private String deccription;
    private double price;
    private List<Integer> categoryId;
    private int quantityAvailable;

}
