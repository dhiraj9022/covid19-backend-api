package com.dhiraj9022.service;

import com.dhiraj9022.dto.UserDto;
import com.dhiraj9022.exception.NotFoundException;
import com.dhiraj9022.repo.UserRepo;
import com.dhiraj9022.service.utils.AuthUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class Covid19Service {

    @Value("${covid.api.url}")
    private String apiUrl;

    @Value("${covid.api.key}")
    private String apiKey;

    private final UserRepo userRepo;
    private final AuthUtil authUtil;
    private final RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    public Covid19Service(UserRepo userRepo, AuthUtil authUtil, RestTemplate restTemplate) {
        this.userRepo = userRepo;
        this.authUtil = authUtil;
        this.restTemplate = restTemplate;
    }

    public UserDto getAuthUser() {
        Optional<UserDto> userDto = userRepo.findDtoByEmail(authUtil.getAuthEmail());
        if (!userDto.isPresent()) throw new NotFoundException("user not found");
        return userDto.get();
    }

    public String getCovidDataByCountry(String country) {
        String url = apiUrl + "?country=" + country;

        headers.set("X-Api-Key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        return response.getBody();
    }

    public String getCovidDataByDate(String date) {
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
