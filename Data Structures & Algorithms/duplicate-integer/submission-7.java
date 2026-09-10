class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();    //같은 값을 중복해서 저장하지않는 자료구조 

        for(int num : nums){
            if(seen.contains(num)){
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

//HashSet
//Time: O(n log n)
//Space: O(1), O(n) depends

//HashSet: 값만 저장 
//HashMap: key -> value (몇번 등장했는가)