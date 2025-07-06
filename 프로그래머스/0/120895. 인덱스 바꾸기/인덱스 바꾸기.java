class Solution {
    public String solution(String my_string, int num1, int num2) {
        String answer = "";
        
        String str1 = my_string.charAt(num1)+"";
        String str2 = my_string.charAt(num2)+"";

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<my_string.length(); i++){
            if(i==num1)
                sb.append(str2);
            else if(i==num2)
                sb.append(str1);
            else
                sb.append(my_string.charAt(i));
        }
        
        return sb.toString();
    }
}