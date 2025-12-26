import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Maze maze = new Maze(maps);
        return maze.search(0, 0);
    }
}

class Maze {

    private static final int[][] DIRECTIONS = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    private final int[][] maze;
    private final int maxRow, maxColumn;
    private final boolean[][] visited;
    private final int[][] dist;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.maxRow = maze.length;
        this.maxColumn = maze[0].length;
        this.visited = new boolean[maxRow][maxColumn];
        this.dist = new int[maxRow][maxColumn];
    }

    public int search(int startRow, int startColumn) {
        // LinkedList 보다 BFS 큐로는 ArrayDeque가 일반적으로 더 빠름
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;   // ✅ enqueue 시점 방문 처리
        dist[startRow][startColumn] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int row = current[0];
            int col = current[1];

            if (row == maxRow - 1 && col == maxColumn - 1) {
                return dist[row][col];
            }

            for (int[] d : DIRECTIONS) {
                int nextRow = row + d[0];
                int nextCol = col + d[1];

                if (nextRow < 0 || nextRow >= maxRow || nextCol < 0 || nextCol >= maxColumn) {
                    continue;
                }
                if (maze[nextRow][nextCol] == 0) {
                    continue;
                }
                if (visited[nextRow][nextCol]) {
                    continue;
                }

                visited[nextRow][nextCol] = true;                 // ✅ 중복 enqueue 방지
                dist[nextRow][nextCol] = dist[row][col] + 1;
                q.offer(new int[]{nextRow, nextCol});
            }
        }

        return -1;
    }
}
