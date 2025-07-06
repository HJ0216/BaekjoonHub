import java.util.*;

class Solution {
    public String solution(String my_string) {
        String lowerString = my_string.toLowerCase();
        char[] chars = lowerString.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }
}