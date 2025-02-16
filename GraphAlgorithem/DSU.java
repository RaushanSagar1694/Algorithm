
import java.util.*;

// Disjoin Set Union
public class DSU {

    // Find Using Path compression
    public static int find(int x, int[] parent){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    //Union Using Rank 
    public static void union(int x, int y, int[] parent, int[] rank){

        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] > rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
    public static void dsu(int[][] edges , int V){
        int[] rank = new int[V];
        int[] parent = new int[V];

        for(int i = 0; i < V; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        //adjcency list
        for(int[] t : edges){
            int u = t[0];
            int v = t[1];

            union(u, v, parent, rank);
        }

        // Print final parent array
        System.out.println("Parent array after union operations: " + Arrays.toString(parent));
    }
    public static void main(String[] args) {
        int V = 5; // Number of nodes
        int[][] edges = { {0, 1}, {1, 2}, {3, 4} };

        dsu(edges, V);

        // Check if two nodes belong to the same set
        System.out.println("Find(0): " + find(0, new int[] {0, 0, 1, 3, 3})); 
        System.out.println("Find(2): " + find(2, new int[] {0, 0, 1, 3, 3}));
    }
}
