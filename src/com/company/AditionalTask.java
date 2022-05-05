package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AditionalTask {

    private List<Student> studentList = new ArrayList<>();
    private Optional<Student> firstName;

    public AditionalTask() {
        this.addNames();
    }

    private void addNames() {
        studentList = List.of(new Student("Иван"),
                new Student("Николай"),
                new Student("Василий"),
                new Student("Надежда"),
                new Student("Анна"),
                new Student("Григорий"),
                new Student("Вера"),
                new Student("Иван"),
                new Student("Ольга"),
                new Student("Григорий"),
                new Student("Вера"));
    }

    public List<String> returnSameName(String myName) {
        return studentList.stream()
                .map(studentList -> studentList.getName().toLowerCase())
                .filter(studentList -> studentList.equals(myName.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void print() {
        for (Student s : studentList) {
            System.out.println(s);
        }
    }

    public List<String> returnNameWithLetter() {
        return studentList.stream()
                .map(student -> student.getName().toLowerCase())
                .filter(studentList -> studentList.startsWith("а"))
                .collect(Collectors.toList());
    }

    public Optional<Student> returnFirstName() {
       firstName = Optional.ofNullable((studentList).stream()
               .sorted(Comparator.comparing(Student::getName))
               .findFirst().orElse(null));
       return firstName;
    }

}
