package io.vamsilearnings.movieinfoservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.vamsilearnings.movieinfoservice.model.Movie;
import io.vamsilearnings.movieinfoservice.model.MovieSummary;

@RestController
@RequestMapping("/movies")
public class MovieResource {
	@Value("${api.key}")
	private String API_KEY;
	@Autowired
	private RestTemplate resttemplate;

	@RequestMapping("/{movieId}")
	
	
	public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
		MovieSummary moviesummary = null;
		try {
		 moviesummary=resttemplate
				.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+API_KEY, MovieSummary.class);
		System.out.println("moviesummary...:"+moviesummary);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new Movie(movieId,moviesummary.getTitle(),moviesummary.getOverview());
		
	}

}
