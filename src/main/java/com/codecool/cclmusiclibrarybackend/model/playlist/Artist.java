package com.codecool.cclmusiclibrarybackend.model.playlist;

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

	@JsonProperty("tracklist")
	private String tracklist;

	@JsonProperty("name")
	private String name;

	@JsonProperty("link")
	private String link;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

}