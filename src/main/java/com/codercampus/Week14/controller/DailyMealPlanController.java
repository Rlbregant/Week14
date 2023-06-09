package com.codercampus.Week14.controller;

import com.codercampus.Week14.service.DayResponse;
import com.codercampus.Week14.service.SpoonacularService;
import com.codercampus.Week14.service.WeekResponse;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DailyMealPlanController {

	@Autowired
	private SpoonacularService spoonacularService;

	@GetMapping("/mealplanner/3meals")
	public ResponseEntity<DayResponse> getThreeMealsWeekPlan(
            @RequestParam(name = "numCalories", required = false) Integer numCalories,
            @RequestParam(name = "diet", required = false) String diet,
            @RequestParam(name = "exclusions", required = false) String exclusions) {

        int calories = 0; // Default value if numCalories is null

        if (numCalories != null) {
            calories = numCalories.intValue();
        }

        String mealPlanJson = spoonacularService.generateMealPlan(
                calories,
                diet,
                exclusions,
                "day"
        );
		DayResponse dayResponse = new Gson().fromJson(mealPlanJson, DayResponse.class);

		return ResponseEntity.ok(dayResponse);
	}
}