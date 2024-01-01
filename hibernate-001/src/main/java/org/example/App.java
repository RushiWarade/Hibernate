package org.example;

import org.example.controller.Controller;
import org.example.model.Course;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Controller controller = new Controller();

//        Add data
//        Course course= Course.builder()
//                .name("Shubham")
//                .email("shubham@gmail.com")
//                .mobile("8956213562 ")
//                .build();
//        controller.add(course);



//        update data
//        Course course = Course.builder()
//                .id(52)
//                .name("Shubham pachpol")
//                .email("rushiwarade023@gmail.com")
//                .mobile("9075063779")
//                .build();
//        controller.update(course);


//        get course
        controller.get(2);


//        Delete course
//        controller.delete(1);

    }
}
