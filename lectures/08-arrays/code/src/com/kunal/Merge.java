package com.kunal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(0)) {
                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
            } else {
                ans.get(ans.size() - 1).set(1, Integer.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }

        int[][] res = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            res[i][0] = ans.get(i).get(0);
            res[i][1] = ans.get(i).get(1);
        }

        return res;
    }

    /*


     */
}