package com.siva.ws.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siva.dao.RouteRepository;
import com.siva.domain.Planet;
import com.siva.dto.ShortestPathDTO;
import com.siva.service.RouteService;

@Service
@WebService(endpointInterface = "com.siva.ws.service.RouteWSService") 
public class RouteWSServiceImpl implements RouteWSService {
	
	@Autowired
	private RouteRepository routeRepository;
	
	@Autowired
	private RouteService routeService;

	@Override
	public Planet getPlanetByCode(@WebParam(name="code") String planetNode) {
		Planet p = routeRepository.getPlanetById(planetNode);
		return p;
	}

	@Override
	public List<ShortestPathDTO> getShortestPath(@WebParam(name="source")String source, @WebParam(name="destination")String destination) {
		return routeService.getShortestPath(getPlanetByCode(source), getPlanetByCode(destination));
	}

}
