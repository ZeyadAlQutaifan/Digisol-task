package com.digisol.task.digisoltask.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PackagePricingInfo {
    private String currencyCode;
    private double perPsgrPackagePrice;
    private double totalPackagePrice;
    private double perPsgrSavings;
    private BigDecimal totalSavings;
    private int percentSavings;
    private int savingsPctOfHotel;
    private int savingsPctOfFlight;
    private String formattedPerPassengerPackagePrice;
    private String formattedTotalPriceValue;
}