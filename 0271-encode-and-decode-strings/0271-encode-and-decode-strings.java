public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        String result = "";
        for(String s : strs){
            s = String.valueOf(s.length()) + "$" + s;
            result += s;
        }
        return result;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result= new ArrayList<>();
        
        for(int i = 0; i<s.length();){
            int j = i;
            while(j< s.length() && s.charAt(j)!='$'){
                j++;
            }
            int n = Integer.parseInt(s.substring(i, j));
            String each = s.substring(j+1, j+1+n);
            result.add(each);
            i = j+1+n;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));