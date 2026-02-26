import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];
        int count0 = 0;
        int count1 = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                matrix[i][j] = value;

                if (value == 0) {
                    count0++;
                } else {
                    count1++;
                }
            }
        }

        boolean hasSameAdjacentPair = false;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (j + 1 < M && matrix[i][j] == matrix[i][j + 1]) {
                    hasSameAdjacentPair = true;
                    break;
                }

                if (i + 1 < N && matrix[i][j] == matrix[i + 1][j]) {
                    hasSameAdjacentPair = true;
                    break;
                }
            }

            if (hasSameAdjacentPair) {
                break;
            }
        }

        if (count0 % 2 == 0 && count1 % 2 == 0 && hasSameAdjacentPair) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
    }
}