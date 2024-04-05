class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for(char i = 'a'; i<='z';i++){
            map1.put(i,0);
            map2.put(i,0);
        }
        for(int i = 0; i<s1.length();i++){
            map1.put(s1.charAt(i), map1.get(s1.charAt(i))+1);
            map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1);
        }
        if(map1.equals(map2)){
            return true;
        }

        int k = s1.length();
        for(int i = k; i<s2.length();i++){
            char last = s2.charAt(i-k);
            map2.put(s2.charAt(i), map2.get(s2.charAt(i))+1);
            map2.put(last, map2.get(last)-1);

            if(map1.equals(map2)){
                return true;
            }
        }

        return false;

    }
}