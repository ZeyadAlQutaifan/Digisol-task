package com.digisol.task.digisoltask.service;

import com.digisol.task.digisoltask.config.PackageConfig;
import com.digisol.task.digisoltask.dto.PackageOfferDto;
import com.digisol.task.digisoltask.dto.TravelOffersResponseDto;
import com.google.common.util.concurrent.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PackageService {

    private final RestTemplate restTemplate;
    private final PackageConfig packageConfig;

    public List<PackageOfferDto> searchPackages(String fromCity, String toCity) {

        String url = buildApiUrl(fromCity, toCity);
        log.info("Calling external API: {}", url);
        try {
            ResponseEntity<TravelOffersResponseDto> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    null,
                    TravelOffersResponseDto.class
            );

            return convertToDtos(response.getBody());
        } catch (HttpClientErrorException e) {
            log.error("API request failed with status: {}", e.getStatusCode());
            throw new RuntimeException("Failed to fetch packages", e);
        }
    }

    private String buildApiUrl(String fromCity, String toCity) {
        return UriComponentsBuilder
                .fromHttpUrl(packageConfig.getBaseUrl())
                .queryParam("scenario", packageConfig.getScenario())
                .queryParam("uid", packageConfig.getUid())
                .queryParam("productType", packageConfig.getProductType())
                .queryParam("clientId", packageConfig.getClientId())
                .queryParam("page", packageConfig.getPage())
                .queryParam("OriginCity", fromCity)
                .queryParam("DestinationCity", toCity)
                .toUriString();
    }

    private List<PackageOfferDto> convertToDtos(TravelOffersResponseDto response) {
        // Implementation from previous code
        return response.getOffers().getPackageResponse().stream()
                .map(pkg ->
                        PackageOfferDto.builder()
                                .imageUrl(pkg.getHotelInfo().getBigHotelImageUrl())
                                .price(pkg.getPackagePricingInfo().getTotalPackagePrice())
                                .hotelName(pkg.getHotelInfo().getHotelName())
                                .fromCity(pkg.getOrigin().getCity())
                                .toCity(pkg.getDestination().getCity())
                                .fromCity(pkg.getOrigin().getCity())
                                .toCity(pkg.getDestination().getCity())
                                .hotelName(pkg.getHotelInfo().getHotelName())
                                .hotelImageUrl(pkg.getHotelInfo().getBigHotelImageUrl())
                                .hotelStarRating(pkg.getHotelInfo().getHotelStarRating())
                                .hotelGuestReviewRating(pkg.getHotelInfo().getHotelGuestReviewRating())
                                .formattedTravelStartDate(pkg.getOfferDateRange().getFormattedTravelStartDate())
                                .formattedTravelEndDate(pkg.getOfferDateRange().getFormattedTravelEndDate())
                                .lengthOfStay(pkg.getOfferDateRange().getLengthOfStay())
                                .flightDealCarrier(pkg.getFlightInfo().getFlightDealCarrier())
                                .flightDealCarrierImageUrl(pkg.getFlightInfo().getFlightDealCarrierImageUrlSqSvg())
                                .formattedTotalPriceValue(pkg.getPackagePricingInfo().getFormattedTotalPriceValue())
                                .formattedPerPassengerPackagePrice(pkg.getPackagePricingInfo().getFormattedPerPassengerPackagePrice())
                                .formattedTotalSavings("$" + pkg.getPackagePricingInfo().getTotalSavings().intValue())
                                .percentSavings(pkg.getPackagePricingInfo().getPercentSavings())

                                .build()

                )
                .collect(Collectors.toList());
    }

}