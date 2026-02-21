import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FastTok ft = new FastTok(br);

        int count = ft.nextInt();
        List<Matrix> matrices = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            int row = ft.nextInt();
            int col = ft.nextInt();

            Matrix mat = new Matrix(row, col);

            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    mat.values[r][c] = ft.nextInt(); // 줄바꿈/공백 섞여도 안전
                }
            }

            matrices.add(mat);
        }

        if (!Matrix.canMultiplyChain(matrices)) {
            System.out.println(-1);
            return;
        }

        int[][] result = Matrix.multiplyMod(matrices);

        long sum = 0;
        for (int[] row : result) {
            for (int v : row) {
                sum += v;
                if (sum >= MOD) sum -= MOD; // sum %= MOD 보다 빠름
            }
        }

        System.out.println(sum % MOD);
    }

    // 줄/공백에 상관없이 "다음 정수"를 안전하게 꺼내는 토크나이저
    static final class FastTok {
        private final BufferedReader br;
        private StringTokenizer st;

        FastTok(BufferedReader br) {
            this.br = br;
        }

        int nextInt() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) throw new EOFException();
                st = new StringTokenizer(line);
            }
            return Integer.parseInt(st.nextToken());
        }
    }

    static final class Matrix {
        final int[][] values;
        final int row;
        final int col;

        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
            this.values = new int[row][col];
        }

        static boolean canMultiplyChain(List<Matrix> matrices) {
            if (matrices == null || matrices.isEmpty()) return false;
            for (int i = 0; i < matrices.size() - 1; i++) {
                if (matrices.get(i).col != matrices.get(i + 1).row) return false;
            }
            return true;
        }

        // 연쇄 곱(모듈러 포함)
        static int[][] multiplyMod(List<Matrix> matrices) {
            int[][] acc = matrices.get(0).values;
            for (int i = 1; i < matrices.size(); i++) {
                acc = multiplyTwoMod(acc, matrices.get(i).values);
            }
            return acc;
        }

        // (aRows x aCols) * (aCols x bCols) => (aRows x bCols)
        private static int[][] multiplyTwoMod(int[][] a, int[][] b) {
            int aRows = a.length;
            int aCols = a[0].length;
            int bRows = b.length;
            int bCols = b[0].length;

            if (aCols != bRows) {
                throw new IllegalArgumentException("dimension mismatch: " + aCols + " != " + bRows);
            }

            int[][] res = new int[aRows][bCols];

            // res[i][j] = sum_k (a[i][k] * b[k][j]) % MOD
            for (int i = 0; i < aRows; i++) {
                for (int k = 0; k < aCols; k++) {
                    long aik = a[i][k];
                    if (aik == 0) continue;
                    for (int j = 0; j < bCols; j++) {
                        long v = res[i][j] + aik * b[k][j];
                        res[i][j] = (int) (v % MOD);
                    }
                }
            }
            return res;
        }
    }
}