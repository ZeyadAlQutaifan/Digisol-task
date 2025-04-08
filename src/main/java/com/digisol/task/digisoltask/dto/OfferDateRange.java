package com.digisol.task.digisoltask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OfferDateRange {
    private List<Integer> travelStartDate;
    private List<Integer> travelEndDate;
    private String formattedTravelStartDate;
    private String formattedTravelEndDate;
    private Integer lengthOfStay;
}