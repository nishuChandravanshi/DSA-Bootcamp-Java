package com.kunal;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
//        System.out.println(Arrays.toString(nge.nextGreaterElement(new int[]{3, 3, 4, 5, 1, 0})));

        System.out.println(Arrays.toString(nge.nextSmallerElement(new int[]{3, 3, 4, 5, 1, 0})));

    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();


        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(nums[i]);
        }
        return res;
    }

    public int[] nextSmallerElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();


        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = stack.peek();
            }

            stack.push(nums[i]);
        }
        return res;
    }

}
