class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length()==0) return 0;
        
       HashSet<Character> sett = new HashSet<>();
        
        int left = 0;
        int result = 0;
        
        for(int i = 0; i<s.length();i++){
            Character c  = s.charAt(i);
            while(sett.contains(c)){
                sett.remove(s.charAt(left));
                left++;

            }
            sett.add(c);
            result = Math.max(result, i-left+1);
        }
    return result;
    }
}