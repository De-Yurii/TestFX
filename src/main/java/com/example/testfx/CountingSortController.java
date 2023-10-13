package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Random;

public class CountingSortController {

    private int[] array;
    private int arraySize;
    @FXML
    CheckBox isTime;
    @FXML
    Button generateButton;

    @FXML
    TextArea textArea;

    @FXML
    Button sortButton;

    @FXML
    TextField sizeOfArray;
    public int[] generateArray(int numberOfArray){
        array = new int[numberOfArray];
        arraySize  = numberOfArray;
        for(int j = 0; j < numberOfArray; j++){

            Random r = new Random();
            Integer random = (int) Math.floor(Math.random() *(10 + 1));
            array[j] = random;
        }
        return array;
    }

    @FXML
    public void onGenerateAction(ActionEvent e){
        if(textArea.getText() != null ){
            textArea.setText("");
        }

        int size = Integer.parseInt(sizeOfArray.getText());
        int[] mass = generateArray(size);
        for(int i = 0; i < size; i++){
            String out = String.format("%10d ", mass[i]);
            textArea.appendText(out);
        }
        textArea.appendText("\n");
    }

    @FXML
    public void onSortButtonClicked(ActionEvent e){
        if(isTime.isSelected()){
            long start = System.currentTimeMillis();
            this.array = CountingSort.sort(this.array, this.arraySize);
            long end = System.currentTimeMillis();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Time of the sorting: " + (end-start) + "ms.");
            alert.showAndWait();
        }else{
            ArrayList<String> logs = new ArrayList<>();
            logs = CountingSort.sortLogs(this.array, this.arraySize);
            for(String i: logs){
                textArea.appendText(i);
            }
        }
        textArea.appendText("Sorted array:\n");
        for(int i: array){
            textArea.appendText(String.format("%d ", i));
        }


    }

    @FXML
    public void onCheckButtonClicked(ActionEvent e){

        boolean isntSorted = false;
        int [] array = this.array;
        for(int i = 0; i < this.arraySize-1; i++){
            if(array[i] > array[i+1]){
                isntSorted = true;
                break;
            }
        }
        if(isntSorted){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING");
            alert.setHeaderText(null);
            alert.setContentText("Array isn`t sorted");
            alert.showAndWait();
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Array is sorted");
            alert.showAndWait();
        }

    }

}
