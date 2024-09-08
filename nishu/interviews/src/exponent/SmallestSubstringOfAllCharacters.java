package exponent;


/*
Problem :
Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"
output: "zyx"

 */

import java.io.*;
import java.util.*;

class SmallestSubstringOfAllCharacters {

    /*
    arr : x , y , z
    str = "xyazy"
    "xxxyz"

    "---------------------"
    */
// arr = ['x','y','z'], str = "asyyzxyzyx"

    static String getShortestUniqueSubstring(char[] arr, String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : arr) {
            map.put(ch, 1);
        }

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        String ans = "";

        while (j < str.length()) {
            char curr = str.charAt(j);

            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) - 1);
                while (i <= j) {
                    char currI = str.charAt(i);
                    if (!map.containsKey(currI)) {
                        i++;
                    } else {
                        if (map.get(currI) < 0) {
                            map.put(currI, map.get(currI) + 1);
                            i++;
                        } else {
                            break;
                        }
                    }
                }
                if (valid(map)) {
                    if (j - i + 1 < min) {
                        min = j - i + 1;
                        ans = str.substring(i, j + 1);
                    }
                }
            }

            j++;
        }
        return ans;
    }

    public static boolean valid(Map<Character, Integer> map) {
        for (Integer a : map.values()) {
            if (a > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'x', 'y', 'z'};
        String str = "xyyzyzyx";
        System.out.println(getShortestUniqueSubstring(chars, str));
    }

}

