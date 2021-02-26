package io.vamsilearnings.ratingsdataservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vamsilearnings.ratingsdataservice.model.Rating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	@RequestMapping("/{id}")

	public Rating getRating(@PathVariable("id") String movieId) {
		return new Rating(movieId, 4);

	}

}