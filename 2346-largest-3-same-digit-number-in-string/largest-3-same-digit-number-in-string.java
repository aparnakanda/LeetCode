class Solution {
    public String largestGoodInteger(String num) {
        int n=num.length();
        char maxDigit=' ';
        int count=1;
        for(int i=1;i<n;i++){
            if(num.charAt(i)==num.charAt(i-1)){
                count++;
                if(count==3){
                    if(maxDigit==' ' || num.charAt(i)>maxDigit){
                        maxDigit=num.charAt(i);
                    }
                }
            }
            else{
                count=1;
            }
        }
        return maxDigit==' '?"":String.valueOf(maxDigit).repeat(3);
    }
}