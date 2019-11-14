package com.codecool.cclmusiclibrarybackend.model.api;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Response{

	@JsonProperty("next_page")
	private int nextPage;

	@JsonProperty("songs")
	private List<SongsItem> songs;

	public void setNextPage(int nextPage){
		this.nextPage = nextPage;
	}

	public int getNextPage(){
		return nextPage;
	}

	public void setSongs(List<SongsItem> songs){
		this.songs = songs;
	}

	public List<SongsItem> getSongs(){
		return songs;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"next_page = '" + nextPage + '\'' + 
			",songs = '" + songs + '\'' + 
			"}";
		}
}