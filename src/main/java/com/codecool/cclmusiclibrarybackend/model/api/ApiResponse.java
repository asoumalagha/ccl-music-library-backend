package com.codecool.cclmusiclibrarybackend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ApiResponse{

	@JsonProperty("meta")
	private Meta meta;

	@JsonProperty("response")
	private Response response;

	public void setMeta(Meta meta){
		this.meta = meta;
	}

	public Meta getMeta(){
		return meta;
	}

	public void setResponse(Response response){
		this.response = response;
	}

	public Response getResponse(){
		return response;
	}

	@Override
 	public String toString(){
		return 
			"ApiResponse{" + 
			"meta = '" + meta + '\'' + 
			",response = '" + response + '\'' + 
			"}";
		}
}