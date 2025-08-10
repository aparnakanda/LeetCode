class Solution {
    public boolean reorderedPowerOf2(int n) {
        Set<String> powerSet=new HashSet<>();
        for(int i=0;i<31;i++){
            String sorted=sortDigits(1<<i);
            powerSet.add(sorted);
        }
        return powerSet.contains(sortDigits(n));
    }
    private String sortDigits(int num){
        char[] arr=String.valueOf(num).toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}