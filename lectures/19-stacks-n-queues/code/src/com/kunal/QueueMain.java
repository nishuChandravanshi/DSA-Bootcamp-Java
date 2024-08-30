package com.kunal;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        CircularQueue queue = new CircularQueue(5);
//        queue.insert(3);
//        queue.insert(6);
//        queue.insert(5);
//        queue.insert(19);
//        queue.insert(1);
//
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.insert(133);
//        queue.display();
//
//        System.out.println(queue.remove());
//        queue.insert(99);
//        queue.display();

        int[] nums = new int[]{7,2,4};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 2)));

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int ind = 0;
        int i = 0;
        int j = k;
        for (; i < k; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.add(i);
        }
        res[ind++] = nums[deque.peekFirst()];

        i = 1;
        while (j < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[j]) {
                deque.pollLast();
            }
            deque.add(j);
            if (deque.peekFirst() < i) {
                deque.pollFirst();
            }

            res[ind++] = nums[deque.peekFirst()];
        i++;
        j++;
        }
        return res;

    }

    /**
     * https://replit.com/@KunalsReplit/StackAndQueuesQuestions
     * interview questions lectures solutions.
     */
}
