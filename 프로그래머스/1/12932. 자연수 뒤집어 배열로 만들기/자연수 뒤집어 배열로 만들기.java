import java.util.*;

class Solution {
    public int[] solution(long n) {
        String num = String.valueOf(n);
        char[] reverseNums = new StringBuilder(num).reverse().toString().toCharArray();

        int[] answer = new int[reverseNums.length];

        for(int i=0; i<answer.length; i++){
            answer[i] = reverseNums[i] - '0';
        }

        return answer;
    }
}