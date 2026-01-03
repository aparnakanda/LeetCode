class Solution {
    public int numOfWays(int n) {
        int MOD=1_000_000_007;

        long twoColor=6;
        long threeColor=6;
        for(int i=1;i<n;i++){
            long newTwoColor=(twoColor*3+threeColor*2)%MOD;
            long newThreeColor=(twoColor*2+threeColor*2)%MOD;
            twoColor=newTwoColor;
            threeColor=newThreeColor;
        }
        return (int)((twoColor+threeColor)%MOD);
    }
}