import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class DictionaryEntry {
        String word;
        String meaning;
        char firstChar;

        DictionaryEntry(String word, String meaning) {
            this.word = word;
            this.meaning = meaning;
            this.firstChar = word.charAt(0);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<DictionaryEntry> dictionary = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String word = st.nextToken();
            String meaning = st.nextToken();
            dictionary.add(new DictionaryEntry(word, meaning));
        }

        Collections.sort(dictionary, Comparator.comparing(entry -> entry.word));

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String sentence = br.readLine();
            boolean found = false;
            StringBuilder lineResult = new StringBuilder();

            for (int start = 0; start < sentence.length(); start++) {
                char current = sentence.charAt(start);

                for (DictionaryEntry entry : dictionary) {
                    if (entry.firstChar != current) {
                        continue;
                    }

                    if (start + entry.word.length() <= sentence.length()
                            && sentence.startsWith(entry.word, start)) {
                        lineResult.append(entry.meaning);
                        found = true;
                    }
                }
            }

            if (!found) {
                answer.append("-1");
            } else {
                answer.append(lineResult);
            }
            answer.append('\n');
        }

        System.out.print(answer);
    }
}