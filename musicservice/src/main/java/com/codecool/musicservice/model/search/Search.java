package com.codecool.musicservice.model.search;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.Generated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Generated("com.robohorse.robopojogenerator")
public class Search {

	@JsonProperty("next")
	private String next;

	@JsonProperty("total")
	private int total;

	@JsonProperty("data")
	private List<SearchItem> data;
}