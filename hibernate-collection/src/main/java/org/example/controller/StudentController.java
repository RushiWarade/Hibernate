package org.example.controller;

import org.example.dao.StudentDao;
import org.example.model.Student;

public class StudentController {


    public static void add(Student student){
    StudentDao studentDao = new StudentDao();
        studentDao.add(student);
    }
}
