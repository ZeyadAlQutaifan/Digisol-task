package com.digisol.task.digisoltask.controller;

import com.digisol.task.digisoltask.dto.PackageOfferDto;
import com.digisol.task.digisoltask.dto.TravelOffersResponseDto;
import com.digisol.task.digisoltask.service.PackageService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/")
    public String index() {
        return "index"; // templates/index.html
    }

    @GetMapping("/search")
    @ResponseBody
    public List<PackageOfferDto> search(@RequestParam String fromCity,
                                        @RequestParam String toCity
                                       ) {
        return packageService.searchPackages(fromCity, toCity);

    }
}