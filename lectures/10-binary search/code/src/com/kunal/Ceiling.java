package com.kunal;

public class Ceiling {

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        int target = 15;
        int ans = ceiling(arr, target);
        System.out.println(ans);
    }

    // return the index of smallest no >= target
    static int ceiling(int[] arr, int target) {

        // but what if the target is greater than the greatest number in the array
        if (target > arr[arr.length - 1]) {
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                // ans found
                return mid;
            }
        }
        /*
        because, in case of element is not present in the array there are two cases after loop terminates ie in condition start>end
        last condition before loop exit is start==end==mid
            1) if target>mid => start=mid+1 => which will lead to start>end condition
                >in this case it is clear that if target is bigger number then the next number should
                be the answer, ie new start ie mid+1 itself is the ans.
            2) if target<mid => end = mid-1; => which will lead to start>end condition
                >in this case if target is smaller than last mid => the mid itself ie start itself is the ans
                because mid-1 will be smaller than target, as it is already searched through.

         */
        return start;
    }
}
