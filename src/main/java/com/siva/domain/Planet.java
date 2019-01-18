package com.siva.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Planet {

	@Id
	@Column(name="PLANET_CODE")
	String planetCode;
	@Column(name="PLANET_NAME")
	String planetName;
	
	
	public Planet() {
		super();
	}


	public Planet(String planetCode, String planetName) {
		super();
		this.planetCode = planetCode;
		this.planetName = planetName;
	}


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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((planetCode == null) ? 0 : planetCode.hashCode());
		result = prime * result
				+ ((planetName == null) ? 0 : planetName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Planet other = (Planet) obj;
		if (planetCode == null) {
			if (other.planetCode != null)
				return false;
		} else if (!planetCode.equals(other.planetCode))
			return false;
		if (planetName == null) {
			if (other.planetName != null)
				return false;
		} else if (!planetName.equals(other.planetName))
			return false;
		return true;
	}
}
