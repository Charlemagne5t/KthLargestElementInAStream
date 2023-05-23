package org.example;

import java.util.Arrays;

public class KthLargest {
    public int[] kLargest;
    public int k;
    public int count = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        if (k > nums.length - 1) {
            Arrays.sort(nums);
            kLargest = new int[k];
            Arrays.fill(kLargest, Integer.MIN_VALUE);
            if (nums.length > 0) {
                for (int i = nums.length - 1, j = 0; j < kLargest.length && i >= 0; i--, j++) {
                    kLargest[j] = nums[i];
                }
            }
        } else {
            Arrays.sort(nums);
            kLargest = new int[k];
            for (int i = nums.length - 1, j = 0; j < kLargest.length; i--, j++) {
                kLargest[j] = nums[i];
            }
        }
        count = k - nums.length;
    }

    public int add(int val) {
        if (count > 0 && kLargest.length == 1 && val > kLargest[0]) {
            kLargest[0] = val;
            count--;
            return val;
        } else if (count > 0) {
            for (int i = 0; i < kLargest.length; i++) {
                if (kLargest[i] <= val) {
                    int temp = kLargest[i];
                    kLargest[i] = val;
                    for (int j = i + 1; j < kLargest.length; j++) {
                        int temp2 = kLargest[j];
                        kLargest[j] = temp;
                        temp = temp2;
                    }
                    break;
                }
            }

            count--;
            return kLargest[kLargest.length - 1];
        }
        if (val <= kLargest[kLargest.length - 1]) {
            return kLargest[kLargest.length - 1];
        } else {
            for (int i = 0; i < kLargest.length; i++) {
                if (kLargest[i] <= val) {
                    int temp = kLargest[i];
                    kLargest[i] = val;
                    for (int j = i + 1; j < kLargest.length; j++) {
                        int temp2 = kLargest[j];
                        kLargest[j] = temp;
                        temp = temp2;
                    }
                    break;
                }
            }

        }
        return kLargest[kLargest.length - 1];
    }
}