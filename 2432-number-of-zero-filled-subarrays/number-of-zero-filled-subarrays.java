class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count=0;
        long initial=0;
         for(int num:nums){
            if(num==0){
                initial++;
                count+=initial;
            }
            else{
                initial=0;
            }
         }
         return count;
    }
}