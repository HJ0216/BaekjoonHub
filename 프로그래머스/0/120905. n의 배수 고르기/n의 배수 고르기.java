class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        for(int num : numlist){
            if(num % n == 0) count += 1;
        }
        
        int[] answer = new int[count];
        int index = 0;
        for(int i=0; i<numlist.length; i++){
            if(numlist[i] % n == 0) answer[index++] = numlist[i];
        }
        
        return answer;
    }
}