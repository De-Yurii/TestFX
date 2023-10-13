package com.example.testfx;

import java.util.ArrayList;

public abstract class CountingSort {
    public static int GetMaxVal(int[] array, int size)
    {
        var maxVal = array[0];
        for (int i = 1; i < size; i++)
            if (array[i] > maxVal)
                maxVal = array[i];
        return maxVal;
    }

    public static int[] sort(int[] array, int size)
    {

        int[] outputarray= new int[size];
        var maxElement = GetMaxVal(array, size);
        var occurrences = new int[maxElement + 1];
        for (int i = 0; i < maxElement+1; i++)
        {
            occurrences[i] = 0;
        }
        for (int i = 0; i < size; i++)
        {
            occurrences[array[i]]++;
        }
        for(int i = 1; i < maxElement+1; i++){
            occurrences[i] = occurrences[i-1] + occurrences[i];
        }

        for(int i = size-1; i >= 0; i--){
            outputarray[occurrences[array[i]]-1] = array[i];
            occurrences[array[i]]--;
        }
        return outputarray;
    }

    public static ArrayList<String> sortLogs(int[] array, int size){
        var logs = new ArrayList<String>();
        var maxElement = GetMaxVal(array, size);
        logs.add(String.format("Max element: ", maxElement));
        int[] outputarray= new int[size];
        var occurrences = new int[maxElement + 1];
        for (int i = 0; i < maxElement+1; i++)
        {
            occurrences[i] = 0;
        }
        for (int i = 0; i < size; i++)
        {
            occurrences[array[i]]++;
        }
        logs.add("Occurrences: ");
        outputArray(logs, occurrences);
        for(int i = 1; i < maxElement+1; i++){
            occurrences[i] = occurrences[i-1] + occurrences[i];
        }
        logs.add("\n");
        logs.add("Modified occurrences: ");
        outputArray(logs, occurrences);
        for(int i = size-1; i >= 0; i--){

            outputarray[occurrences[array[i]]-1] = array[i];
            occurrences[array[i]]--;
            logs.add("Array: \n");
            outputArray(logs, outputarray);
        }
        System.arraycopy(outputarray, 0, array, 0, size);
        return logs;
    }
    private static void outputArray(ArrayList<String> log, int[] array){
        StringBuilder output = new StringBuilder(new String());
        for(int i: array){
            output.append(String.valueOf(i)+" ");
        }
        output.append("\n");
        log.add(output.toString());
    }

}
