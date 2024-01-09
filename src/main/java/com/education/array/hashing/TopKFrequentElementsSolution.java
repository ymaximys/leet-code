package com.education.array.hashing;

import java.util.*;

public class TopKFrequentElementsSolution {
    public int[] topKFrequent(int[] nums, int k) {

        List<Integer>[] sortedNumbersByIndex = new List[nums.length + 1];

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer number : nums) {
            Integer numberCount = map.getOrDefault(number, 0);
            map.put(number, ++numberCount);
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            List<Integer> numbers = sortedNumbersByIndex[entry.getValue()];
            if (numbers == null) {
                numbers = new ArrayList<>();
            }

            numbers.add(entry.getKey());
            sortedNumbersByIndex[entry.getValue()] = numbers;
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = sortedNumbersByIndex.length - 1; i >= 0; i--) {
            List<Integer> mostFrequentElements = sortedNumbersByIndex[i];
            if (mostFrequentElements == null || mostFrequentElements.isEmpty()) {
                continue;
            }
            for (int j = mostFrequentElements.size() - 1; j >= 0; j--) {
                if (result.size() < k && !result.contains(mostFrequentElements.get(j))) {
                    result.add(mostFrequentElements.get(j));
                }
            }
            if (result.size() >= k) {
                break;
            }
        }

        int[] resultArray = new int[k];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        return resultArray;
    }

    public static void main(String[] args) {
        TopKFrequentElementsSolution s = new TopKFrequentElementsSolution();
        int[] nums = new int[]{5, 3, 1, 1, 1, 3, 73, 1};
        int[] result = s.topKFrequent(nums, 2);
        System.out.println(Arrays.toString(result));
    }
}