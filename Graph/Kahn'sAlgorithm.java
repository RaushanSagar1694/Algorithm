

import java.util.*;

// Kahn's Algorithm

class KahnsAlgorithm{
    public static List<Integer> KahnsAlgorithm_BFS(int V, int[][] adj){
        int[] Indegree = new int [V];

        //calculate indegree
        for(int[] k : adj){
            for(int val : k){
                Indegree[val]++;
            }
        }

        Queue<Integer> pq = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < V; i++){
            if(Indegree[i] > 0){
                continue;
            }

            pq.add(i);
        }


        //BFS Traversal
        while(!pq.isEmpty()){
            int u = pq.poll();

            //add result
            result.add(u);
            

            for(int v : adj[u]){
                Indegree[v]--;

                if(Indegree[v] == 0){
                    pq.add(v);
                }
            }
        }


        return result;
    }
    public static void main(String[] args) {
        int v = 6;
        int[][] arr = {{2,3}, {4}, {3,1}, {1}, {}, {1,4}};

        List<Integer> result = KahnsAlgorithm_BFS(v, arr);

        System.out.println(result);

    }
}