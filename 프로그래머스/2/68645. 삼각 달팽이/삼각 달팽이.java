import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;

        int x = 0, y = 0;

        while (true) {
            // 아래
            while (true) {
                triangle[y][x] = value++;
                if(((y+1) == n) || (triangle[y+1][x] != 0))
                    break;
                y++;
            }

            if(((x+1) == n) || (triangle[y][x+1] != 0))
                // (x+1) == n: n=1일 경우
                break;
            x++;

            // 오른쪽
            while (true) {
                triangle[y][x] = value++;
                if(((x+1) == n) || (triangle[y][x+1] != 0))
                    break;
                x++;
            }

            if(triangle[y-1][x-1] != 0)
                break;

            y--;
            x--;

            // 왼쪽 위
            while (true) {
                triangle[y][x] = value++;

                if(triangle[y-1][x-1] != 0)
                    break;

                y--;
                x--;
            }

            if(((y+1) == n) || (triangle[y+1][x] != 0))
                break;
            y++;
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