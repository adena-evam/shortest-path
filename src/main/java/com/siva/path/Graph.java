package com.siva.path;

import java.util.List;

import com.siva.domain.Planet;
import com.siva.domain.Route;

public class Graph {

	 private final List<Planet> vertexes;
	 private final List<Route> edges;
	 
	 
	 public Graph(List<Planet> vertexes, List<Route> edges) {
	        this.vertexes = vertexes;
	        this.edges = edges;
	    }

	    public List<Planet> getVertexes() {
	        return vertexes;
	    }

	    public List<Route> getEdges() {
	        return edges;
	    }
}
