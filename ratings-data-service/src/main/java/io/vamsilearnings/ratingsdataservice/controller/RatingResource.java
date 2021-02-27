package io.vamsilearnings.ratingsdataservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vamsilearnings.ratingsdataservice.model.Rating;
import io.vamsilearnings.ratingsdataservice.model.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {
	@RequestMapping("/{id}")

	public Rating getRating(@PathVariable("id") String movieId) {
		return new Rating(movieId, 4);

	}
	@RequestMapping("users/{userid}")

	public UserRating getUserRating(@PathVariable("userid") String userId) {
		List<Rating> ratings=Arrays.asList(new Rating("12345",4)
                ,new Rating("56789",5));
UserRating userRating=new UserRating();
userRating.setUserRating(ratings);
return userRating;
	}


}
