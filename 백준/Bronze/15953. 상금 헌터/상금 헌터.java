import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int first = PrizeCalculator.prizeOf(a, First.values());
            int second = PrizeCalculator.prizeOf(b, Second.values());

            sb.append((first + second) * 10_000).append('\n');
        }
        System.out.print(sb);
    }

    interface PrizeTier {
        int getCount(); // 해당 구간 인원 수
        int getPrize(); // 상금(만원 단위)
    }

    static final class PrizeCalculator {
        private PrizeCalculator() {}

        static int prizeOf(int rank, PrizeTier[] tiers) {
            if (rank <= 0) return 0; // 0: 미진출(상금 없음)

            int cumulative = 0;
            for (PrizeTier tier : tiers) {
                cumulative += tier.getCount();
                if (rank <= cumulative) return tier.getPrize();
            }
            return 0; // 구간 밖
        }
    }

    enum First implements PrizeTier {
        FIRST(1, 500),
        SECOND(2, 300),
        THIRD(3, 200),
        FOURTH(4, 50),
        FIFTH(5, 30),
        SIXTH(6, 10);

        private final int count;
        private final int prize;

        First(int count, int prize) {
            this.count = count;
            this.prize = prize;
        }

        @Override public int getCount() { return count; }
        @Override public int getPrize() { return prize; }
    }

    enum Second implements PrizeTier {
        FIRST(1, 512),
        SECOND(2, 256),
        THIRD(4, 128),
        FOURTH(8, 64),
        FIFTH(16, 32);

        private final int count;
        private final int prize;

        Second(int count, int prize) {
            this.count = count;
            this.prize = prize;
        }

        @Override public int getCount() { return count; }
        @Override public int getPrize() { return prize; }
    }
}