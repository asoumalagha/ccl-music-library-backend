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
public class Playlist {

	@JsonProperty("nb_tracks")
	private int nbTracks;

	@JsonProperty("picture_xl")
	private String pictureXl;

	@JsonProperty("tracklist")
	private String tracklist;

	@JsonProperty("creator")
	private Creator creator;

	@JsonProperty("collaborative")
	private boolean collaborative;

	@JsonProperty("link")
	private String link;

	@JsonProperty("picture_small")
	private String pictureSmall;

	@JsonProperty("description")
	private String description;

	@JsonProperty("creation_date")
	private String creationDate;

	@JsonProperty("title")
	private String title;

	@JsonProperty("type")
	private String type;

	@JsonProperty("picture")
	private String picture;

	@JsonProperty("tracks")
	private Tracks tracks;

	@JsonProperty("fans")
	private int fans;

	@JsonProperty("duration")
	private int duration;

	@JsonProperty("is_loved_track")
	private boolean isLovedTrack;

	@JsonProperty("public")
	private boolean jsonMemberPublic;

	@JsonProperty("picture_big")
	private String pictureBig;

	@JsonProperty("checksum")
	private String checksum;

	@JsonProperty("share")
	private String share;

	@JsonProperty("id")
	private int id;

	@JsonProperty("picture_medium")
	private String pictureMedium;
}