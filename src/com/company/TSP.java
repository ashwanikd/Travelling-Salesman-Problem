package com.company;

import java.util.LinkedList;

public class TSP {
    Vertex[] Graph;
    Vertex[] resultGraph;
    LinkedList<Integer> hamiltonian;
    boolean visited[];
    TSP(Vertex[] graph){
        Graph = new Vertex[graph.length];
        resultGraph = new Vertex[graph.length];
        for(int i=0;i<Graph.length;i++){
            Graph[i] = new Vertex(i);
            resultGraph[i] = new Vertex(i);
            Graph[i].edges = new LinkedList<Edge>();
            for(int j=0;j<graph[i].edges.size();j++){
                Graph[i].edges.add(new Edge(graph[i].edges.get(j).vname,graph[i].edges.get(j).distance));
            }
        }
        visited = new boolean[Graph.length];
        hamiltonian = new LinkedList<Integer>();
    }

    void algorithm(int start){
        Prim p = new Prim(Graph);
        p.algorithm(start);
        resultGraph = p.getResultGraph();
        preOrderWalk(start);
    }

    void preOrderWalk(int start){
        hamiltonian.add(start);
        visited[start] = true;
        for(int i=0;i<resultGraph[start].edges.size();i++){
            if(!visited[resultGraph[start].edges.get(i).vname])
                preOrderWalk(resultGraph[start].edges.get(i).vname);
        }
    }

    LinkedList<Integer> getResult(){
        System.out.println("minimum spanning tree : ");
        for(int i=0;i<resultGraph.length;i++){
            System.out.print(i + " -> ");
            for(int j=0;j<resultGraph[i].edges.size();j++){
                System.out.print(resultGraph[i].edges.get(j).vname+" ");
            }
            System.out.println();
        }
        return hamiltonian;
    }
}
