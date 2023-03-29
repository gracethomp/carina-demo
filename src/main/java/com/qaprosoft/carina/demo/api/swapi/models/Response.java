package com.qaprosoft.carina.demo.api.swapi.models;

import java.util.List;

public class Response{
	private String next;
	private Object previous;
	private Integer count;
	private List<ResultsItem> results;

	public String getNext(){
		return next;
	}

	public Object getPrevious(){
		return previous;
	}

	public Integer getCount(){
		return count;
	}

	public List<ResultsItem> getResults(){
		return results;
	}
}