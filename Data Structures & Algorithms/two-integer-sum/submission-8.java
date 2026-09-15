class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];

            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }

            map.put(nums[i], i);

        }
        return new int[] {};
    }
}

//Map<Integer, Integer> map = new HashMap<>(); : 숫자 -> index
/* nums = [2, 7, 11, 15]
    target = 9
    처음: map = {}
    nums[0] = 2 (i = 0)
    complement = 9 - 2; = > 7
    Map 에 7 이 없음 = > 2 -> 0
    Map: {2=0}

    nums[1] = 7 (i = 1)
    9 - 7 = 2
    Map 에 2 가 있음
    2 의 index 는 = 0
    현재 index = 1
    => return new int[] {0,1};
*/
//Time: O(n)
//Space: O(n)