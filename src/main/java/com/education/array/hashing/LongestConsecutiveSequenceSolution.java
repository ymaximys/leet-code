package com.education.array.hashing;

import java.util.*;

public class LongestConsecutiveSequenceSolution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new TreeSet<>();
        for (Integer num : nums) {
            numbers.add(num);
        }

        Set<Integer> processedStartNumbers = new HashSet<>();
        int maxSequenceSizeGlobal = 0;
        for (Integer num : nums) {
            int low = num - 1;
            if (numbers.contains(low) &&
                    !processedStartNumbers.contains(num)) { //skip if not start of sequence and not process same start number again
                continue;
            }

            int high = num + 1;
            int maxSequenceSize = 1;
            while (numbers.contains(high)) {
                maxSequenceSize = maxSequenceSize + 1;
                high++;
            }
            processedStartNumbers.add(num);
            maxSequenceSizeGlobal = Math.max(maxSequenceSizeGlobal, maxSequenceSize);
        }

        return maxSequenceSizeGlobal;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequenceSolution p = new LongestConsecutiveSequenceSolution();
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int sequencesCount = p.longestConsecutive(nums);
        System.out.println(sequencesCount);
    }
}
