package com.example.testfx;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public abstract class SelectionSort {
    public static ArrayList<String> sort(int[] array, int length){
        ArrayList<String> logs = new ArrayList<>();
        logs.add("\n");
        int min;
        int minIndex;
        long start = System.currentTimeMillis();
        for(int i = 0; i < length; i++){
            String tmpLog = new String();
            min = array[i];
            minIndex = i;
            for(int j = i; j < length; j++){
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                int tmp = array[i];
                array[i] = min;
                array[minIndex] = tmp;
            }
            for(int j = 0; j < length; j++){
                tmpLog += String.format("%10d", array[j]);
            }
            tmpLog +="\n";
            logs.add(tmpLog);
        }
        long end = System.currentTimeMillis();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Time of the sorting: " + (end-start) + "ms.");
        alert.showAndWait();
        return logs;
    }
}
