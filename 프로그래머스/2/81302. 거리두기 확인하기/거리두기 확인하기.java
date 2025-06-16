class Solution {
    private static final int[] dx = {0, -1, 1, 0};
    private static final int[] dy = {-1, 0, 0, 1};
    
    
    //3. 맨해튼 거리 1만큼 위치에 응시자가 존재하는가
    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if (room[y][x] != 'P') continue;
                if (!isDistanced(room, x, y)) return false;
            }
        }
        return true; //X일 경우
    }
    
    //4. 3에서 현재 위치에 응시자가 존재할 경우 인접한 거리에 또다른 응시자가 존재하는가
    private boolean isDistanced(char[][] room, int x, int y){
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            //room의 범위 안에 있는가
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) continue;
            
            switch (room[ny][nx]) {
                case 'P': return false; //인접 영역에 응시자가 존재하는 경우
                case 'O': 
                    //테이블이 존재할 경우 현재 위치에서 맨하탄 거리 1에 P가 존재하는지 검증
                    if (isNextToVolunteer(room, nx, ny, 3-d)) return false; //3-d: 3에서 현재 해당하는 인덱스를 차감한 경우 반대편 위치가 나옴
                    break;
            }
        }
        return true; //X일 경우 
    }
    
    private boolean isNextToVolunteer(char[][] room, int x, int y, int exclude) {
        for (int d = 0; d < 4; d++) {
            if (d == exclude) continue;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            //room의 범위 안에 있는가
            if (ny < 0 || ny >= room.length || nx < 0 || nx >= room[ny].length) 
                continue;
            if (room[ny][nx] == 'P') return true;
        }
        return false;
    }
    
    public int[] solution(String[][] places) {    
        int[] answer = new int[places.length];
        for (int i = 0; i < answer.length; i++) {
            String[] place = places[i];
            char[][] room = new char[place.length][];
            for (int j = 0; j < room.length; j++) {
                room[j] = place[j].toCharArray();
            }
            if (isDistanced(room)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }
}