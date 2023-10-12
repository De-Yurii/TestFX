package com.example.testfx;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
public class SelectionSortController {
    private int[] array;
    private int arraySize;

    public int getArraySize() {
        return arraySize;
    }

    public SelectionSortController(){

    }

    public int[] getArray() {
        return array;
    }

    public int[] generateArray(int numberOfArray){
        array = new int[numberOfArray];
        arraySize  = numberOfArray;
        for(int j = 0; j < numberOfArray; j++){

            Random r = new Random();
            Integer random = (int) Math.floor(Math.random() *(1000 + 1)-500);
            array[j] = random;
        }
        return array;
    }
}
