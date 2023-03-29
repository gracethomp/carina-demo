package com.qaprosoft.carina.demo.api.swapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResultsItem{
	private List<String> films;
	private String homeworld;
	private String gender;
	@JsonProperty(value = "skin_color")
	private String skinColor;
	private String edited;
	private String created;
	private String mass;
	private List<String> vehicles;
	private String url;
	@JsonProperty(value = "hair_color")
	private String hairColor;
	@JsonProperty(value = "birth_year")
	private String birthYear;
	@JsonProperty(value = "eye_color")
	private String eyeColor;
	private List<Object> species;
	private List<String> starships;
	private String name;
	private String height;

	public List<String> getFilms(){
		return films;
	}

	public String getHomeworld(){
		return homeworld;
	}

	public String getGender(){
		return gender;
	}

	public String getSkinColor(){
		return skinColor;
	}

	public String getEdited(){
		return edited;
	}

	public String getCreated(){
		return created;
	}

	public String getMass(){
		return mass;
	}

	public List<String> getVehicles(){
		return vehicles;
	}

	public String getUrl(){
		return url;
	}

	public String getHairColor(){
		return hairColor;
	}

	public String getBirthYear(){
		return birthYear;
	}

	public String getEyeColor(){
		return eyeColor;
	}

	public List<Object> getSpecies(){
		return species;
	}

	public List<String> getStarships(){
		return starships;
	}

	public String getName(){
		return name;
	}

	public String getHeight(){
		return height;
	}
}