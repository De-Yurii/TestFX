package com.example.testfx;

import java.util.ArrayList;

public abstract class QuickSort {
    public static int pivot_index;
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int middle = (high + low) / 2;
        if (arr[middle] < arr[low]) {
            swap(arr, middle, low);
        }
        if (arr[high] < arr[low]) {
            swap(arr, high, low);
        }
        if (arr[middle] > arr[high]) {
            swap(arr, middle, high);
        }
        swap(arr, middle, high - 1);
        pivot = arr[high - 1];



        int index_pivot = high-1;
        for (int j = low; j < high - 1; j++) {
            index_pivot = j;
            if (arr[j] >= pivot) {
                for (int i = high - 1; i >= low; i--) {
                    if (i < j) {
                        swap(arr, j, high - 1);
                        return j;
                    }
                    if (arr[i] < pivot) {
                        swap(arr, i, j);
                        break;
                    }

                }
            }
        }
        return index_pivot;
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {


            int pi = partition(arr, low, high);


            quickSort(arr, low, pi);
            quickSort(arr, pi+1, high);
        }
    }
    static private void swapInv(ArrayList<Float> arr, int i, int j){
        float temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    static private int partitionInverse(ArrayList<Float> arr, int low, int high){

        float pivot = arr.get(high);
        int middle = (high + low) / 2;
        if (arr.get(middle) < arr.get(low)) {
            swapInv(arr, middle, low);
        }
        if (arr.get(high) < arr.get(low)) {
            swapInv(arr, high, low);
        }
        if (arr.get(middle) > arr.get(high)) {
            swapInv(arr, middle, high);
        }
        swapInv(arr, middle, high - 1);
        pivot = arr.get(high - 1);



        int index_pivot = high-1;
        for (int j = low; j < high - 1; j++) {
            index_pivot = j;
            if (arr.get(j) >= pivot) {
                for (int i = high - 1; i >= low; i--) {
                    if (i < j) {
                        swapInv(arr, j, high - 1);
                        return j;
                    }
                    if (arr.get(i) < pivot) {
                        swapInv(arr, i, j);
                        break;
                    }

                }
            }
        }
        return index_pivot;
    }
    static void quickSortInverse(ArrayList<Float> arr, int low, int high){
        if (low < high) {


            int pi = partitionInverse(arr, low, high);


            quickSortInverse(arr, low, pi);
            quickSortInverse(arr, pi+1, high);
        }
    }
    static private void swapAlpha(ArrayList<Student> arr, int i, int j){
        Student temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }
    static private ArrayList<Student> partitionAlpha(ArrayList<Student> arr, int low, int high){

        String pivot;
        int middle = (high + low) / 2;
        if (arr.get(middle).getSurname().compareTo(arr.get(low).getSurname())< 0) {
            swapAlpha(arr, middle, low);
        }
        if (arr.get(high).getSurname().compareTo(arr.get(low).getSurname()) < 0) {
            swapAlpha(arr, high, low);
        }
        if (arr.get(middle).getSurname().compareTo(arr.get(high).getSurname()) > 0) {
            swapAlpha(arr, middle, high);
        }
        swapAlpha(arr, middle, high - 1);
        pivot = arr.get(high - 1).getSurname();



        int index_pivot = high-1;
        for (int j = low; j < high - 1; j++) {
            index_pivot = j;
            if (arr.get(j).getSurname().compareTo(pivot) >= 0) {
                for (int i = high - 1; i >= low; i--) {
                    if (i < j) {
                        swapAlpha(arr, j, high - 1);
                        pivot_index = j;
                        return arr;
                    }
                    if (arr.get(i).getSurname().compareTo(pivot) < 0) {
                        swapAlpha(arr, i, j);
                        break;
                    }

                }
            }
        }
        pivot_index = index_pivot;
        return arr;
    }
    static ArrayList<Student> quickSortAlphaberic(ArrayList<Student> arr, int low, int high){
        if (low < high) {


            arr = partitionAlpha(arr, low, high);
            int pi = pivot_index;

            arr = quickSortAlphaberic(arr, low, pi);
            arr = quickSortAlphaberic(arr, pi+1, high);
        }
        return arr;
    }
    private static int partionLogs(ArrayList<String> logs, int[] arr, int low, int high){
        int pivot = arr[high];
        int middle = (high + low) / 2;
        if (arr[middle] < arr[low]) {
            swap(arr, middle, low);
        }
        if (arr[high] < arr[low]) {
            swap(arr, high, low);
        }
        if (arr[middle] > arr[high]) {
            swap(arr, middle, high);
        }
        swap(arr, middle, high - 1);
        pivot = arr[high - 1];
        logs.add("Pivot element: " + pivot + "\n");


        int index_pivot = high-1;
        for (int j = low; j < high - 1; j++) {
            index_pivot = j;
            if (arr[j] >= pivot) {
                for (int i = high - 1; i >= low; i--) {
                    if (i < j) {
                        swap(arr, j, high - 1);
                        return j;
                    }
                    if (arr[i] < pivot) {
                        swap(arr, i, j);
                        break;
                    }

                }
            }
        }
        for(int j = low; j < high-1; j++){
            logs.add(String.format("%d ", arr[j]));
        }
        logs.add("\n");
        return index_pivot;
    }



    static ArrayList<String> quickSortLogs(ArrayList<String> logs, int[] arr, int low, int high){
        if (low < high) {


            int pi = partionLogs(logs, arr, low, high);
            String tmp = new String();
            for(int i = low; i < high; i++){
                tmp += String.format("%d ", arr[i]);
            }
            tmp+= "\n";
            logs.add(tmp);

            quickSortLogs(logs, arr, low, pi);
            quickSortLogs(logs, arr, pi+1, high);
        }
        return logs;
    }
}
