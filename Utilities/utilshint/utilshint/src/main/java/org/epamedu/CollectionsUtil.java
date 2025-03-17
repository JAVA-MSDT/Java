package org.epamedu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsUtil {

    public static void main(String[] args) {

        List<String> items = new ArrayList<>();
        items.add("One");
        items.add("Two");
        items.add("One");
        items.add("Two");

        int frequency = Collections.frequency(items, "One");
        int frequencyString = frequency(items, "");
        System.out.println(frequency);
        System.out.println(frequencyString);
    }

    private static int frequency(List<String> listString, String toFindIt) {
        int result = 0;
        for (String st : listString) {
            if (st.equals(toFindIt))  result++;
        }
        return result;
    }
}
