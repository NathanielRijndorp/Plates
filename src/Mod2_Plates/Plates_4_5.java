package Mod2_Plates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Plates_4_5 {

    // Returns true if the graph is bipartite, false otherwise
    public static boolean isBipartite(List<List<Integer>> graph) {
        int n = graph.size();
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {
                if (!dfs(i, 0, colors, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Returns true if the subgraph starting at node u is bipartite, false otherwise
    private static boolean dfs(int u, int color, int[] colors, List<List<Integer>> graph) {
        colors[u] = color;
        for (int v : graph.get(u)) {
            if (colors[v] == -1) {
                if (!dfs(v, 1 - color, colors, graph)) {
                    return false;
                }
            } else if (colors[v] == color) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        if (isBipartite(graph)) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }
    }
}
