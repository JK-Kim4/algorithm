import java.util.*;

class Solution {
    private static class Point {
        private final long x;
        private final long y;
        
        private Point (long x, long y) {
            this.x = x;
            this.y = y;
        }   
    }
    
    private Point findIntersection(long a, long b, long e, long c, long d, long f) {
        double x = (double) (b*f - e*d) / (a*d - b*c);
        double y = (double) (e*c - a*f) / (a*d - b*c);
        
        if ( x % 1 != 0 || y % 1 != 0) return null;
        
        return new Point((long)x, (long)y);
    }
    
    private Point getMinimumPoint(List<Point> points) {
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        
        for (Point p : points) {
            if (minX > p.x) minX = p.x;
            if (minY > p.y) minY = p.y;
        }
        
        return new Point(minX, minY);
        
    }
    
    private Point getMaximumPoint(List<Point> points) {
         long maxX = Long.MIN_VALUE;
         long maxY = Long.MIN_VALUE;
        
        for (Point p : points) {
            if (maxX < p.x) maxX = p.x;
            if (maxY < p.y) maxY = p.y;
        }
        
        return new Point(maxX, maxY);
    }
    
    
    
    public String[] solution(int[][] line) {
        String[] answer = {};
        
        //교점을 담을 변수
        List<Point> intersections = new ArrayList<>();
        
        //lines 순회하며 정수로된 교점 추출
        for (int i = 0; i < line.length-1; i++) {
            for (int j = i+1; j < line.length; j++) {
                //정수 여부 검증
                Point point = findIntersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                
                if (point != null) intersections.add(point);
            } 
        }
        
        //최소 최대 좌표 구하기
        Point minPoint = getMinimumPoint(intersections);
        Point maxPoint = getMaximumPoint(intersections);
        
        int width = (int) (maxPoint.x - minPoint.x + 1);
        int height = (int) (maxPoint.y - minPoint.y + 1);
        
        System.out.println("W = " + width + ", H = " + height);
        
        //grid 초기화
        char[][] grid = new char[height][width];
        for (char[] c : grid) {
            for (int i = 0; i < c.length; i++) {
                c[i] = '.';
            }
        }
        
        for (Point intersection : intersections) {
            int y = (int) (maxPoint.y - intersection.y);
            int x = (int)(intersection.x - minPoint.x); 
            grid[y][x] = '*';
        }
        
        answer = new String[grid.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = new String(grid[i]);
        }

        return answer;
    }
}