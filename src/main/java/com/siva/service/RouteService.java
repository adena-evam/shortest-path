package com.siva.service;

import java.io.File;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.siva.domain.Planet;
import com.siva.domain.Route;
import com.siva.dto.ShortestPathDTO;

public interface RouteService {

	public  void insertRouteDate();

	public  void savePlanets(List<Planet> planets);

	public  void saveRoutes(List<Route> routes);

	public  List<Planet> getPlanets();

	public  List<Route> getRoutes();

	public  List<ShortestPathDTO> getShortestPath(Planet source,
			Planet destination);

	public  List<Planet> readPlanetName(File inputStream);

	public  List<Route> readPlanetDistance(File inputStream);
	
	public Planet getPlanetByCode(String planetNode);

}