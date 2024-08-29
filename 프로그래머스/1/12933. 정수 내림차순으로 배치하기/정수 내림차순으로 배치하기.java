import java.util.*;

class Solution {
    public long solution(long n) {
        char[] charNums = String.valueOf(n).toCharArray();

        Arrays.sort(charNums);

        StringBuilder sb = new StringBuilder();
        for(char c: charNums){
            sb.append(c);
        }

        long answer = Long.parseLong(sb.reverse().toString());
        
        return answer;
    }
}