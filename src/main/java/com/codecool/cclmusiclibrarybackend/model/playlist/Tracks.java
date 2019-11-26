package com.codecool.cclmusiclibrarybackend.model.playlist;

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
public class Tracks {

	@JsonProperty("data")
	private List<DataItem> data;

	@JsonProperty("checksum")
	private String checksum;
}