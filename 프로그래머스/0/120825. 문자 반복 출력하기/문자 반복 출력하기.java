class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] chars = my_string.toCharArray();
        
        for(char c : chars){
            for(int i=0; i<n; i++){
                sb.append(c);                
            }
        }
        
        return sb.toString();
    }
}