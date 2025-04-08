package com.digisol.task.digisoltask.dto;

import lombok.Data;

@Data
public class PackageUrls {
    private String packageSearchUrl;
    private String decodedPackageSearchUrl;
    private String similarSearchLink;
    private FlightDeeplinks flightDeeplinks;
    private HotelDeeplinks hotelDeeplinks;

    @Data
    public static class FlightDeeplinks {
        private String flightSearchUrl;
        private String decodedFlightSearchUrl;
    }

    @Data
    public static class HotelDeeplinks {
        private String hotelInfositeUrl;
        private String hotelSearchResultUrl;
        private String pinnedHotelSearchResultUrl;
        private String decodedHotelInfositeUrl;
        private String decodedHotelSearchResultUrl;
        private String decodedHsrSortByVrUrl;
        private String decodedPinnedHsrSortByRecommendedUrl;
        private String decodedPinnedHsrSortByBestUrl;
        private String decodedPinnedHsrSortByModUrl;
        private String decodedPinnedHsrSortByVrUrl;
        private String similarSearchLink;
    }
}