package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class PersonalTaskControler {
    private float[][] matrix;
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

        matrix = new float[numberOfColums][numberOfRows];
        for(int i = 0; i < numberOfColums; i++){
            for(int j = 0; j < numberOfRows; j++) {
                Random r = new Random();
                float random = 0 + r.nextFloat() * 20;
                float scale = (float) Math.pow(10, 1);
                float result = (float) (Math.ceil(random * scale) / scale);
                matrix[i][j] = result;
            }
        }
        addMatrix(matrix);
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

    @FXML
    public void deleteButtonPressed(){
        for(int i = 0; i < numberOfColums; i++){
            float min = matrix[i][0];
            int min_index = 0;
            for(int j = 0; j < numberOfRows; j++){
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    min_index = j;
                }
            }
            matrix[i][min_index] = (float) Math.log(matrix[i][min_index]);

        }
        addMatrix(matrix);
    }
    private void addMatrix(float[][] matrix){
        if(!(Objects.equals(textArea.getText(), ""))){
            textArea.appendText("\n\n");
        }
        for(int i =  0; i < numberOfColums; i++){
            for(int j = 0; j < numberOfRows; j++) {
                textArea.appendText(String.format("%10.3f", matrix[i][j]));
            }
            textArea.appendText("\n");
        }
        textArea.appendText("\n");
    }
}
