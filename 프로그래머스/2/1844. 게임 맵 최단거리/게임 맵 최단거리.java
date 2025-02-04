import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        Maze maze = new Maze(maps);
        return maze.bfs(0,0);
    }
}

class Maze {

    int[][] maze;
    int maxRow, maxColumn;
    int[][] visited;
    int[] moveRow = {1, -1, 0, 0};
    int[] moveColumn = {0, 0, 1, -1};



    public Maze(int[][] maze){
        this.maze = maze;
        this.maxRow = maze.length;
        this.maxColumn = maze[0].length;
        this.visited = new int[maze.length][maze[0].length];
    }

    public int bfs(int startRow, int startColumn){
        Queue<int[]> visitedQueue = new LinkedList<>();
        visitedQueue.add(new int[]{startRow,startColumn});
        this.visited[startRow][startColumn] = 1;

        while (visitedQueue.peek() != null){
            int[] current = visitedQueue.poll();
            int currentRow = current[0];
            int currentColumn = current[1];
            
            if(currentRow == maxRow-1 && currentColumn == maxColumn-1){
                return this.visited[currentRow][currentColumn];
            }

            for(int i = 0; i < 4; i++){
                int nextRow = currentRow + moveRow[i];
                int nextColumn = currentColumn + moveColumn[i];
                if(inMaze(nextRow, nextColumn) && this.maze[nextRow][nextColumn] == 1 && this.visited[nextRow][nextColumn] == 0){
                    this.visited[nextRow][nextColumn] = this.visited[currentRow][currentColumn]+1;
                    visitedQueue.add(new int[]{nextRow, nextColumn});
                }

            }
        }


        return -1;
    }

    public boolean inMaze(int row, int column){
        return 0 <= row && row < maxRow && 0 <= column && column < maxColumn;
    }
}