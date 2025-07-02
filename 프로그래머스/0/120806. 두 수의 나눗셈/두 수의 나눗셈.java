class Solution {
    public int solution(int num1, int num2) {
        double quotient = (double) num1 / num2;
        int answer = (int)(quotient * 1000);
        return answer;
    }
}