package com.example.testfx;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.*;

public class PersonalTaskControler {
    private float[][] matrix;
    private int numberOfRows;
    private final ArrayList<String> names = new ArrayList<>();
    private final ArrayList<String> surnames = new ArrayList<>();
    private final ArrayList<Student> students = new ArrayList<>();

    private ArrayList<Student> successfulStudents = new ArrayList<>();

    @FXML
    TextArea textArea;


    @FXML
    TextField amountOfColums;

    @FXML
    public void generateButtonPressed(){
        if(textArea.getText()!=null){
            textArea.setText("");
        }
        if(names.isEmpty()){
            fillNames(names);
        }
        if(surnames.isEmpty()){
            fillSurnames(surnames);
        }
        if(!students.isEmpty()){
            students.clear();
        }
        try {
            numberOfRows = Integer.parseInt(amountOfColums.getText());

        }catch (NumberFormatException e){
            return;
        }

        for(int i = 0; i < numberOfRows; i++){
            int index = (int)(Math.random() * names.size());
            String name = names.get(index);
            index = (int)(Math.random() * surnames.size());
            String surname = surnames.get(index);

            Random r = new Random();
            Float random = r.nextFloat() * 5;

            students.add(new Student(name, surname, random));
        }


        addStudents(students);
    }

    @FXML
    public void sortButtonPressed(){
        textArea.appendText("Successful students: ");
        for(Student student: students){
            if(student.getMark() > 4.001){
                successfulStudents.add(student);
            }
        }
        addStudents(successfulStudents);

        textArea.appendText("\n");
        textArea.appendText("Sorted students: ");
        QuickSort.quickSortAlphaberic(successfulStudents, 0, successfulStudents.size()-1);
        this.addStudents(successfulStudents);
    }



    private void addStudents(ArrayList<Student> students){
        for(Student student: students){
            textArea.appendText(student.toString() + "\n");
        }
        textArea.appendText("\n");
    }

    private void fillNames(ArrayList<String> names){
        names.add("Andriy");
        names.add("Vyfymilian");
        names.add("Anastasia");
        names.add("Yura");
        names.add("Max");
        names.add("Veronika");
        names.add("Yana");
        names.add("Viktor");
        names.add("Mychailo");
        names.add("Endry");
        names.add("Jobert");
    }

    private void fillSurnames(ArrayList<String> surnames){
        surnames.add("Debeliak");
        surnames.add("Sach");
        surnames.add("Bodnar");
        surnames.add("Voin");
        surnames.add("Scacovskii");
        surnames.add("Legeza");
        surnames.add("Proziv");
        surnames.add("Shevchuk");
    }
}
