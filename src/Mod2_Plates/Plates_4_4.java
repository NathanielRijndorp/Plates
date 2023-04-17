package Mod2_Plates;

import java.util.Scanner;

public class Plates_4_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = input.nextInt();

        // Create an array to store the degree of each vertex
        int[] degreeArray = new int[numVertices];

        System.out.print("Enter the number of edges: ");
        int numEdges = input.nextInt();

        // Loop through each edge and update the degree of its two vertices
        for (int i = 0; i < numEdges; i++) {
            System.out.print("Enter edge " + (i+1) + ": ");
            int vertex1 = input.nextInt() - 1; // Subtract 1 since arrays are 0-indexed
            int vertex2 = input.nextInt() - 1;

            degreeArray[vertex1]++;
            degreeArray[vertex2]++;
        }

        // Output the degree of each vertex
        System.out.println("Vertex\tDegree");
        for (int i = 0; i < numVertices; i++) {
            System.out.println((i+1) + "\t" + degreeArray[i]);
        }
    }
}
