package com.dhiraj9022.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class Covid19Service {

    @Value("${covid.api.url}")
    private String apiUrl;

    @Value("${covid.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    public Covid19Service(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getCovidDataByCountry(String country) {
        String url = apiUrl + "?country=" + country;

        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getCovidDataByDate(LocalDate date) {
        String url = apiUrl + "?date=" + date;

        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getCovidDataByRegion(String country, String region) {
        String url = apiUrl + "?country=" +country+"&region=" + region;

        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
