class Solution {
    public String removeDuplicates(String s) {
        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!st.isEmpty() && st.peek()==ch){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        for(char ch:st){
            sb.append(ch);
        }
        return sb.toString();
    }
}