package com.techprimers.elastic.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.elastic.builder.SearchQueryBuilder;
import com.techprimers.elastic.model.Users;

@RestController
@RequestMapping("/rest/manual/search")
public class SearchUsingQueryDsl {

	@Autowired
	private SearchQueryBuilder searchQueryBuilder;
	
	@GetMapping(value="/{text}")
	public List<Users> getAll(@PathVariable final String text) {
		return searchQueryBuilder.getAll(text);
	}
	
}
