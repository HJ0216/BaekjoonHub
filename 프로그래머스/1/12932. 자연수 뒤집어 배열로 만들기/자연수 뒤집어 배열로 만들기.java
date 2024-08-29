import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        String[] reverseNums = new StringBuilder(num).reverse().toString().split("");

        int[] answer = new int[reverseNums.length];

        for(int i=0; i<answer.length; i++){
            answer[i] = Integer.parseInt(reverseNums[i]);
        }
        
        return answer;
    }
}