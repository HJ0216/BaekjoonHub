import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int input = n;

        while(input > 0){
            answer += input%10;
            input /= 10; 
        }

        return answer;
    }
}