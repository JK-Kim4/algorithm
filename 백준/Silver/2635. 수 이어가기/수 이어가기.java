import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> best = new ArrayList<>();

        for (int second = n; second >= 0; second--) {
            List<Integer> current = generateSequence(n, second);

            if (current.size() > best.size()) {
                best = current;
            }
        }

        System.out.println(best.size());
        for (int i = 0; i < best.size(); i++) {
            System.out.print(best.get(i));
            if (i < best.size() - 1) {
                System.out.print(" ");
            }
        }
    }

    private static List<Integer> generateSequence(int first, int second) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(first);
        sequence.add(second);

        while (true) {
            int size = sequence.size();
            int next = sequence.get(size - 2) - sequence.get(size - 1);

            if (next < 0) {
                break;
            }

            sequence.add(next);
        }

        return sequence;
    }
}