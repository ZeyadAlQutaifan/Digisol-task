package com.digisol.task.digisoltask.controller;

import com.digisol.task.digisoltask.dto.PackageOfferDto;
import com.digisol.task.digisoltask.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PackageController {

    @Autowired
    private PackageService packageService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<PackageOfferDto> search(@RequestParam String fromCity,
                                        @RequestParam String toCity
                                       ) {
        return packageService.searchPackages(fromCity, toCity);

    }
}