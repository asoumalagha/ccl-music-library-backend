package com.codecool.cclmusiclibrarybackend.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Stats{

	@JsonProperty("unreviewed_annotations")
	private int unreviewedAnnotations;

	@JsonProperty("hot")
	private boolean hot;

	@JsonProperty("pageviews")
	private int pageviews;

	public void setUnreviewedAnnotations(int unreviewedAnnotations){
		this.unreviewedAnnotations = unreviewedAnnotations;
	}

	public int getUnreviewedAnnotations(){
		return unreviewedAnnotations;
	}

	public void setHot(boolean hot){
		this.hot = hot;
	}

	public boolean isHot(){
		return hot;
	}

	public void setPageviews(int pageviews){
		this.pageviews = pageviews;
	}

	public int getPageviews(){
		return pageviews;
	}

	@Override
 	public String toString(){
		return 
			"Stats{" + 
			"unreviewed_annotations = '" + unreviewedAnnotations + '\'' + 
			",hot = '" + hot + '\'' + 
			",pageviews = '" + pageviews + '\'' + 
			"}";
		}
}