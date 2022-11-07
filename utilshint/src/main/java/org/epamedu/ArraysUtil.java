package org.epamedu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArraysUtil {

    public static void main(String[] args) {
        // Get the Array
        int[] intArr = { 10, 20, 15, 22, 35 };

        // Before
        sortArray(intArr);

        // After
        // Arrays.sort(intArr);

        List<Integer> integerList = new ArrayList<>();
        for (int j : intArr) {
            integerList.add(j);
        }
        integerList.forEach(System.out::println);
    }

    private static void sortArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int tmp = 0;
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
