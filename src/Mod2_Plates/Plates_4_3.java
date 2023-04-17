package Mod2_Plates;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Plates_4_3 {
    private static boolean hasCycleUtil(int v, boolean[] visited, boolean[] recStack, List<Integer>[] adj) {
        visited[v] = true;
        recStack[v] = true;

        for (int neighbour : adj[v]) {
            if (!visited[neighbour] && hasCycleUtil(neighbour, visited, recStack, adj))
                return true;
            else if (recStack[neighbour])
                return true;
        }

        recStack[v] = false;
        return false;
    }

    public static boolean hasCycle(List<Integer>[] adj) {
        int n = adj.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (hasCycleUtil(i, visited, recStack, adj))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();

        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        System.out.print("Enter the number of edges: ");
        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            System.out.print("Enter edge " + (i + 1) + ": ");
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
        }

        boolean hasCycle = hasCycle(adj);
        if (hasCycle)
            System.out.println("The graph has a cycle.");
        else
            System.out.println("The graph does not have a cycle.");
    }
}
