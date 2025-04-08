package com.digisol.task.digisoltask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelOffer {
    private OfferDateRange offerDateRange;
    private Destination destination;
    private HotelInfo hotelInfo;
    private HotelPricingInfo hotelPricingInfo;
    private HotelUrls hotelUrls;
}