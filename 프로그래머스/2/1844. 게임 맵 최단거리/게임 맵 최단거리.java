import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        Maze maze = new Maze(maps);
        return maze.search(0,0);
    }
}


class Maze {

    private static final int[][] DIRECTIONS = {
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    int[][] maze;
    int maxRow, maxColumn;
    int[][] dist;

    public Maze(int[][] maze) {
        this.maze = maze;
        this.maxRow = maze.length;
        this.maxColumn = maze[0].length;
        this.dist = new int[maxRow][maxColumn];
    }

    public int search(int startRow, int startColumn) {
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{startRow, startColumn});
        dist[startRow][startColumn] = 1;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
                
            if (current[0] == maxRow-1 && current[1] == maxColumn -1) {
                return dist[current[0]][current[1]];
            }

            for (int[] direction : DIRECTIONS) {
                int nextRow = current[0] + direction[0];
                int nextColumn = current[1] + direction[1];
                
                if (
                    (nextRow >= 0 && nextRow < maxRow)
                    && (nextColumn >= 0 && nextColumn < maxColumn)
                    && maze[nextRow][nextColumn] == 1 
                    && dist[nextRow][nextColumn] == 0
                   ) {
                    dist[nextRow][nextColumn] = dist[current[0]][current[1]] + 1;
                    q.offer(new int[]{nextRow, nextColumn});
                }
            }
        }
        return -1;
    }

}
