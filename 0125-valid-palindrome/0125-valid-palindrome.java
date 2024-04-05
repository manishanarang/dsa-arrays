class Solution {
    public boolean isPalindrome(String s) {
        s = cleanString(s);
        int i = 0, j = s.length()-1;

        while(i<j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public String cleanString(String s){
        s = s.toLowerCase();
        s = s.strip();
        StringBuilder str = new StringBuilder();
        

        for(int i = 0; i <s.length();i++){
            char ch = s.charAt(i);
            if((ch >= 'a' && ch<='z')  || (ch >='0' && ch <= '9')){
                str.append(ch);
            }
        }
        return str.toString();
    }
}