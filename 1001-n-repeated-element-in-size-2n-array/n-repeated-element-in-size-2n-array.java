class Solution {
    public int repeatedNTimes(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
          if(set.contains(nums[i])){
            return nums[i];
          }
          else{
            set.add(nums[i]);
          }
        }
        return -1;
    }
}