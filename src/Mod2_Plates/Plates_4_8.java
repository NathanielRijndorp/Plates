package Mod2_Plates;

import java.util.Arrays;
import java.util.Scanner;

public class Plates_4_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of vertices for the first graph
        System.out.print("Enter the number of vertices for the first graph: ");
        int n1 = scanner.nextInt();

        // Get the adjacency matrix for the first graph
        System.out.println("Enter the adjacency matrix for the first graph:");
        int[][] graph1 = new int[n1][n1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n1; j++) {
                graph1[i][j] = scanner.nextInt();
            }
        }

        // Get the number of vertices for the second graph
        System.out.print("Enter the number of vertices for the second graph: ");
        int n2 = scanner.nextInt();

        // Get the adjacency matrix for the second graph
        System.out.println("Enter the adjacency matrix for the second graph:");
        int[][] graph2 = new int[n2][n2];
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < n2; j++) {
                graph2[i][j] = scanner.nextInt();
            }
        }

        // Check if the two graphs are isomorphic
        if (isIsomorphic(graph1, graph2)) {
            System.out.println("The two graphs are isomorphic.");
        } else {
            System.out.println("The two graphs are not isomorphic.");
        }

        scanner.close();
    }

    public static boolean isIsomorphic(int[][] graph1, int[][] graph2) {
        if (graph1.length != graph2.length) {
            return false;
        }

        int n = graph1.length;
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
        }

        return isIsomorphicHelper(graph1, graph2, perm, 0);
    }

    private static boolean isIsomorphicHelper(int[][] graph1, int[][] graph2, int[] perm, int index) {
        int n = graph1.length;
        if (index == n) {
            return Arrays.deepEquals(graph1, permute(graph2, perm));
        }

        for (int i = index; i < n; i++) {
            swap(perm, i, index);
            if (isIsomorphicHelper(graph1, graph2, perm, index + 1)) {
                return true;
            }
            swap(perm, i, index);
        }

        return false;
    }

    private static int[][] permute(int[][] graph, int[] perm) {
        int n = graph.length;
        int[][] permuted = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                permuted[perm[i]][perm[j]] = graph[i][j];
            }
        }
        return permuted;
    }

    private static void swap(int[] perm, int i, int j) {
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }
}
