package Mod2_Plates;

import java.util.Scanner;

public class Plates_4_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read in the adjacency matrix
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix (one row at a time):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        // Find the edges and their frequencies
        int[][] edgeCounts = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    edgeCounts[i][j]++;
                    edgeCounts[j][i]++;
                }
            }
        }

        // Print out the edges and their frequencies
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (edgeCounts[i][j] > 0) {
                    String edge = "(" + i + ", " + j + ")";
                    System.out.println(edge + ": " + edgeCounts[i][j]);
                }
            }
        }
    }
}

