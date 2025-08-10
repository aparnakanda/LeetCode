class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int cent=0;cent<n;cent++){
            int left=cent;
            int right=cent;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
        for(int cent=0;cent<n;cent++){
            int left=cent;
            int right=cent+1;
            while(left>=0 && right<n && s.charAt(left)==s.charAt(right)){
                count++;
                left--;
                right++;
            }
        }
      return count;
    }
}