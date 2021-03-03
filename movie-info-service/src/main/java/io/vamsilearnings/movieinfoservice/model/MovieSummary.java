package io.vamsilearnings.movieinfoservice.model;

public class MovieSummary {
	private String title;
	private String overview;
	public MovieSummary() {
		
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public MovieSummary(String title, String overview) {
		super();
		this.title = title;
		this.overview = overview;
	}
	@Override
	public String toString() {
		return "MovieSummary [title=" + title + ", overview=" + overview + "]";
	}
	
	

}
