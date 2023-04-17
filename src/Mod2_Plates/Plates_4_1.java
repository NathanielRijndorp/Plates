package Mod2_Plates;

import java.util.LinkedList;
import java.util.Scanner;

public class Plates_4_1 {
    private int V;
    private LinkedList<Integer>[] adj;

    Plates_4_1(int V) {
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isConnected() {
        boolean[] visited = new boolean[V];
        dfs(0, visited);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int i : adj[v]) {
            if (!visited[i]) {
                dfs(i, visited);
            }
        }
    }

    int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter G(V,E).");
        int V = sc.nextInt();
        int E = sc.nextInt();
        while(E > V) {
            System.out.println("Invalid input! Resetting Values...");
            V = sc.nextInt();
            E = sc.nextInt();
        }
        Plates_4_1 g = new Plates_4_1(V);
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }
        if (g.isConnected()) {
            System.out.println("The graph is connected");
        } else {
            int count = g.countComponents();
            System.out.println("The graph is not connected");
            System.out.println("It has " + count + " connected components");
        }
    }
}
