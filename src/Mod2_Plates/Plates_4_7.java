package Mod2_Plates;

import java.util.Scanner;

public class Plates_4_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of vertices and edges
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt();

        // Initialize the incidence matrix
        int[][] incidenceMatrix = new int[n][m];

        // Read the vertex pairs and edge weights
        for (int i = 0; i < m; i++) {
            System.out.printf("Enter the vertex pair for edge %d: ", i + 1);
            int u = sc.nextInt();
            int v = sc.nextInt();
            System.out.printf("Enter the number of times edge %d appears: ", i + 1);
            int w = sc.nextInt();

            // Update the incidence matrix
            incidenceMatrix[u-1][i] = w;
            incidenceMatrix[v-1][i] = w;
        }

        // Print the incidence matrix
        System.out.println("The incidence matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
