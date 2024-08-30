package com.kunal;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("IIMCMXCIVII"));

    }

    public static int romanToInt(String s) {

        Map<Character, Integer> map = getRomanToIntMap();
        Integer result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {

            switch (s.charAt(i)) {
                case 'I': {
                    if (i + 1 < n && s.charAt(i + 1) == 'V') {
                        result += 4;
                        i++;
                        break;
                    } else if (i + 1 < n && s.charAt(i + 1) == 'X') {
                        result += 9;
                        i++;
                        break;
                    }

                }
                case 'X': {
                    if (i + 1 < n && s.charAt(i + 1) == 'L') {
                        result += 40;
                        i++;
                        break;
                    } else if (i + 1 < n && s.charAt(i + 1) == 'C') {
                        result += 90;
                        i++;
                        break;
                    }
                }
                case 'C': {
                    if (i + 1 < n && s.charAt(i + 1) == 'D') {
                        result += 400;
                        i++;
                        break;
                    } else if (i + 1 < n && s.charAt(i + 1) == 'M') {
                        result += 900;
                        i++;
                        break;
                    }
                }
                default: {
                    result += map.get(s.charAt(i));
                }
//                System.out.println("result i : "+i+", " + result);
            }
        }
        return result;
    }

    private static Map<Character, Integer> getRomanToIntMap() {
        Map<Character, Integer> map = new HashMap<>();
        Character[] romanSymbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        Integer[] intValues = {1, 5, 10, 50, 100, 500, 1000};

        for (int i = 0; i < romanSymbol.length; i++) {
            map.put(romanSymbol[i], intValues[i]);
        }

        return map;
    }
}
