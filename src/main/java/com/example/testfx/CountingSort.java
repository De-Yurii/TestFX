package com.example.testfx;

import java.util.ArrayList;

public abstract class CountingSort {
    public static int GetMaxVal(ArrayList<Integer> array, int size)
    {
        var maxVal = array.get(0);
        for (int i = 1; i < size; i++)
            if (array.get(i) > maxVal)
                maxVal = array.get(i);
        return maxVal;
    }
    public void CountingSort(ArrayList<Integer> array)
    {
        var size = array.size();
        var maxElement = GetMaxVal(array, size);
        var occurrences = new int[maxElement + 1];
        for (int i = 0; i < maxElement + 1; i++)
        {
            occurrences[i] = 0;
        }
        for (int i = 0; i < size; i++)
        {
            occurrences[array.get(i)]++;
        }
        for (int i = 0, j = 0; i <= maxElement; i++)
        {
            while (occurrences[i] > 0)
            {
                array.set(j, i);
                j++;
                occurrences[i]--;
            }
        }
    }
}
