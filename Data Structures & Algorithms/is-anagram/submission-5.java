class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> count = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            count.put(sChar, count.getOrDefault(sChar, 0) + 1);
            count.put(tChar, count.getOrDefault(tChar, 0) - 1);
        }

        for(int value : count.values()){
            if(value != 0){
                return false;
            }
        }
        return true;
    }
}

//Using only one HashMap
//Time: O(n + m)
