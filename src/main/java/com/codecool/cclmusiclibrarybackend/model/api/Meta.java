package com.codecool.cclmusiclibrarybackend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Meta{

	@JsonProperty("status")
	private int status;

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Meta{" + 
			"status = '" + status + '\'' + 
			"}";
		}
}