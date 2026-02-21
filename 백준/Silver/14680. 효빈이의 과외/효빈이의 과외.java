import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    
    static final long MOD = 1_000_000_007L;
    
    static BufferedReader br;
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new EOFException();
            st = new StringTokenizer(line);
        }
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        int count = nextInt();
        List<Matrix> matrices = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            int row = nextInt();
            int col = nextInt();

            Matrix mat = new Matrix(row, col);
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    mat.values[r][c] = nextInt();
                }
            }
            matrices.add(mat);
        }

        if (Matrix.canMultiplyChain(matrices)) {
            int[][] result = Matrix.multiply(matrices);

            //모든 원소의 합
            long sum = 0;
            for (int[] ints : result) {
                for (int v : ints) {
                    sum += v;
                    sum %= MOD;
                }
            }
            System.out.println(sum);
        } else {
            System.out.println(-1);
        }
    }


    static class Matrix {

        int[][] values;
        int row;
        int col;

        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
            values = new int[row][col];
        }

        static boolean canMultiplyChain(List<Matrix> matrices) {
            if (matrices == null) return false;
            if (matrices.size() <= 1) return true;

            for (int i = 0; i < matrices.size() - 1; i++) {
                Matrix left = matrices.get(i);
                Matrix right = matrices.get(i + 1);
                if (left.col != right.row) return false;
            }
            return true;
        }

        static int[][] multiply(List<Matrix> matrices) {

            int[][] acc = matrices.get(0).values;

            for (int i = 1; i < matrices.size(); i++) {
                acc = multiplyTwo(acc, matrices.get(i).values);
            }
            return acc;
        }

        private static int[][] multiplyTwo(int[][] a, int[][] b) {
            int aRows = a.length;
            int aCols = a[0].length;
            int bCols = b[0].length;

            int[][] res = new int[aRows][bCols];

            for (int i = 0; i < aRows; i++) {
                for (int k = 0; k < aCols; k++) {
                    long aik = a[i][k];
                    if (aik == 0) continue;
                    for (int j = 0; j < bCols; j++) {
                        long val = (res[i][j] + aik * b[k][j]) % MOD;
                        res[i][j] = (int) val;
                    }
                }
            }
            return res;
        }
    }
}
