class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        //nums.length = 6 이면 1 ~ 6 까지 가능
        for (int num : count.keySet()) {
            int freq = count.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            //bucket[3] = null  -> bucket[3] = []
            bucket[freq].add(num);
        }
            //bucket[3] = [1]
        int[] result = new int[k];
        int index = 0;

        for (int freq = bucket.length - 1; freq >= 0; freq--) {
        //bucket 의 뒤에서부터 앞으로 확인 
        //index 가 frequency 이기때문
            if (bucket[freq] != null) {
                for (int num : bucket[freq]) {
                    result[index] = num;
                    index++;
                    //result = [0, 0]
                    //index = 0
                    //num = 1
                    // -> result = [1, 0]
                    //다음 정답 위치로 이동
                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
//Bucket Sort
//Time: O(n)
//Space : O(n)