package com.codecool.musicservice.model.search;

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
public class Album{

	@JsonProperty("cover")
	private String cover;

	@JsonProperty("tracklist")
	private String tracklist;

	@JsonProperty("cover_xl")
	private String coverXl;

	@JsonProperty("cover_medium")
	private String coverMedium;

	@JsonProperty("cover_small")
	private String coverSmall;

	@JsonProperty("id")
	private int id;

	@JsonProperty("title")
	private String title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("cover_big")
	private String coverBig;
}