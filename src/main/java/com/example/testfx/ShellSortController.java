package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class ShellSortController {
    SelectionSortController selectionSortController;
    @FXML
    CheckBox isTime;
    @FXML
    TextArea textArea;
    @FXML
    TextField sizeOfArray;
    private int[] array;
    private int arraySize;

    public int getArraySize() {
        return arraySize;
    }

    public int[] getArray() {
        return array;
    }
    @FXML
    public void onGenerateAction(ActionEvent e){
        if(textArea.getText() != null ){
            textArea.setText("");
        }
        selectionSortController = new SelectionSortController();
        int size = Integer.parseInt(sizeOfArray.getText());
        int[] mass = selectionSortController.generateArray(size);
        for(int i = 0; i < size; i++){
            String out = String.format("%10d ", mass[i]);
            textArea.appendText(out);
        }
        textArea.appendText("\n");
    }
    @FXML
    public void onSortButtonClicked(ActionEvent e){
        if(selectionSortController == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You need to generate array");
            alert.show();
            return;
        }
        if(isTime.isSelected()){
            ShellSort.shellSort(selectionSortController.getArray());
        }else{
            ShellSort.shellSortLogs(selectionSortController.getArray(), textArea);
        }
        for(int j: selectionSortController.getArray()){
            textArea.appendText(String.format("%10d", j));
        }
    }

    @FXML
    public void onCheckButtonClicked(ActionEvent e){
        if(selectionSortController == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("You need to generate array");
            alert.show();
            return;
        }
        boolean isntSorted = false;
        int [] array = selectionSortController.getArray();
        for(int i = 0; i < selectionSortController.getArraySize()-1; i++){
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
