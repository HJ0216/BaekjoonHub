import java.util.*;

class Solution {
    private static final int[] dx = {0, 1, -1};
    private static final int[] dy = {1, 0, -1};

    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;

        int x = 0, y = 0, d = 0;

        while (true) {
            triangle[y][x] = value++;
            int nextX = x + dx[d];
            int nextY = y + dy[d];

            if(nextX == n || nextY == n || nextX == -1 || nextY == -1 || triangle[nextY][nextX] != 0){
                d = (d+1) % 3;
                nextX = x + dx[d];
                nextY = y + dy[d];

                if(nextX == n || nextY == n || nextX == -1 || nextY == -1 || triangle[nextY][nextX] != 0)
                    break;
            }

            x = nextX;
            y = nextY;
        }


        int[] answer = new int[value-1];

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}