class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;

        // HashMap<Character, Integer> map = new HashMap<>();
        
        // for(int i = 0; i<s.length();i++){
        //     map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        //     map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
        // }

        // for(Character ch : map.keySet()){
        //     if(map.get(ch)!=0) return false;
        // }

        // return true;

        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");
        int[] sCount = new int[26];
        int[] tCount = new int[26];
        Arrays.fill(sCount, 0);
        Arrays.fill(tCount, 0);

        for(int i = 0; i<s.length();i++){
            sCount[s.charAt(i)-'a']++;
            tCount[t.charAt(i)-'a']++;

        }

        for(int i = 0; i<26;i++){
            s1.append("#");
            s1.append(sCount[i]);

            s2.append("#");
            s2.append(tCount[i]);
        }

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
        return s1.toString().equals(s2.toString());

    }

}