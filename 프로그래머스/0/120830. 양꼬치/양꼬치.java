class Solution {
    public int solution(int n, int k) {
        int SHEEP = 12000;
        int BEVERAGE = 2000;
        int freeBeverage = n / 10;
        return SHEEP * n + BEVERAGE * (k - freeBeverage);
    }
}