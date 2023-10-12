package com.example.testfx;

import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

import static java.lang.Math.pow;

public abstract class ShellSort {
    public static void shellSort(ArrayList<Float> array){
        int h = 1;
        int i = 1;
        while (Math.pow(2, i)-1 <= array.size()) {
            h = (int) Math.pow(2, i) -1;
            i++;
        }

        while (h > 0) {
            for (int outer = h; outer < array.size(); outer++) {
                float tmp = array.get(outer);
                int inner = outer;

                while (inner > h - 1 && array.get(inner - h) > tmp) {
                    array.set(inner, array.get(inner - h));
                    inner -= h;
                }

                array.set(inner, tmp);

            }

            h -= pow(2, i-2);
            i--;
        }
    }

    public static void shellSort(int[] array) {
        long start = System.currentTimeMillis();
        int h = 1;
        int i = 1;
        while (Math.pow(2, i)-1 <= array.length) {
            h = (int) (Math.pow(2, i)-1);
            i++;
        }
        while (h > 0) {
            for (int j = h; j < array.length; j++) {
                int tmp = array[j];
                int k = j;

                while (k > h - 1 && array[k - h] > tmp) {
                    array[k] = array[k - h];
                    k -= h;
                }

                array[k] = tmp;
            }

            h -= pow(2, i-2);
            i--;
        }

    }

    public static void shellSortLogs(int[] array, TextArea textArea){
        int h = 1;
        int i = 1;
        while (Math.pow(2, i)-1 <= array.length) {
            h = (int) Math.pow(2, i) -1;
            i++;
        }

        while (h > 0) {
            textArea.appendText(String.format("H: %d\n", h));
            for (int j = h; j < array.length; j++) {
                int tmp = array[j];
                int k = j;

                while (k > h - 1 && array[k - h] > tmp) {
                    array[k] = array[k - h];
                    k -= h;
                }

                array[k] = tmp;
                for(int n: array){
                    textArea.appendText(String.format("%10d", n));
                }
                textArea.appendText("\n");
            }
            textArea.appendText("\n\n");

            h -= pow(2, i-2);
            i--;
        }
    }
}