package com.codecool.cclmusiclibrarybackend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class SongsItem{

	@JsonProperty("lyrics_owner_id")
	private int lyricsOwnerId;

	@JsonProperty("annotation_count")
	private int annotationCount;

	@JsonProperty("song_art_image_url")
	private String songArtImageUrl;

	@JsonProperty("primary_artist")
	private PrimaryArtist primaryArtist;

	@JsonProperty("title")
	private String title;

	@JsonProperty("api_path")
	private String apiPath;

	@JsonProperty("url")
	private String url;

	@JsonProperty("path")
	private String path;

	@JsonProperty("song_art_image_thumbnail_url")
	private String songArtImageThumbnailUrl;

	@JsonProperty("full_title")
	private String fullTitle;

	@JsonProperty("stats")
	private Stats stats;

	@JsonProperty("title_with_featured")
	private String titleWithFeatured;

	@JsonProperty("id")
	private int id;

	@JsonProperty("header_image_thumbnail_url")
	private String headerImageThumbnailUrl;

	@JsonProperty("pyongs_count")
	private int pyongsCount;

	@JsonProperty("header_image_url")
	private String headerImageUrl;

	@JsonProperty("lyrics_state")
	private String lyricsState;

	public void setLyricsOwnerId(int lyricsOwnerId){
		this.lyricsOwnerId = lyricsOwnerId;
	}

	public int getLyricsOwnerId(){
		return lyricsOwnerId;
	}

	public void setAnnotationCount(int annotationCount){
		this.annotationCount = annotationCount;
	}

	public int getAnnotationCount(){
		return annotationCount;
	}

	public void setSongArtImageUrl(String songArtImageUrl){
		this.songArtImageUrl = songArtImageUrl;
	}

	public String getSongArtImageUrl(){
		return songArtImageUrl;
	}

	public void setPrimaryArtist(PrimaryArtist primaryArtist){
		this.primaryArtist = primaryArtist;
	}

	public PrimaryArtist getPrimaryArtist(){
		return primaryArtist;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setApiPath(String apiPath){
		this.apiPath = apiPath;
	}

	public String getApiPath(){
		return apiPath;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setPath(String path){
		this.path = path;
	}

	public String getPath(){
		return path;
	}

	public void setSongArtImageThumbnailUrl(String songArtImageThumbnailUrl){
		this.songArtImageThumbnailUrl = songArtImageThumbnailUrl;
	}

	public String getSongArtImageThumbnailUrl(){
		return songArtImageThumbnailUrl;
	}

	public void setFullTitle(String fullTitle){
		this.fullTitle = fullTitle;
	}

	public String getFullTitle(){
		return fullTitle;
	}

	public void setStats(Stats stats){
		this.stats = stats;
	}

	public Stats getStats(){
		return stats;
	}

	public void setTitleWithFeatured(String titleWithFeatured){
		this.titleWithFeatured = titleWithFeatured;
	}

	public String getTitleWithFeatured(){
		return titleWithFeatured;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setHeaderImageThumbnailUrl(String headerImageThumbnailUrl){
		this.headerImageThumbnailUrl = headerImageThumbnailUrl;
	}

	public String getHeaderImageThumbnailUrl(){
		return headerImageThumbnailUrl;
	}

	public void setPyongsCount(int pyongsCount){
		this.pyongsCount = pyongsCount;
	}

	public int getPyongsCount(){
		return pyongsCount;
	}

	public void setHeaderImageUrl(String headerImageUrl){
		this.headerImageUrl = headerImageUrl;
	}

	public String getHeaderImageUrl(){
		return headerImageUrl;
	}

	public void setLyricsState(String lyricsState){
		this.lyricsState = lyricsState;
	}

	public String getLyricsState(){
		return lyricsState;
	}

	@Override
 	public String toString(){
		return 
			"SongsItem{" + 
			"lyrics_owner_id = '" + lyricsOwnerId + '\'' + 
			",annotation_count = '" + annotationCount + '\'' + 
			",song_art_image_url = '" + songArtImageUrl + '\'' + 
			",primary_artist = '" + primaryArtist + '\'' + 
			",title = '" + title + '\'' + 
			",api_path = '" + apiPath + '\'' + 
			",url = '" + url + '\'' + 
			",path = '" + path + '\'' + 
			",song_art_image_thumbnail_url = '" + songArtImageThumbnailUrl + '\'' + 
			",full_title = '" + fullTitle + '\'' + 
			",stats = '" + stats + '\'' + 
			",title_with_featured = '" + titleWithFeatured + '\'' + 
			",id = '" + id + '\'' + 
			",header_image_thumbnail_url = '" + headerImageThumbnailUrl + '\'' + 
			",pyongs_count = '" + pyongsCount + '\'' + 
			",header_image_url = '" + headerImageUrl + '\'' + 
			",lyrics_state = '" + lyricsState + '\'' + 
			"}";
		}
}