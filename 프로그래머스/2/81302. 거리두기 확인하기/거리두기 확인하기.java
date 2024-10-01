import java.util.*;

class Solution {
   private static final int dx[] = {0, -1, 1, 0};
   private static final int dy[] = {-1, 0, 0, 1};

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
    
    private boolean isDistanced(char[][] room) {
        for (int y = 0; y < room.length; y++) {
            for (int x = 0; x < room[y].length; x++) {
                if(room[y][x] != 'P')
                    continue;

                if(!isDistanced(room, y, x))
                    return false;
            }
        }
        
        return true;
    }

    private boolean isDistanced(char[][] room, int currentY, int currentX) {
        for (int d = 0; d < 4; d++) {
            int nextY = currentY + dy[d];
            int nextX = currentX + dx[d];

            if(nextY < 0 || nextY >= room.length || nextX < 0 || nextX >= room[nextY].length)
                continue;

            switch (room[nextY][nextX]){
                case 'P': return false;
                case 'O':
                    if(isNextToVolunteer(room, nextX, nextY, 3-d))
                        return false;
                    break;
            }
        }

        return true;
    }

    private boolean isNextToVolunteer(char[][] room, int nextX, int nextY, int exclude) {
        for (int d = 0; d < 4; d++) {
            if(d == exclude)
                continue;

            int twoSpacesY = nextY + dy[d];
            int twoSpacesX = nextX + dx[d];

            if(twoSpacesY<0 || twoSpacesY >= room.length || twoSpacesX<0 || twoSpacesX >= room[twoSpacesY].length)
                continue;

            if(room[twoSpacesY][twoSpacesX] == 'P')
                return true;
        }

        return false;
    }
}