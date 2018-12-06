package com.company;
import java.util.*;
public class Vertex {
    LinkedList<Edge> edges;
    int vname;
    Vertex(int x){
        edges = new LinkedList<Edge>();
        vname = x;
    }
    boolean addEdge(int name_of_vertex,int distance_from_currentVertex){
        edges.add(new Edge(name_of_vertex,distance_from_currentVertex));
        return true;
    }

}
