class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        //숫자 -> 등장 횟수
        for(int num : nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        //현재 num 이 지금까지 몇번 나왔는지 확인하고 1 증가
        //count.getOrDefault(1, 0) 아직 1이없으니깐 0 -> 0 + 1 = 1
        List<Integer> list = new ArrayList<>(count.keySet());
        //key 만 가져와서 [] 로 만듦
        list.sort((a, b) -> count.get(b) - count.get(a));
        //등장 횟수가 큰 순서로 정렬
        int[] result = new int[k];
        //result = [0, 0]
        for(int i = 0; i < k; i++){
            result[i] = list.get(i);
        }
        //앞의 두개만 필요함
        return result;
    }
}
