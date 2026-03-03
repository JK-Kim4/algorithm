import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder(N);

        int repeat = N / 3;
        int remain = N % 3;

        for (int i = 0; i < repeat; i++) {
            sb.append("SSH");
        }

        for (int i = 0; i < remain; i++) {
            sb.append('S');
        }

        System.out.println(sb);
    }
}