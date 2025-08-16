class Solution {
    public int maximum69Number (int num) {
       int temp=num;
       int index=-1;
       int pos=0;
       while(temp>0){
        if(temp%6==0){
            index=pos;
        }
        temp/=10;
        pos++;
       }
       if(index==-1) return num;
       return num+3*(int)Math.pow(10,index);
    }
}