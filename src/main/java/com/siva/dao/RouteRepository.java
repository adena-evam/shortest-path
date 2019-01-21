package com.siva.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.siva.domain.Planet;
import com.siva.domain.Route;

@Repository
@Transactional
public class RouteRepository {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void saveRoutes(List<Route> routes){
		for (Route route : routes) {
			getCurrentSession().save(route);
		}
		
	}
	
	public void savePlanet(List<Planet> planets){
		for (Planet planet : planets) {
			getCurrentSession().save(planet);
		}
		
	}
	
	public List<Route> getRoutes() {
		return getCurrentSession().createQuery("from Route").list();
	
	}

	public List<Planet> getPlanets() {
		
		return getCurrentSession().createQuery("from Planet").list();
	}
	
	

	public Planet getPlanetById(String stringCellValue) {
		return (Planet) getCurrentSession().get(Planet.class, stringCellValue);
	}

	public Route getRouteBySource(Planet source, Planet destination) {
		Criteria criteria = getCurrentSession().createCriteria(Route.class);
		Route route = (Route) criteria.add(Restrictions.eq("source", source.getPlanetCode()))
		                       .add(Restrictions.eq("destination", destination.getPlanetCode())).uniqueResult();
		return route;
	}
	
}
