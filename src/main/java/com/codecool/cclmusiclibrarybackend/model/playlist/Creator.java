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
public class Creator{

	@JsonProperty("tracklist")
	private String tracklist;

	@JsonProperty("name")
	private String name;

	@JsonProperty("id")
	private int id;

	@JsonProperty("type")
	private String type;

}