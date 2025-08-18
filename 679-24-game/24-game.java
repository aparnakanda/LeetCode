class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> nums=new ArrayList<>();
        for(int card:cards){
            nums.add((double)card);
        }
        return solve(nums);
    }
    private boolean solve(List<Double> nums){
        if(nums.size()==1){
            return Math.abs(nums.get(0)-24)<=0.1;
        }
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i!=j){
                    List<Double> next = new ArrayList<>();
                    for(int k=0;k<nums.size();k++){
                        if(k!=i && k!=j) next.add(nums.get(k));
                    }
                    for(double val:compute(nums.get(i),nums.get(j))){
                        next.add(val);
                        if(solve(next)) return true;
                        next.remove(next.size()-1);
                    }
                }
            }
        }
        return false;
    }
       private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(b - a);
        results.add(a * b);
        if (Math.abs(b) > 0.1) results.add(a / b);
        if (Math.abs(a) > 0.1) results.add(b / a);
        return results;
    }

}