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
public class SearchItem {

	@JsonProperty("readable")
	private boolean readable;

	@JsonProperty("preview")
	private String preview;

	@JsonProperty("artist")
	private Artist artist;

	@JsonProperty("album")
	private Album album;

	@JsonProperty("link")
	private String link;

	@JsonProperty("explicit_content_cover")
	private int explicitContentCover;

	@JsonProperty("title")
	private String title;

	@JsonProperty("title_version")
	private String titleVersion;

	@JsonProperty("explicit_lyrics")
	private boolean explicitLyrics;

	@JsonProperty("type")
	private String type;

	@JsonProperty("title_short")
	private String titleShort;

	@JsonProperty("duration")
	private int duration;

	@JsonProperty("rank")
	private int rank;

	@JsonProperty("id")
	private int id;

	@JsonProperty("explicit_content_lyrics")
	private int explicitContentLyrics;
}