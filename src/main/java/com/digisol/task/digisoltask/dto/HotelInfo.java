package com.digisol.task.digisoltask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelInfo {
    private String hotelId;
    private String hotelName;
    private String localizedHotelName;
    private String hotelDestination;
    private String hotelDestinationRegionID;
    private String hotelLongDestination;
    private String hotelStreetAddress;
    private String hotelCity;
    private String hotelProvince;
    private String hotelCountryCode;
    private Double hotelLatitude;
    private Double hotelLongitude;
    private Double hotelStarRating;
    private Double hotelGuestReviewRating;
    private Double formattedHotelGuestReviewRating;
    private Integer hotelReviewTotal;
    private String formattedHotelReviewTotal;
    private String hotelImageUrl;
    private String bigHotelImageUrl;
    private Boolean vipAccess;
    private Boolean enhancedCleaningAvailable;
    private Boolean isOfficialRating;
}
