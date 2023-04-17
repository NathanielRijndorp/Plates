package Mod2_Plates;

import java.util.Scanner;

public class Plates_4_6 {
    private int[][] matrix;
    private boolean directed;

    public Plates_4_6(int numVertices, boolean directed) {
        matrix = new int[numVertices][numVertices];
        this.directed = directed;
    }

    public void addEdge(int u, int v) {
        matrix[u][v]++;
        if (!directed) {
            matrix[v][u]++;
        }
    }

    public int[][] getAdjacencyMatrix() {
        return matrix;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // read number of vertices and edges
        int numVertices = input.nextInt();
        int numEdges = input.nextInt();

        // create adjacency matrix
        Plates_4_6 graph = new Plates_4_6(numVertices, false);

        // read vertex pairs associated to edges and add them to adjacency matrix
        for (int i = 0; i < numEdges; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            graph.addEdge(u, v);
        }

        // print adjacency matrix
        int[][] matrix = graph.getAdjacencyMatrix();
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
