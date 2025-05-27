package Graphs;

import java.util.ArrayList;
import java.util.List;

public class BasicGraphProblems {
    List<List<Integer>> adjacencyList = new ArrayList<>();

    public static void main(String[] args) {
        BasicGraphProblems obj = new BasicGraphProblems();
        int[][] allEdges = {{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}};
        obj.createAdjacencyList(4, 6, allEdges);
        obj.dfs(1);
    }

    public void createAdjacencyList(int vertices, int edges, int[][] allEdges) {
        for (int i = 0; i < vertices; i++)
            adjacencyList.add(new ArrayList<>());

        for (int i = 0; i < edges; i++) {
            int v1 = allEdges[i][0];
            int v2 = allEdges[i][1];
            addEdge(v1, v2);
        }
        System.out.println("Adjacency List is : " + adjacencyList);
        printGraph();
    }

    private void addEdge(int v1, int v2) {
        List<Integer> temp = adjacencyList.get(v1);
        temp.add(v2);
    }

    boolean[] isVisited = new boolean[4];
    public void dfs(int curr_vertex) {
        System.out.println(curr_vertex);
        isVisited[curr_vertex] = true;
        List<Integer> neighbors = adjacencyList.get(curr_vertex);
        for (int currentNeighbor : neighbors) {
            if (!isVisited[currentNeighbor])
                dfs(currentNeighbor);
        }
    }

    //No. of connected components:
    public void connectedComponents() {
        int components = 0;
        for(int i=0; i<adjacencyList.size(); i++) {
            if(isVisited[i]==false) {
                dfs(i);
                components++;
            }
        }
    }

    //Find a cycle in the graph
    int[] color = new int[4];
    public boolean dfsToDetectCycle(int curr_vertex) {
        color[curr_vertex] = 1; // Grey

        List<Integer> neighbors = adjacencyList.get(curr_vertex);
        for (int currentNeighbor : neighbors) {

            if (color[currentNeighbor] == 1) {
                return true;
            }

            if (color[currentNeighbor] == 0 && dfsToDetectCycle(currentNeighbor)) {
                return true;
            }
        }
        color[curr_vertex] = 2; // Black
        return false;
    }

    // A utility function to print the adjacency list
    // representation of graph
    public void printGraph() {
        for (int i = 0; i < adjacencyList.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> " + adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }

}
