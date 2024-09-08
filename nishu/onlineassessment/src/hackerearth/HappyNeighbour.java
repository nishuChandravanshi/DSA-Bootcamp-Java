package hackerearth;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class HappyNeighbour {

    /*
    Input :
    n -> no of house
    m -> no of consecutive houses needed for neighbourhood to be happy
    houses[] -> array house denoting the house that will be filled on each day.

    eg. house[i] = a ==> `a` house will be filled/occupied on ith day.

    Output :
    To return the day the first day on which the neighbourhood becomes happy.

    *The neighbourhood becomes happy if there is at least one set of consecutive occupied house.

    Constraint : 1<=n<= 10^5, 1<=m<=n, 1<=house[i]<=n
    Example :
    1. Input
    3
    1
    3 2 1
    Output : 1

    2. Input
    10
    8
    8 4 9 10 3 1 7 2 6 5
     */


    /*
    approach
    -> create houseId, day mapping --> ie array containing day as value and houseId as index. => consecutive houseIds will be in sequence
    -> now this houseId[] array can be traversed in window of m, => m consecutive houses are filled
    so the max day/value in this window represents the day all the m houses were filled,
    this way we can check for all possible window, and get the minimun of all the maxValues obtained for each window
    that will represent the first day when the window was filled ie the first day the neighbourhood has m consecutive neighbours.


     */
    public static int solve(int n, int m, int[] houses) {
        int[] houseIds = new int[n];
        Map<Integer, Integer> consHousesOccDays = new TreeMap<>((a, b) -> b - a);

        for (int day = 0; day < n; day++) {
            int houseId = houses[day];
            houseIds[houseId - 1] = day;  //house with id houseId is filled on day.
        }
//        System.out.println("houseIds " + Arrays.toString(houseIds));

        int firstHappyDay = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            consHousesOccDays.put(houseIds[i], i);     //day on which ith house was occupied, value i here is not of much, use just we are concerned about
            //the key ie day as we want to sort the day and take max day for each window.
        }

        firstHappyDay = getMaxDay(consHousesOccDays);
        int i = 0;
        int j = m;
        while (j < n) {
            consHousesOccDays.remove(houseIds[i]);   //remove ith houseId day to move to next window;
            consHousesOccDays.put(houseIds[j], j);
            firstHappyDay = Math.min(getMaxDay(consHousesOccDays), firstHappyDay);
            i++;
            j++;
        }

        return firstHappyDay + 1; //since day starts from 1, and we've stored in 0th index
    }

    private static int getMaxDay(Map<Integer, Integer> consHousesOccDays) {
        return consHousesOccDays.entrySet().stream().findFirst().get().getKey();
    }

    public static void main(String[] args) {
//        int n = 3;
//        int m = 1;
//        int[] houses = new int[]{3, 2, 1};


        int n = 10;
        int m = 3;
        int[] houses = new int[]{8, 7, 6, 5, 4, 3, 2, 1, 9, 10};
        System.out.println(solve(n, m, houses));
    }

}