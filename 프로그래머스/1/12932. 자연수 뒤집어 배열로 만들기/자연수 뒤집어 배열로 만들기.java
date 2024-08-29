import java.util.*;

class Solution {
    public int[] solution(long n) {
        int length = (int)Math.log10(n) + 1;

        int[] answer = new int[length];

        int index = 0;

        while(n>0){
            int number = Math.floorMod(n, 10);
            answer[index++] = number;
            n /= 10;
        }
        
        return answer;
    }
}