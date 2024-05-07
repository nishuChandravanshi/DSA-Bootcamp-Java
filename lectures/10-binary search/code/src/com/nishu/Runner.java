package com.nishu;

import com.nishu.heap.Heap;

import java.util.PriorityQueue;

public class Runner {
    public static void main(String[] args) throws Exception {
//        Heap<Integer> heap = new Heap<>();
//
//        heap.insert(10);
//        heap.insert(20);
////        heap.insert(15);
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());

//
//        Heap<String> heap = new Heap<>();
//
//        heap.insert("bi");
//        heap.insert("bye");
//        heap.insert("nishu");
////        heap.insert(15);
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());
//        System.out.println(heap.remove());



        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(22);
        queue.add(9);
        System.out.println(queue.peek());


        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((Integer c1, Integer c2) -> Integer.compare(c2, c1));
        maxQueue.add(232);
        maxQueue.add(22);
        maxQueue.add(45);

        System.out.println(maxQueue.peek());

    }
}
