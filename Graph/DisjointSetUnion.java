


// Disjoint Set Union
public class DisjointSetUnion {
    
    //Find
    public static  int find(int x, int[] parent){
        if(x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x], parent);
    }

    // Union
    public static void union(int x, int y, int[] parent, int[] rank){
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);


        if(x_parent == y_parent) return;


        if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }
        else if(rank[y_parent] < rank[x_parent]){
            parent[x_parent] = y_parent;
        }
        else{
            parent[x_parent] = y_parent;
            rank[y_parent] += 1;
        }
    }
    public static void main(String[] args) {
        
    }
}
