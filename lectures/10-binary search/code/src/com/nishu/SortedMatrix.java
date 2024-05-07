package com.nishu;

import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.toString(search(arr, 99)));
    }


    static int[] search(int[][] matrix, int target) {
        int noOfRows = matrix.length;
        int noOfCols = noOfRows > 0 ? matrix[0].length : 0;

        if (noOfRows == 0) {
            return new int[]{-1, -1};
        }

        /*
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
         */
        //search in mid column, eliminate rows
        int midCol = (noOfCols - 1) / 2;
        int rowStart = 0;
        int rowEnd = noOfRows - 1;

        while (rowStart < rowEnd - 1) {
            int mid = rowStart + (rowEnd - rowStart) / 2;

            if (target == matrix[mid][midCol]) {
                return new int[]{mid, midCol};
            }

            if (target > matrix[mid][midCol]) {
                rowStart = mid;
            } else {
                rowEnd = mid;
            }
        }
        //loop breaks when rowStart == rowEnd-1 ie possible ans can be in rowStart and rowStart+1
        System.out.println("rowStart : " + rowStart + ", rowEnd : " + rowEnd + ", midCol : " + midCol);

        if (target == matrix[rowStart][midCol]) {
            return new int[]{rowStart, midCol};
        }

        //mid to col-1 in first row
        if (target > matrix[rowStart][midCol] && target <= matrix[rowStart][noOfCols - 1]) {
            int ansCol = binarySearch(matrix[rowStart], midCol + 1, noOfCols - 1, target);
            return new int[]{rowStart, ansCol};
        } else if (target < matrix[rowStart][midCol]) { //0 to mid-1 col in first row
            int ansCol = binarySearch(matrix[rowStart], 0, midCol - 1, target);
            return new int[]{rowStart, ansCol};
        } else { //else search second row
            int ansCol = binarySearch(matrix[rowStart + 1], 0, noOfCols - 1, target);
            return new int[]{rowStart + 1, ansCol};
        }

    }

    private static int binarySearch(int[] arr, int start, int end, int target) {

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
