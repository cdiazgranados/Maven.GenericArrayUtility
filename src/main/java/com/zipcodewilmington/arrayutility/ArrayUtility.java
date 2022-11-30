package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] inputArray;
    T[] arrayToMerge;

    ArrayList<T> mergedArray = new ArrayList<>();
    public ArrayUtility(T[] inputArray) {
        this.inputArray = inputArray;
    }


    public ArrayUtility() {
    }

    public void mergeArrays() {
        mergedArray.addAll(Arrays.asList(inputArray));
        mergedArray.addAll(Arrays.asList(arrayToMerge));
    }


    public int countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        this.arrayToMerge = arrayToMerge;
        mergeArrays();
        int count = 0;
        for (int i = 0; i < mergedArray.size(); i++) {
            if(valueToEvaluate == mergedArray.get(i)) {
                count ++;
            }
        }
        return count;
    }

    public T getMostCommonFromMerge(T[] arrayToMerge) { //need to change this
        this.arrayToMerge = arrayToMerge;
        mergeArrays();
        int temp = 0;
        T mostCommon = null;

        for (T t : mergedArray) {
          int occurrences = getNumberOfOccurrences(t);
          if (occurrences > temp) {
              temp = occurrences;
              mostCommon = t;
          }
         }

        return mostCommon;

    }


    public int getNumberOfOccurrences(T valueToEvaluate) {

        int count = 0;
        for (T t : inputArray) {
            if (t == valueToEvaluate) {
                count++;
            }
        }

        return count;
    }

    public T[] removeValue(T valueToRemove) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(inputArray));

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == valueToRemove) {
                list.remove(i);
                i--;
            }
        }

        T[] newArr = Arrays.copyOf(inputArray, list.size());

        for(int i = 0; i < newArr.length; i++){
            newArr[i] = list.get(i);
        }
        return newArr;
    }

}
