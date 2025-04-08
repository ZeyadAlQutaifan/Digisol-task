package com.digisol.task.digisoltask.dto;

import lombok.Data;

@Data
public class Package {

    private OfferDateRange offerDateRange;
    private Destination destination;
    private String displayDestinationAlternativeIsAvailable;
    private HotelInfo hotelInfo;
    private HotelPricingInfo hotelPricingInfo;
    private FlightInfo flightInfo;
    private PackageInfo packageInfo;
    private PackagePricingInfo packagePricingInfo;
    private PackageUrls packageUrls;
    private Origin origin;

}
