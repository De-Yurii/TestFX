package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class PersonalTaskControler {
    private ArrayList<Float> array;
    private int numberOfRows;
    @FXML
    TextArea textArea;
    @FXML
    TextField amountOfRows;

    @FXML
    public void generateButtonPressed(){
        if(textArea.getText()!=null){
            textArea.setText("");
        }
        try {
            numberOfRows = Integer.parseInt(amountOfRows.getText());
        }catch (NumberFormatException e){
            return;
        }

        array = new ArrayList<>();
        for(int i = 0; i < numberOfRows; i++){
            Random r = new Random();
            Float random = -10 + r.nextFloat() * 20;
            float scale = (float) Math.pow(10, 1);
            float result = (float) (Math.ceil(random* scale) / scale);
            array.add( result);
            textArea.appendText(String.format("%10.3f", array.get(i)));
            textArea.appendText("  ");
        }
        textArea.appendText("\n");
    }

    @FXML
    public void sortButtonPressed(){
        int minIndex;
        float min;
        ShellSort.shellSort(array);
        addMatrix(array);
    }

    @FXML
    public void deleteButtonPressed(){
        Map<Float, Integer> frequencyMap = new HashMap<>();

        for (Float num : array) {
            int frequency = frequencyMap.getOrDefault(num, 0) + 1;
            frequencyMap.put(num, frequency);
        }

        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        // Step 2: Create a new ArrayList with a smaller size
        int newSize = array.size() - maxFrequency;
        ArrayList<Float> newFloatList = new ArrayList<>(newSize);

        // Step 3: Copy elements from the original ArrayList to the new ArrayList, excluding the most common float number(s)
        for (Float num : array) {
            if (frequencyMap.get(num) != maxFrequency) {
                newFloatList.add(num);
            }
        }
        array = newFloatList;
        numberOfRows = newFloatList.size();
        addMatrix(newFloatList);
    }
    private void addMatrix(ArrayList<Float> array){
        textArea.appendText("\n\n");
        for(int i =  0; i < numberOfRows; i++){
                textArea.appendText(String.format("%10.3f", array.get(i)));
        }
        textArea.appendText("\n");
    }
}
