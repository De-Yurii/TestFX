package com.example.testfx;

import java.util.ArrayList;

public abstract class MergeSort {
    static void merge(int array[], int p, int q, int r) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
    }

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            merge(array, left, mid, right);
        }
    }
    static ArrayList<String> mergeSortLogs(int[] array, int low, int high, ArrayList<String> logs){
        if (low < high) {

            int mid = (low + high) / 2;
            String tmp = "";
            for(int i = low; i < high; i++){
                tmp += String.format("%d ", array[i]);
            }
            tmp+= "\n";
            logs.add(tmp);
            logs = mergeSortLogs(array, low, mid, logs);
            logs = mergeSortLogs(array, mid + 1, high, logs);

            logs = mergeLogs(array, low, mid, high, logs);
        }
        return logs;
    }
    static ArrayList<String> mergeLogs(int array[], int p, int q, int r, ArrayList<String> logs) {

        int n1 = q - p + 1;
        int n2 = r - q;

        int L[] = new int[n1];
        int M[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = array[p + i];
        for (int j = 0; j < n2; j++)
            M[j] = array[q + 1 + j];

        int i, j, k;
        i = 0;
        j = 0;
        k = p;

        while (i < n1 && j < n2) {
            if (L[i] <= M[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = M[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = M[j];
            j++;
            k++;
        }
        String tmp = "";
        for (int m = p; m < r; m++) {
            tmp += String.format("%d ", array[m]);
        }
        tmp += "\n";
        logs.add(tmp);
        return logs;
    }
}
