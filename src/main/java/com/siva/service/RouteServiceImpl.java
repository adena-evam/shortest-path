package com.siva.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import com.siva.dao.RouteRepository;
import com.siva.domain.Planet;
import com.siva.domain.Route;
import com.siva.dto.ShortestPathDTO;
import com.siva.path.DA;
import com.siva.path.Graph;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private RouteRepository routeRepository;

	public void insertRouteDate(){
		try {
			File file = ResourceUtils.getFile("classpath:route_test.xlsx");
			savePlanets(readPlanetName(file));
			saveRoutes(readPlanetDistance(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	public void savePlanets(List<Planet> planets){
		routeRepository.savePlanet(planets);
	}


	@Transactional
	public void saveRoutes(List<Route> routes){
		routeRepository.saveRoutes(routes);
	}
	
	@Transactional
	public List<Planet> getPlanets(){
		return routeRepository.getPlanets();
	}

	@Transactional
	public List<Route> getRoutes(){
		return routeRepository.getRoutes();
	}
	
	@Transactional
	public Route getRouteBySource(Planet source, Planet destination){
		return routeRepository.getRouteBySource(source, destination);
	}
	
	@Transactional
	public List<ShortestPathDTO> getShortestPath(Planet source, Planet destination){
		
		Graph graph = new Graph(getPlanets(), getRoutes());
        DA dijkstra = new DA(graph);
        dijkstra.execute(source);
        LinkedList<Planet> path = dijkstra.getPath(destination);

        for (Planet vertex : path) {
            System.out.println(vertex.getPlanetCode());
        }
        
        return convertToShortestPathDTO(source, destination, path);
	}
	
	private List<ShortestPathDTO> convertToShortestPathDTO(Planet source,
			Planet destination, LinkedList<Planet> path) {
		LinkedList<ShortestPathDTO> pathInfo = new LinkedList<ShortestPathDTO>();
		for (Planet planet : path) {
			ShortestPathDTO s= new ShortestPathDTO();
			s.setPlanetCode(planet.getPlanetCode());
			s.setPlanetName(planet.getPlanetName());
			//s.setRoute(routeRepository.getRouteBySource(source, destination));
			pathInfo.add(s);
		}
		return pathInfo;
	}

	public List<Planet> readPlanetName(File inputStream)    {
	        List<Planet> rowHolder = new ArrayList<Planet>();
	        try{
	            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(inputStream));
	            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
	            System.out.println(mySheet.getSheetName());
	            Iterator rowIter = mySheet.rowIterator();
	            while(rowIter.hasNext()){
	                XSSFRow myRow = (XSSFRow) rowIter.next();
	                if(myRow.getRowNum()!=0){
	                	rowHolder.add(getPlanet(myRow));
	                }
	            }
	        }catch (Exception e){e.printStackTrace(); }
	        return rowHolder;
	    }
	    
	    private Planet getPlanet(XSSFRow myRow) {
	    	Planet planet = new Planet();
	        planet.setPlanetCode(myRow.getCell(0)!=null?myRow.getCell(0).getStringCellValue() : null);
	        planet.setPlanetName(myRow.getCell(1)!=null?myRow.getCell(1).getStringCellValue() : null);
			return planet;
		}

		public List<Route> readPlanetDistance(File inputStream)   {
	        List<Route> rowHolder = new ArrayList<Route>();
	        try{

	            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(inputStream));
	            XSSFSheet mySheet = myWorkBook.getSheetAt(1);
	            System.out.println(mySheet.getSheetName());
	            Iterator rowIter = mySheet.rowIterator();
	            while(rowIter.hasNext()){
	                XSSFRow myRow = (XSSFRow) rowIter.next();
	                if(myRow.getRowNum()!=0){
	                	rowHolder.add(getRoute(myRow));
	                }
	            }
	        }catch (Exception e){e.printStackTrace(); }
	        return rowHolder;
	    }
	    
	    private Route getRoute(XSSFRow myRow) {
			Route route = new Route();
	    	//route.setId(myRow.getCell(0)!=null?Integer.getInteger(myRow.getCell(0).toString()): null);
	    	route.setSource(myRow.getCell(1)!=null?routeRepository.getPlanetById(myRow.getCell(1).getStringCellValue()): null);
	    	route.setDestination(myRow.getCell(2)!=null?routeRepository.getPlanetById(myRow.getCell(2).getStringCellValue()): null);
	    	route.setDistance(myRow.getCell(3)!=null?Double.parseDouble(myRow.getCell(3).toString()): null);
			return route;
		}

		public Planet getPlanetByCode(String planetNode) {
			System.out.println(planetNode);
			return routeRepository.getPlanetById(planetNode);
		}

		
	
}
