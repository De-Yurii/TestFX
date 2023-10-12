package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CountingSortController {
    private SelectionSortController selectionSortController;
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
            long start = System.currentTimeMillis();
            MergeSort.mergeSort(selectionSortController.getArray(), 0, selectionSortController.getArraySize()-1);
            long end = System.currentTimeMillis();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Time of the sorting: " + (end-start) + "ms.");
            alert.showAndWait();
        }else{
            ArrayList<String> logs = new ArrayList<>();
            logs = MergeSort.mergeSortLogs(selectionSortController.getArray(), 0, selectionSortController.getArraySize()-1, logs);
            for(String i: logs){
                textArea.appendText(i);
            }
        }
        textArea.appendText("Sorted array:\n");
        for(int i: selectionSortController.getArray()){
            textArea.appendText(String.format("%d ", i));
        }
        textArea.appendText("\n");

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
