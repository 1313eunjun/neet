class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        //key: String, value: List<String>
        for(String s : strs){
            char[] chars = s.toCharArray();
            //"eat" -> ['e', 'a', 't']
            Arrays.sort(chars);
            //['a', 'e', 't']
            String key = new String(chars);
            //['a', 'e', 't'] -> "aet"
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            //"aet" -> []
            map.get(key).add(s);
            //"aet" -> ["eat"]
        }
        return new ArrayList<>(map.values());
    }
}

//Sorting
//Time: O(n * klogk)
//Space: O(k * n)