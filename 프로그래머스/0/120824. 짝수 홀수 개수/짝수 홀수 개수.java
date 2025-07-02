class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        
        int countEven = 0;
        for(int num : num_list){
            if(num % 2 == 0) countEven++;
        }
        
        answer[0] = countEven;
        answer[1] = num_list.length - countEven;
        
        return answer;
    }
}