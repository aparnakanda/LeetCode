class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i=i+2){
            res[i]=nums[i+1];
            res[i+1]=nums[i];
        }
        return res;
    }
}