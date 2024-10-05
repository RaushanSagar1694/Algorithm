package Graph;

import java.util.*;

public class TopologicalSort {
    public static void DFS(int u, HashMap<Integer, List<Integer>> adj, boolean[] vis, Stack<Integer> s){
        vis[u] = true;

        if(adj.containsKey(u)){

            for(int v : adj.get(u)){
                
                if(!vis[v]){
                    DFS(v, adj, vis, s);
                }
            }
        }

        s.push(u);
    }
    public static List<Integer> findTopologicalSort(int V, int[][] list){
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        // make adj list
        for(int[] k : list){
            int u = k[0];
            int v = k[1];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }

            adj.get(u).add(v);
        }

        Stack<Integer> s = new Stack<>();
        boolean[] vis =  new boolean[V];

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                DFS(i, adj, vis, s);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(!s.isEmpty()){
            int val = s.pop();

            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] list = {{0,3}, {0,2}, {1,4}, {2,3}, {2,1}, {3,1}, {5,1}, {5, 4}};
        int V = 6;
        List<Integer> result = findTopologicalSort(V, list);

        System.out.println(result+"topologicalSort");
        
    }
}
