package com.codecool.cclmusiclibrarybackend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class PrimaryArtist{

	@JsonProperty("is_meme_verified")
	private boolean isMemeVerified;

	@JsonProperty("image_url")
	private String imageUrl;

	@JsonProperty("name")
	private String name;

	@JsonProperty("iq")
	private int iq;

	@JsonProperty("id")
	private int id;

	@JsonProperty("api_path")
	private String apiPath;

	@JsonProperty("is_verified")
	private boolean isVerified;

	@JsonProperty("header_image_url")
	private String headerImageUrl;

	@JsonProperty("url")
	private String url;

	public void setIsMemeVerified(boolean isMemeVerified){
		this.isMemeVerified = isMemeVerified;
	}

	public boolean isIsMemeVerified(){
		return isMemeVerified;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setIq(int iq){
		this.iq = iq;
	}

	public int getIq(){
		return iq;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setApiPath(String apiPath){
		this.apiPath = apiPath;
	}

	public String getApiPath(){
		return apiPath;
	}

	public void setIsVerified(boolean isVerified){
		this.isVerified = isVerified;
	}

	public boolean isIsVerified(){
		return isVerified;
	}

	public void setHeaderImageUrl(String headerImageUrl){
		this.headerImageUrl = headerImageUrl;
	}

	public String getHeaderImageUrl(){
		return headerImageUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"PrimaryArtist{" + 
			"is_meme_verified = '" + isMemeVerified + '\'' + 
			",image_url = '" + imageUrl + '\'' + 
			",name = '" + name + '\'' + 
			",iq = '" + iq + '\'' + 
			",id = '" + id + '\'' + 
			",api_path = '" + apiPath + '\'' + 
			",is_verified = '" + isVerified + '\'' + 
			",header_image_url = '" + headerImageUrl + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}