package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Random;

public class PersonalTaskControler {
    private float matrix[][];
    private int numberOfRows;
    private int numberOfColums;
    @FXML
    TextArea textArea;
    @FXML
    TextField amountOfRows;
    @FXML
    TextField amountOfColums;

    @FXML
    public void generateButtonPressed(){
        if(textArea.getText()!=null){
            textArea.setText("");
        }
        try {
            numberOfRows = Integer.parseInt(amountOfRows.getText());
            numberOfColums = Integer.parseInt(amountOfColums.getText());
        }catch (NumberFormatException e){
            return;
        }

        matrix = new float[numberOfRows][numberOfColums];
        for(int i = 0; i < numberOfRows; i++){
            for(int j = 0; j <numberOfColums; j++){

                Random r = new Random();
                Float random = -10 + r.nextFloat() * 20;
                matrix[i][j] = (float) random;
                textArea.appendText(String.format("%10.3f", random));
                textArea.appendText("  ");
            }
            textArea.appendText("\n");
        }
    }

    @FXML
    public void sortButtonPressed(){
        int minIndex;
        float min;
        for(int i = 0; i < numberOfColums; i++){
            min = matrix[0][i];
            minIndex = i;
            for(int j = i; j < numberOfColums; j++){
                if(matrix[0][j] < min){
                    min = matrix[0][j];
                    minIndex = j;
                }
            }
            if(minIndex != i){
                for(int j = 0; j < numberOfRows; j++){
                    float temp = matrix[j][i];
                    matrix[j][i] = matrix[j][minIndex];
                    matrix[j][minIndex] = temp;
                }
            }
            addMatrix(matrix);
        }
    }
    private void addMatrix(float[][] matrix){
        textArea.appendText("\n\n");
        for(int i =  0; i < numberOfRows; i++){
            for(int j = 0; j < numberOfColums; j++){
                textArea.appendText(String.format("%10.3f", matrix[i][j]));
            }
            textArea.appendText("\n");
        }
    }
}
