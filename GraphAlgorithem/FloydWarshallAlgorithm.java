

//Floyd Warshall Algorithm

public class FloydWarshallAlgorithm {
    public void floydWarshallAlgorithm(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;

        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(mat[i][j] > Math.min(mat[i][j], mat[i][k]+mat[k][j])){
                        mat[i][j] = Math.min(mat[i][j], mat[i][k]+mat[k][j]);
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        
    }
}
