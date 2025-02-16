

import java.util.*;

public class findTheShortestPathUsingDijkstra {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //ajcency list
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        
        for(int[] d : edges){
            int u = d[0];
            int v = d[1];
            int w = d[2];
            
            adj.computeIfAbsent(u, k-> new ArrayList<>()).add(new int[]{v, w});
            adj.computeIfAbsent(v, k-> new ArrayList<>()).add(new int[]{u, w});
        }
        
        int[] parent = new int[n+1];
        int[] weight = new int[n+1];
        
        for(int i = 0; i < n+1; i++){
            parent[i] = i;
        }
        Arrays.fill(weight, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 1});
        weight[1] = 0;
        
        
        while(!pq.isEmpty()){
            int[] temp = pq.remove();
            int u = temp[1];
            int w = temp[0];
            
            if(adj.containsKey(u)){
                
                for(int[] d : adj.get(u)){
                    int v = d[0];
                    int newWeg = d[1];
                    
                    if(w+newWeg < weight[v]){
                        weight[v] = w+newWeg;
                        pq.add(new int[]{w+newWeg, v});
                        
                        parent[v] = u;
                    }
                }
            }
        }
        
        if(weight[n] == Integer.MAX_VALUE) return List.of(-1);
        List<Integer> path = new ArrayList<>();
        
        int node = n;
        while(parent[node] != node){
            path.add(node);
            
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
       
        path.add(0, weight[n]);
        return path;
    }
    public static void main(String[] args) {
        
    }
}
