class Solution {
    public boolean solution(int x) {
        String[] nToStringArray = String.valueOf(x).split("");
        int sum = 0;
        for (String s : nToStringArray){
            sum += Integer.parseInt(s);
        }
        
        return x%sum == 0;
    }
}