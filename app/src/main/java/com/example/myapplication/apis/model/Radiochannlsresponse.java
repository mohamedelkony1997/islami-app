package com.example.myapplication.apis.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Radiochannlsresponse{

	@SerializedName("radios")
	private List<RadiosItem> radios;

	public void setRadios(List<RadiosItem> radios){
		this.radios = radios;
	}

	public List<RadiosItem> getRadios(){
		return radios;
	}

	@Override
 	public String toString(){
		return 
			"Radiochannlsresponse{" + 
			"radios = '" + radios + '\'' + 
			"}";
		}
}