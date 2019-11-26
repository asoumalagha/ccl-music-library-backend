package com.codecool.cclmusiclibrarybackend.model.search;

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
public class Artist{

	@JsonProperty("picture_xl")
	private String pictureXl;

	@JsonProperty("tracklist")
	private String tracklist;

	@JsonProperty("picture_big")
	private String pictureBig;

	@JsonProperty("name")
	private String name;

	@JsonProperty("link")
	private String link;

	@JsonProperty("picture_small")
	private String pictureSmall;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

	@JsonProperty("picture")
	private String picture;

	@JsonProperty("picture_medium")
	private String pictureMedium;
}