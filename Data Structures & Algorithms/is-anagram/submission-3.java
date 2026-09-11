class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> countS = new HashMap<>();
        Map<Character, Integer> countT = new HashMap<>();

        for(int i= 0; i < s.length(); i++){
            countS.put(s.charAt(i),
                countS.getOrDefault(s.charAt(i), 0) + 1);

            countT.put(t.charAt(i),
                countT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countS.equals(countT);
    }
}

//HashMap
//charAt(i): String 에서 특정 위치의 글자를 가져옴
//HashMap<Character, Integer>: Character -> Integer
//countS.getOrDefault(s.charAt(i), 0) + 1: Map 에 'a' 가 아직 없으면 0 -> 0 + 1 = 1 => a -> 1
//countS.put(key, value): 'a' -> 1
//Time: O(n + m)
