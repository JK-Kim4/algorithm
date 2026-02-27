import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine().trim());

        int[][] delays = new int[count][2];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            delays[i][0] = Integer.parseInt(st.nextToken());
            delays[i][1] = Integer.parseInt(st.nextToken());
        }

        int end = Integer.MAX_VALUE;
        int start = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            // 가장 짧은 end 점, 가장 긴 start점
            end = Math.min(end, delays[i][1]);
            start = Math.max(start, delays[i][0]);
        }

        System.out.println(Math.max(start - end, 0));
    }
}
