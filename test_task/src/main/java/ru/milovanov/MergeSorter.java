package ru.milovanov;

import java.util.*;

public class MergeSorter {
    public MergeSorter() {

    }

    String i = null;

    public Map<Integer, String> sortArray(Map<Integer, String> params) {

        List<Map.Entry<Integer, String>> list =
                new LinkedList<Map.Entry<Integer, String>>(params.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            public int compare(Map.Entry<Integer, String> o1,
                               Map.Entry<Integer, String> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
        Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }
}
