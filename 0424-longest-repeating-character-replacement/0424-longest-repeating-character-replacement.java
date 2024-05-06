class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0; 
        int result = 0;
        int maxFreq=-1;
        for(int i = 0; i<s.length() ;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
             maxFreq = Math.max(maxFreq, map.get(s.charAt(i)));
            while((i-left+1) - maxFreq > k){ //invalid window
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            result = Math.max(result, i-left+1);
        }
        return result;        
    }
}