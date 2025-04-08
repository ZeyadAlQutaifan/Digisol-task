package com.digisol.task.digisoltask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    private String regionID;
    private String associatedMultiCityRegionId;
    private String longName;
    private String continent;
    private String country;
    private String province;
    private String city;
    private String displayDestination;
    private String flightDestination;
    private String displayDestinationRegionId;
    private String tla;
    private Integer pointOfSaleRank;
    private String shortName;

}