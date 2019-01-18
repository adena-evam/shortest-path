package com.siva.dto;

import com.siva.domain.Route;

public class ShortestPathDTO {

	
	private String planetCode;
	private String planetName;
	private Route route;
	
	
	public String getPlanetCode() {
		return planetCode;
	}
	public void setPlanetCode(String planetCode) {
		this.planetCode = planetCode;
	}
	public String getPlanetName() {
		return planetName;
	}
	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	
	
}
