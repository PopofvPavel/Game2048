package com.example.Game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameHelper {

    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        List<Integer> resultList = new ArrayList<>();

        addNotNullElementsToList(list, resultList);
        mergeEqualsItems(resultList);
        deleteNullsFromList(resultList);
        int nullsCounter = getSizeDifference(list, resultList);
        addNullsToList(resultList, nullsCounter);

        return resultList;
    }

    private int getSizeDifference(List<Integer> list, List<Integer> resultList) {
        return Math.abs(list.size() - resultList.size());
    }

    private void addNullsToList(List<Integer> resultList, int nullsCounter) {
        for (int i = 0; i < nullsCounter; i++) {
            resultList.add(null);
        }
    }

    private void deleteNullsFromList(List<Integer> resultList) {
        Iterator<Integer> iterator = resultList.listIterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == null) {
                iterator.remove();
            }
        }
    }

    private static void mergeEqualsItems(List<Integer> resultList) {
        for (int i = 0; i < resultList.size() - 1; i++) {
            Integer current = resultList.get(i);
            Integer next = resultList.get(i + 1);
            if (current != null && current.equals(next)) {
                resultList.set(i, 2 * current);
                resultList.set(i + 1, null);
            }
        }
    }

    private static void addNotNullElementsToList(List<Integer> list, List<Integer> resultList) {
        for (Integer item : list) {
            if (item != null) {
                resultList.add(item);
            }
        }
    }


}
