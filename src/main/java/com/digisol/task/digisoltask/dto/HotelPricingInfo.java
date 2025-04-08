package com.digisol.task.digisoltask.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HotelPricingInfo {
    private double hotelPerPsgrBaseRate;
    private double hotelPerPsgrTaxesAndFees;
    private double hotelPerPsgrTotalRate;
    private double hotelTotalBaseRate;
    private double hotelTotalTaxesAndFees;
    private double hotelTotalRate;
    private String currency;
    private String formattedTotalPriceValue;
    private boolean displayAveragePrice;
    private boolean drr;
}