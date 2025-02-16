import java.util.*;


public class TopologicalSortDFS {
    public static void DFS(HashMap<Integer, List<Integer>> adj, int u, boolean[] vis, Stack<Integer> s){
        vis[u] = true;

        if(adj.containsKey(u)){

            for(int v : adj.get(u)){
                if(!vis[v]){
                    DFS(adj, v, vis, s);
                }
            }
        }


        s.push(u);
    }
    public static  int[] topologicalSort(int[][] list, int V){
        //Adjecency list
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] k : list){
            int u = k[0];
            int v = k[1];

            if(!adj.containsKey(u)) adj.put(u, new ArrayList<>());
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < V; i++){
            if(!vis[i]){
                DFS(adj, i, vis, s);
            }
        }

        int[] result = new int[V];
        int i = 0;

        while(!s.isEmpty()){
            int val = s.pop();
            result[i++] = val;
        }

        return result;
    }
    public static void main(String[] args) {
        int[][] list = {{0, 3}, {0, 2}, {2, 3}, {2, 1}, {3, 1}, {5, 1}, {5, 4}};

        int[] result = topologicalSort(list, 6);
        System.out.println(Arrays.toString(result));
    }
}
