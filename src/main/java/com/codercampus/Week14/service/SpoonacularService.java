package com.codercampus.Week14.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SpoonacularService {

    @Value("${spoonacular.apiKey}")
    private String apiKey;

    @Value("${spoonacular.urls.base}")
    private String baseUrl;

    @Value("${spoonacular.urls.mealplan}")
    private String mealPlanUrl;

    private RestTemplate restTemplate;

    public SpoonacularService() {
        this.restTemplate = new RestTemplate();
    }

    public String generateMealPlan(int targetCalories, String diet, String exclusions, String timeFrame) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("apiKey", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(baseUrl + "/mealplanner/generate")
                .queryParam("targetCalories", targetCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("timeFrame", timeFrame);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class
        );

        return response.getBody();
    }
}