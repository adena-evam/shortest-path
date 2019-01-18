package com.siva.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.siva.domain.Planet;
import com.siva.domain.Route;
import com.siva.path.DA;
import com.siva.path.Graph;
import com.siva.util.TestData;

public class DATest {
	

  public static void main(String[] args) {
	     List<Planet> nodes;
	     List<Route> edges;
        nodes = new ArrayList<Planet>();
        edges = new ArrayList<Route>();
        nodes.add(new Planet("A", ""));
        nodes.add(new Planet("B", ""));
        nodes.add(new Planet("C", ""));
        nodes.add(new Planet("D", ""));
        nodes.add(new Planet("E", ""));
        nodes.add(new Planet("F", ""));
        nodes.add(new Planet("G", ""));
        
       edges = new TestData().getRouteAndDistance();

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DA dijkstra = new DA(graph);
        dijkstra.execute(new Planet("C",""));
        LinkedList<Planet> path = dijkstra.getPath(new Planet("F", ""));


        for (Planet vertex : path) {
            System.out.println(vertex.getPlanetCode());
        }

    }

}
