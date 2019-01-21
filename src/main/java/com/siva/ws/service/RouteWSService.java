package com.siva.ws.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import com.siva.domain.Planet;
import com.siva.dto.ShortestPathDTO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface RouteWSService {

	@WebMethod
	public Planet getPlanetByCode(@WebParam(name = "planetNode")String planetNode);
	
	@WebMethod
	@WebResult(name="ShortestPathDTO")
	public  List<ShortestPathDTO> getShortestPath(@WebParam(name = "source")String source,
			@WebParam(name = "destination")String destination);
}
