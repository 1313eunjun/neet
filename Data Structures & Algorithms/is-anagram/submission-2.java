class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }
}

//Sorting
//toCharArray(): "cat" -> ['c', 'a', 't']
//Arrays.sort(sArr); ['a', 'c', 't']

//Time: O(n log n)
