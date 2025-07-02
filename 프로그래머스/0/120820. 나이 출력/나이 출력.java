class Solution {
    public int solution(int age) {
        int BASE_YEAR = 2022;
        int birthYear = BASE_YEAR - age + 1;
        return birthYear;
    }
}