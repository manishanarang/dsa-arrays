class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();

        int[] last = new int [26];

        for(int i = 0; i<s.length(); i++){
            last[s.charAt(i)-'a'] = i;
        }

        int end = 0, len=0;
        for(int i = 0; i<s.length();i++){
            end = Math.max(end, last[s.charAt(i)-'a']);
            len++;
            if(i == end){
                result.add(len);
                end = 0;
                len=0;
            }
        }
    
        
        
        return result;
    }
}