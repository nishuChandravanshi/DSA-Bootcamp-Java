package com.kunal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


//    public static void main(String[] args) {
//        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,-5));
//        List<Integer> list2 = new ArrayList<>(Arrays.asList(3,1,2,-5,4));
//        System.out.println(list1.equals(list2));
//
//    }

//    public class Main {
        public static void main(String[] args) {

            int V = 11;
            ArrayList < Integer > ans = new ArrayList < > ();
            int coins[] = {1, 5, 6, 9};
            int n = coins.length;
            for (int i = n - 1; i >= 0; i--) {
                while (V >= coins[i]) {
                    V -= coins[i];
                    ans.add(coins[i]);
                }
            }
            System.out.println("The minimum number of coins is "+ans.size());
            System.out.println("The coins are ");
            for (int i = 0; i < ans.size(); i++) {
                System.out.print(" " + ans.get(i));
            }

        }
//    }

    public static void main1(String[] args) {
        // Q: store a roll number
        int a = 19;

        // Q: store a person's name
        String name = "Kunal Kushwaha";

        // Q: store 5 roll numbers
        int rno1 = 23;
        int rno2 = 55;
        int rno3 = 18;

        // syntax
        // datatype[] variable_name = new datatype[size];
        // store 5 roll numbers:
//        int[] rnos = new int[5];
//        // or directly
//        int[] rnos2 = {23, 12, 45, 32, 15};

        int[] ros; // declaration of array. ros is getting defined in the stack
        ros = new int[5]; // initialisation: actually here object is being created in the memory (heap)

//        System.out.println(ros[1]);

        String[] arr = new String[4];
        System.out.println(arr[0]);

//        for (String element : arr) {
//            System.out.println(element);
//        }

    }
}
