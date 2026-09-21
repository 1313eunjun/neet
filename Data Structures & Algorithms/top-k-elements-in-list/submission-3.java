class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        //숫자 -> 등장 횟수
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> count.get(a) - count.get(b));
        //Min heap: 우선순위가 가장 작은 값이 맨 앞에있는구조
        //여기선 숫자의 크기가 작은걸 기준으로 하는게아님, 등장 횟수가 작은것
        for(int num : count.keySet()){
            heap.add(num);
        //heap = []
            if(heap.size() > k){
                heap.poll();
            }
        }
        //heap 크기가 k 보다 커지면 하나를 뺌
        int[] result = new int[k];

        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }

        return result;
    }
}
//Min heap / PriorityQueue
//Time: O(n log k)
//Space : O(n)