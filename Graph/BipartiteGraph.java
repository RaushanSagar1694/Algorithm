

import  java.util.*;

 class BipartiteGraph{



    // checking Bipartite Graph in BFS
    
    public boolean checkBipartiteBFS(int i, HashMap<Integer, List<Integer>> adj, int[] color, int currColor){
        Queue<Integer> pq = new LinkedList<>();
        pq.add(i);
        color[i] = currColor;

        while(!pq.isEmpty()){
            int u = pq.remove();

            for(int v : adj.get(u)){
                if(color[v] == color[u]){
                    return false;
                }

                if(color[v] == -1){
                    color[v] = 1 - color[u];
                    pq.add(v);
                }
            }
        }
        


        return true;
    }
    public boolean isBipartite(int[][] graph) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int n = graph.length;

        for(int i = 0; i < graph.length; i++){
            adj.put(i, new ArrayList<>());
            for(int v : graph[i]){
                adj.get(i).add(v);
            }
        }

        int[] color = new int [n];
        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++){

            if(color[i] == -1){
                if(checkBipartiteBFS(i, adj, color, 1) == false){
                    return false;
                }
            }
        }


        return true;
    }





    // checking Bipartite Graph in DFS

    public static boolean checkBipartiteDFS(int u, HashMap<Integer, List<Integer>> adj, int[] color, int currColor){
        color[u] = currColor;

        if(adj.containsKey(u)){

            for(int v : adj.get(u)){

                if(color[v] == currColor) return false;

                if(color[v] == -1){
                    int newColor  = 1 - currColor;

                    if(checkBipartiteDFS(v, adj, color, newColor) == false){
                        return false;
                    }
                }
            }
        }

        return true;
    }
    public static boolean  DFS(int[][] list, int n){
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        //make adj
        for(int[] k : list){
            int u = k[0];
            int v = k[1];

            if(!adj.containsKey(u)){
                adj.put(u, new ArrayList<>());
            }
            if(!adj.containsKey(v)){
                adj.put(v, new ArrayList<>());
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] color = new int[n];
        Arrays.fill(color, -1);


        for(int i = 0; i < n; i++){

            if(color[i] != -1) continue;
            if(checkBipartiteDFS(i, adj, color, 0) == false){
                return false;
            }

        }


        return true;
    }
    public static void main(String[] args) {
        int[][] adj =  {{1,2}, {1,3}, {2,1}, {2,4}, {3,1}, {4,2}};
        boolean result = DFS(adj, 5);

        System.out.println(result);
    }
}