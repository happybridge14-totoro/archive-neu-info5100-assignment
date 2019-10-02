package qfour;
import java.util.Arrays;
class Matrices {
    public int[][] calMatrices(int[][] matrixA, int[][] matrixB) {
        // matrixA is m * p;
        // matrixB is p * n;
        // n == o
        // consider that none of the matrix is empty;
        final int m = matrixA.length;
        final int p = matrixA[0].length;
        //final int n = matrixB.length;
        final int n = matrixB[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = 0;
                for (int k = 0; k < p; k++) {
                    tmp += matrixA[i][k] * matrixB[k][j];
                }
                ret[i][j] = tmp;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] matrixA = {{1, 0, 0}, {-1, 0, 3}};
        int[][] matrixB = {{7, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        Matrices test = new Matrices();
        int[][] result = test.calMatrices(matrixA, matrixB);
        System.out.println(Arrays.deepToString(result));
    }
}
