class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs){
            int[] count = new int[26];

            for(char c: s.toCharArray()){
                count[c - 'a']++;
            }
            //s = "eat" - > ['e', 'a', 't']
            //c = 'e' - > 'e' - 'a' = 4, count[4] = 1
            StringBuilder keyBuilder = new StringBuilder(); 
            //Java 에서 배열 자체를 그대로 key 로 쓰는게 원하는 방식으로 비교되지않을수있음
            //처음에는 keyBuilder = ""
            for(int num : count){
                keyBuilder.append('#');
                keyBuilder.append(num);
            }
            //첫번째 num 이 1이면 "#1" -> 0 -> "#1#0"
            //숫자만 붙이면 111,11,1,1 서로다른 count 인데 같은 string 이 될수있음
            String key = keyBuilder.toString();
            //"#1#0#0#0#1..." 이걸 실제 String 으로 만들어서 key 에 저장
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            //map 에 key 가 없다면 key -> 빈 리스트 "#1#0#0#0#0#1.." -> []
            map.get(key).add(s);
            //s = "eat" -> "#1#0#0#0#0#1..." - > ["eat"] 
            // => key -> ["eat", "tea"]
        }
            
        return new ArrayList<>(map.values());
        //key 1 -> ["eat", "tea"] => [["eat", "tea"]]
    }
}
//Character Count
//Time: O(n * k)
//Space: O(n * k)