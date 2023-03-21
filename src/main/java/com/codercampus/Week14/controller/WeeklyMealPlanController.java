package com.codercampus.Week14.controller;

import com.codercampus.Week14.service.SpoonacularService;
import com.codercampus.Week14.service.WeekResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeeklyMealPlanController {

    @Autowired
    private SpoonacularService spoonacularService;

    @GetMapping("/mealplanner/3meals/week")
    public ResponseEntity<WeekResponse> getThreeMealsWeekPlan(@RequestParam(name = "numCalories") int numCalories,
            @RequestParam(name = "diet", required = false) String diet,
            @RequestParam(name = "exclusions", required = false) String exclusions) {

        String mealPlanJson = spoonacularService.generateMealPlan(numCalories, diet, exclusions, "week");
        WeekResponse weekResponse = new Gson().fromJson(mealPlanJson, WeekResponse.class);

        return ResponseEntity.ok(weekResponse);
    }
}