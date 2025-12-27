import java.util.*;

class Solution {

    private boolean[] used;
    private List<String> path;
    private String[][] tickets;
    private boolean found;

    public String[] solution(String[][] tickets) {
        this.tickets = tickets;

        // (출발 -> 도착) 사전순 정렬
        Arrays.sort(this.tickets, (a, b) -> {
            int c0 = a[0].compareTo(b[0]);
            if (c0 != 0) return c0;
            return a[1].compareTo(b[1]);
        });

        used = new boolean[this.tickets.length];
        path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", 0);

        return path.toArray(new String[0]);
    }

    private void dfs(String cur, int usedCount) {
        if (found) return; // 이미 정답 찾았으면 더 탐색할 필요 없음

        if (usedCount == tickets.length) {
            found = true; // 모든 티켓 사용 완료
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (used[i]) continue;
            if (!tickets[i][0].equals(cur)) continue;

            used[i] = true;
            path.add(tickets[i][1]);

            dfs(tickets[i][1], usedCount + 1);

            if (found) return; // 정답 경로 확정

            // 백트래킹
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}