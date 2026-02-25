import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] candidates = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            candidates[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] friends = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            friends[Integer.parseInt(st.nextToken())] = true;
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            if (!friends[candidates[i]]) { result++; }
        }

        System.out.println(result);
    }
}
