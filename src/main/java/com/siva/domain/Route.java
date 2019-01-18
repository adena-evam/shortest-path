package com.siva.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Route {

	@Id
	@GeneratedValue
	@Column(name="ID")
	private Integer id;
	
	@Column(name="SOURCE")
	private Planet source;
	
	@Column(name="DESTINATION")
	private Planet destination;
	
	@Column(name="DISTANCE")
	private Double distance;
	
	public Route() {
		super();
	}
	
	public Route(Integer id, Planet source, Planet destination, Double distance) {
		super();
		this.id = id;
		this.source = source;
		this.destination = destination;
		this.distance = distance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	@Access(AccessType.PROPERTY)
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="source")
	public Planet getSource() {
		return source;
	}
	public void setSource(Planet source) {
		this.source = source;
	}
	

	@Access(AccessType.PROPERTY)
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name="destination")
	public Planet getDestination() {
		return destination;
	}
	
	public void setDestination(Planet destination) {
		this.destination = destination;
	}
	
	public Double getDistance() {
		return distance;
	}
	
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
}
