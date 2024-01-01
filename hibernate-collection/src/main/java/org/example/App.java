package org.example;

import org.example.controller.StudentController;
import org.example.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        List<String> result = new ArrayList<>();
        result.add("Java");
        result.add("Python");
        result.add("C");
        result.add("Cpp");
        Student student = Student.builder()
                .name("Rushi")
                .email("rushi@gmail.com")
                .mobile("9075063779")
                .result(result)
                .build();

        StudentController studentController = new StudentController();

        studentController.add(student);
    }
}
