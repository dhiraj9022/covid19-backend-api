package com.dhiraj9022.controller;

import com.dhiraj9022.service.Covid19Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/covid-data")
public class Covid19Controller {

    private final Covid19Service covid19Service;

    public Covid19Controller(Covid19Service covid19Service) {
        this.covid19Service = covid19Service;
    }

    @GetMapping("/by-country")
    public String getCovidDataCountry(@RequestParam String country) {
        return covid19Service.getCovidDataByCountry(country);
    }

    @GetMapping("/by-date")
    public String getCovidDataDate(@RequestParam String date) {
        return covid19Service.getCovidDataByDate(date);
    }

    @GetMapping("/by-country-region")
    public String getCovidDataRegion(@RequestParam String country, @RequestParam String region) {
        return covid19Service.getCovidDataByRegion(country, region);
    }
}
