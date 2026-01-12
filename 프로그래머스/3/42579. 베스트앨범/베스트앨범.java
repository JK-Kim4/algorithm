import java.util.*;

class Solution {

    static class Song {
        int idx;
        int plays;

        Song(int idx, int plays) {
            this.idx = idx;
            this.plays = plays;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> totalPlaysByGenre = new HashMap<>();
        Map<String, List<Song>> songsByGenre = new HashMap<>();

        // 1) 데이터 수집
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];

            totalPlaysByGenre.put(genre, totalPlaysByGenre.getOrDefault(genre, 0) + plays[i]);

            songsByGenre.computeIfAbsent(genre, g -> new ArrayList<>())
                       .add(new Song(i, plays[i]));
        }

        // 2) 장르를 총 재생수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(totalPlaysByGenre.keySet());
        sortedGenres.sort((a, b) -> Integer.compare(totalPlaysByGenre.get(b), totalPlaysByGenre.get(a)));

        // 3) 장르별로 최대 2곡 선택
        List<Integer> answerList = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Song> songs = songsByGenre.get(genre);

            songs.sort((s1, s2) -> {
                if (s1.plays != s2.plays) return Integer.compare(s2.plays, s1.plays); // plays desc
                return Integer.compare(s1.idx, s2.idx); // idx asc
            });

            answerList.add(songs.get(0).idx);
            if (songs.size() > 1) answerList.add(songs.get(1).idx);
        }

        // 4) List -> int[]
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
