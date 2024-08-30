package com.kunal;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 0, -1, 3, 5, 3, 6, 8};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr,k)));
    }

    //todo https://leetcode.com/problems/sliding-window-maximum/submissions/1254105817/
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int resInd = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peekLast() == i - k) {
                deque.pollLast();
            }

            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.add(i);

            if (i >= k - 1) {
                res[resInd++] = nums[deque.peek()];
            }
        }

        return res;
    }
}
