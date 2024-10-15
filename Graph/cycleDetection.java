

import  java.util.*;

public class cycleDetection {


    // cycle detection BFS
    static class Pair{
        int u;
        int p;
        
        public Pair(int u, int p){
            this.u = u;
            this.p = p;
        }
    }
    private static boolean isCycle(Pair curr, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        
        Queue<Pair> pq = new LinkedList<>();
        pq.add(curr);
        
        
        while(!pq.isEmpty()){
            int n = pq.size();
            
            while(n--> 0){
                Pair temp = pq.remove();
                int u = temp.u;
                int p = temp.p;
                
                vis[u] = true;
                
                for(int v : adj.get(u)){
                    if(v == p) continue;
                    
                    if(vis[v] == true){
                        return true;
                    }
                    
                    pq.add(new Pair(v, u));
                }
            }
        }
        
        return false;
    }
    public static boolean Cycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean [V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i] && isCycle(new Pair(i, -1), adj, vis)){
                return true;
            }
        }
        
        return false;
    }




// DFS cycle detection
private static boolean isCycle(int u, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent){
    vis[u] = true;
    
        
        for(int v : adj.get(u)){
            if(v == parent){
                continue;
            }
            
            if(vis[v] == true){
                return true;
            }
            
            if(isCycle(v, adj, vis, u)){
                return true;
            }
        }
    
    
    return false;
}



// Directed Graph DFS cycle detection
private boolean DFS(int u, HashMap<Integer, List<Integer>> adj, boolean[] vis, boolean[] inRecursive){
    vis[u] = true;
    inRecursive[u] = true;

    //DFS
    if(adj.containsKey(u)){

        for(int v : adj.get(u)){

            if(inRecursive[v] == true){
                return true;
            }
            
            if(!vis[v] && DFS(v, adj, vis, inRecursive)){
                return true;
            }
        }
    }

    inRecursive[u] = false;
    return false;
}
public boolean canFinish(int numCourses, int[][] prerequisites) {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();

    for(int[] k : prerequisites){
        int u = k[0];
        int v = k[1];

        if(!adj.containsKey(v)){
            adj.put(v, new ArrayList<>());
        }

        adj.get(v).add(u);
    }

    boolean[] vis = new boolean[numCourses];
    boolean[] inRecursive = new boolean[numCourses];

    //DFS
    for(int u = 0; u < numCourses; u++){
        if(!vis[u] && DFS(u, adj, vis, inRecursive)){
            return false;
        }
    }

    return true;
}


public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
    boolean[] vis = new boolean [V];
    
    for(int i = 0; i < V; i++){
        if(!vis[i] && isCycle(i, adj, vis, -1)){
            return true;
        }
    }
    
    return false;
}








    public static void main(String[] args) {
        int V =6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        
        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the adjacency list


        isCycle(V, adj);
        
    }
}
