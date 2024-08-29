class Solution {
    public boolean checkValidString(String s) {
        int left =0, right=s.length()-1;
        int open=0,close=0;
        
        while(left<s.length() && right>=0){
            if(s.charAt(left) == '(' || s.charAt(left) == '*'){
                open++;
            }
            else{
                open--;
            }
            
            if(s.charAt(right) == ')' || s.charAt(right) == '*'){
                close++;
            }
            else{
                close--;
            }
            
            left++;
            right--;
            
            if(open < 0 || close <0) return false;
        }
            return true;
        
    }
}