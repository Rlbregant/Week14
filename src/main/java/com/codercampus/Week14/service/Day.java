package com.codercampus.Week14.service;

import java.util.List;

public class Day {

	private List<Meal> meals;
	private Nutrients nutrients;

	public Nutrients getNutrients() {
		return nutrients;
	}

	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}

	public List<Meal> getMeals() {
		return meals;
	}

	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

}