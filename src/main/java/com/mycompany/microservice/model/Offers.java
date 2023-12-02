package com.mycompany.microservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "offers")
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "offer_percentage")
    private int offerPercentage;

    @Column(name = "offer_goingon")
    private boolean offerGoingOn;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;
    
    @Column(name = "offering_time")
    private Timestamp offeringTime;
}
