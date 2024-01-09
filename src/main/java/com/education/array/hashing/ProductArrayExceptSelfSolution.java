package com.education.array.hashing;

import java.util.Arrays;

public class ProductArrayExceptSelfSolution {
    /* Input: nums = [1,2,3,4]
       Output: [24,12,8,6] */

    //prefix 1 1 2 6
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        //calculate array prefix sums
        int prefixSum = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[i] = 1;
            }
            prefixSum = prefixSum * nums[i];
            if (i + 1 <= nums.length - 1) {
                result[i + 1] = prefixSum;
            }
        }

        int suffixSum = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                result[i - 1] = suffixSum * result[i - 1] * nums[i];
                suffixSum *= nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ProductArrayExceptSelfSolution solution = new ProductArrayExceptSelfSolution();
        int[] nums = new int[]{-1,1,0,-3,3};
        int[] result = solution.productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }
}
