import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        String input = br.readLine().trim();

        List<String> grades = parseGrades(input);

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i == 0) builder.append(convert(null, grades.get(i)));
            else builder.append(convert(grades.get(i-1), grades.get(i)));
        }

        System.out.println(builder.toString());

    }

    private static List<String> parseGrades(String input) {
        List<String> grades = new ArrayList<>();
        int i = 0;

        while (i < input.length()) {
            char base = input.charAt(i);

            if (base != 'A' && base != 'B' && base != 'C') {
                throw new IllegalArgumentException("잘못된 입력 형식: " + input);
            }

            if (i + 1 < input.length()) {
                char next = input.charAt(i + 1);

                if (next == '+' || next == '-') {
                    grades.add("" + base + next);
                    i += 2;
                    continue;
                }

                if (next == '0') {
                    grades.add(String.valueOf(base));
                    i += 2;
                    continue;
                }
            }

            grades.add(String.valueOf(base));
            i++;
        }

        return grades;
    }

    private static char convert(String prev, String curr) {

        if (curr.startsWith("C")) {
            return 'B';
        }

        if (curr.equals("B") || curr.equals("B-")) {
            if (prev == null || prev.startsWith("C")) {
                return 'D';
            }
            return 'B';
        }

        if (curr.equals("A-") || curr.equals("B+")) {
            if (prev != null && (prev.startsWith("A") || prev.equals("B+"))) {
                return 'D';
            }
            return 'P';
        }

        if (curr.equals("A")) {
            if (prev != null && (prev.equals("A+") || prev.equals("A"))) {
                return 'P';
            }
            return 'E';
        }

        return 'E';
    }

}