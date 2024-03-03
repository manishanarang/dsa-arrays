class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String sortedStr = String.valueOf(arr);

            map.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);

        }

        return map.entrySet().stream()
                .map(entry -> entry.getValue())
                .collect(Collectors.toList());
    }


}