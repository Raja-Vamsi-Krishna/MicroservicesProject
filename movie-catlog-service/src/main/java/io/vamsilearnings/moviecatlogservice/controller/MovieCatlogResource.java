package io.vamsilearnings.moviecatlogservice.controller;
import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.vamsilearnings.moviecatlogservice.model.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatlogResource {
	@RequestMapping("/{id}")

	public List<CatalogItem> getCatalog(@PathVariable("id") String userId){
		return Collections.singletonList(
		new CatalogItem("Transformers","test",4));
		
	}

}
