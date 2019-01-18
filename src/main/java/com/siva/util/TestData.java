package com.siva.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.siva.domain.Planet;
import com.siva.domain.Route;
import com.siva.service.RouteService;

public class TestData {
	
	@Autowired
	RouteService routeService;

	public List<Planet> getPlanetSampleData(){
		List<Planet> planets= new ArrayList<Planet>();
		planets.add(new Planet("A", "A"));
		planets.add(new Planet("B", "B"));
		planets.add(new Planet("C", "C"));
		planets.add(new Planet("D", "D"));
		planets.add(new Planet("E", "E"));
		planets.add(new Planet("F", "F"));
		planets.add(new Planet("G", "G"));
		
		return planets;
	}
	
	
	public void testSaveRoutes(){
		routeService.saveRoutes(getRouteAndDistance());
	}
	
	public static void main(String[] args) {
		new TestData().testSaveRoutes();
	}
	
	public List<Route> getRouteAndDistance(){
		List<Route> routes = new ArrayList<Route>();
		routes.add(new Route(1, new Planet("A",""), new Planet("B",""), 2.0));
		routes.add(new Route(2, new Planet("B",""), new Planet("E",""), 3.0));
		//routes.add(new Route(3, new Planet("E",""), new Planet("F",""), 2.0));
		//routes.add(new Route(4, new Planet("F",""), new Planet("C",""), 4.0));
//		routes.add(new Route(5, new Planet("C",""), new Planet("D",""), 3.0));
		//routes.add(new Route(6, new Planet("C",""), new Planet("F",""), 4.0));
		//routes.add(new Route(7, new Planet("A",""), new Planet("C",""), 6.0));
		//routes.add(new Route(8, new Planet("A",""), new Planet("D",""), 5.0));
//		routes.add(new Route(9, new Planet("D",""), new Planet("G",""), 5.0));
//		routes.add(new Route(10, new Planet("G",""), new Planet("D",""), 5.0));
		return routes;
	}
	
	public Route getRouteBySource(String source){
		
		List<Route>  totalRoutes = getRouteAndDistance();
		List<Route> routesFromSource = new ArrayList<Route>();
		for(Route route : totalRoutes){
			if(route.getSource().equals(source)){
				routesFromSource.add(route);
			}
		}
		Route shortestRoute = findShortestRoute(routesFromSource, source);
		return shortestRoute;
	}

	private Route findShortestRoute(List<Route> routesFromSource, String source) {
		System.out.println("*");
		for (Route route : routesFromSource) {
			System.out.println("--"+route.getDistance());
		}
		System.out.println("*");
		return null;
	}
}
