package com.digisol.task.digisoltask.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PackageOfferDto {
    private String fromCity;
    private String toCity;
    private String hotelName;
    private double price;
    private String imageUrl;
    String hotelImageUrl;
    double hotelStarRating;
    double hotelGuestReviewRating;
    String formattedTravelStartDate;
    String formattedTravelEndDate;
    int lengthOfStay;
    String flightDealCarrier;
    String flightDealCarrierImageUrl;
    String formattedTotalPriceValue;
    String formattedPerPassengerPackagePrice;
    String formattedTotalSavings;
    int percentSavings;
}