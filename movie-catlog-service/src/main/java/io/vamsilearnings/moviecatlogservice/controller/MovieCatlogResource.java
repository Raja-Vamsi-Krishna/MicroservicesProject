package io.vamsilearnings.moviecatlogservice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import io.vamsilearnings.moviecatlogservice.model.CatalogItem;
import io.vamsilearnings.moviecatlogservice.model.Movie;
import io.vamsilearnings.moviecatlogservice.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource {
	
//	@Autowired
//	private RestTemplate resttemplate;
	@Autowired
	private WebClient.Builder webclientbuilder;
	@RequestMapping("/{id}")

	public List<CatalogItem> getCatalog(@PathVariable("id") String userId){
		
		
//		RestTemplate resttemplate=new RestTemplate();
		List<Rating> ratings=Arrays.asList(new Rating("12345",4)
                ,new Rating("56789",5));

		return ratings.stream().map(rating->{
//			Movie movie=resttemplate
//					   .getForObject("http://localhost:8082/movies/"+rating.getMovieId(), Movie.class);
//			
//		
			Movie movie=webclientbuilder.build()
			.get()
			.uri("http://localhost:8082/movies/"+rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();
			return new CatalogItem(movie.getName(),"movie description",rating.getRating());
					})
					.collect(Collectors.toList());
		
		// get all rated movies id's
		//for each movie id call movie info service and get details
		//put all them together
		
		
	}

}
