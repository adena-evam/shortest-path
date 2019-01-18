package com.siva.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.siva.domain.Planet;
import com.siva.service.RouteService;
import com.siva.vo.RouteVO;

@RestController
public class RouteController {

	@Autowired
	private RouteService routeService;
	

	@RequestMapping(value="getPath", method=RequestMethod.POST)
	public ModelAndView getPath(@RequestParam("source") String source, @RequestParam("destination") String destination){
		System.out.println(source+"--------"+destination);
		List<Planet> shortestRoute= routeService.getShortestPath(routeService.getPlanetByCode(source), routeService.getPlanetByCode(destination));
		return new ModelAndView("home", "shortestRoute", shortestRoute);
	}
	
	@RequestMapping(value = "rest/route", method = RequestMethod.POST, consumes="application/json", produces = "application/json")
    public @ResponseBody List<Planet> getEmployeeInJSON(@RequestBody RouteVO routeVO) {
		System.out.println(routeVO.getSource()+"-------"+routeVO.getDestination());
		return routeService.getShortestPath(routeService.getPlanetByCode(routeVO.getSource()), routeService.getPlanetByCode(routeVO.getDestination())); 
    }
	
	@RequestMapping(value="insertRouteData", method=RequestMethod.GET)
	public ModelAndView insertDefaultData(){
		routeService.insertRouteDate();
		return new ModelAndView("index");
	}
	
}
