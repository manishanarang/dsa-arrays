class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0; 
        int result = 0;
        
        for(int i = 0; i<s.length() ;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            
            int maxFreq = map.values()
                .stream()
                .mapToInt(l->l)
                .max().getAsInt();
            while((i-left+1) - maxFreq > k){
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            result = Math.max(result, i-left+1);
        }
        return result;        
    }
}