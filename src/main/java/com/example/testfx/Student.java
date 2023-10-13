package com.example.testfx;

public class Student {
    private String name;
    private String surname;
    private Double mark;

    public Student(String name, String surname, double mark) {
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

    public boolean isGreater(Student student){
        if(student.getMark() > this.mark){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", surname,  name, mark);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public double getMark() {
        return mark;
    }
}
