package com.example.testfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Controller {
    private SelectionSortController selectionSortController;
    @FXML
    Button generateButton;

    @FXML
    TextArea startText;

    @FXML
    Button sortButton;

    @FXML
    TextField sizeOfArray;

    @FXML
    public void onGenerateAction(ActionEvent e){
        if(startText.getText() != null ){
            startText.setText("");
        }
        selectionSortController = new SelectionSortController();
        int size = Integer.parseInt(sizeOfArray.getText());
        int[] mass = selectionSortController.generateArray(size);
        for(int i = 0; i < size; i++){
            String out = String.format("%10d ", mass[i]);
            startText.appendText(out);
        }
        startText.appendText("\n");
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
        ArrayList<String> logs = SelectionSort.sort(selectionSortController.getArray(), selectionSortController.getArraySize());
        for(String i: logs){
            startText.appendText(i);
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