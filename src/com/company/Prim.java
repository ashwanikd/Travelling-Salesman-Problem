package com.company;
import java.util.*;
public class Prim {
    Vertex Graph[];
    Vertex resultGraph[];
    boolean visited[];
    int max;
    Prim(Vertex graph[]){
        Graph = new Vertex[graph.length];
        resultGraph = new Vertex[graph.length];
        for(int i=0;i<Graph.length;i++){
            Graph[i] = new Vertex(i);
            resultGraph[i] = new Vertex(i);
            Graph[i].edges = new LinkedList<Edge>();
            for(int j=0;j<graph[i].edges.size();j++){
                Graph[i].edges.add(new Edge(graph[i].edges.get(j).vname,graph[i].edges.get(j).distance));
            }
            System.out.print(i + " -> ");
            for(int j=0;j<Graph[i].edges.size();j++){
                System.out.print(Graph[i].edges.get(j).vname+" ");
            }
            System.out.println();
        }
        max = 0;
        for(int i=0;i<Graph.length;i++){
            for(int j=0;j<Graph[i].edges.size();j++){
                max = max + Graph[i].edges.get(j).distance;
            }
        }
        this.visited = new boolean[Graph.length];

    }

    void algorithm(int start){
        int v1 = -1,v2 = -1;
        int r = start;
        visited[r] = true;
        while(!checkAllVisited()){
            int x = max;
            for(int o=0;o<visited.length;o++){
                System.out.println(visited[o]);
            }
            for(int i=0;i<Graph.length;i++) {
                if(visited[i]){
                    for(int j=0;j<Graph[i].edges.size();j++){
                        if(!visited[Graph[i].edges.get(j).vname]){
                            if(Graph[i].edges.get(j).distance < x) {
                                x = Graph[i].edges.get(j).distance;
                                v1 = i;
                                v2 = Graph[i].edges.get(j).vname;
                            }
                        }
                    }
                }
            }
            System.out.println(v2);
            visited[v2] = true;
            resultGraph[v1].edges.add(new Edge(v2,x));
            resultGraph[v2].edges.add(new Edge(v1,x));
        }

    }

    boolean checkAllVisited(){
        for(int i=0;i<visited.length;i++){
            if(!visited[i])
                return false;
        }
        return true;
    }

    Vertex[] getResultGraph(){
        return resultGraph;
    }
}
