package com.company;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges : ");
        int nv = scan.nextInt();
        int ne = scan.nextInt();
        Vertex[] graph = new Vertex[nv];
        for(int i=0;i<nv;i++){
            graph[i] = new Vertex(i);
        }
        System.out.println("Enter the edges in the format vertex1 vertex2 weight : ");
        for(int i=0;i<ne;i++){
            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            int d = scan.nextInt();
            graph[v1].addEdge(v2,d);
            graph[v2].addEdge(v1,d);
        }
        System.out.println("Enter the starting vertex : ");
        int start = scan.nextInt();
        TSP tsp = new TSP(graph);
        tsp.algorithm(start);
        LinkedList<Integer> answer = tsp.getResult();
        System.out.println("entered graph : ");
        for(int i=0;i<nv;i++){
            System.out.print(i + " -> ");
            for(int j=0;j<graph[i].edges.size();j++){
                System.out.print(graph[i].edges.get(j).vname+" ");
            }
            System.out.println();
        }
        System.out.println("approximate path for minimum cost : ");
        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" -> ");
        }
        System.out.print(answer.get(0));
    }
}
