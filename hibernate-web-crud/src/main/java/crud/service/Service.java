package org.example.service;

import org.example.dao.Dao;
import org.example.model.Course;

public class Service {
    Dao dao = new Dao();

    public void add(Course course) {
        dao.add(course);
    }

    public void update(Course course) {
        dao.update(course);
    }

    public void get(int id) {
        dao.get(id);
    }
    public void delete(int id) {
        dao.delete(id);
    }
}
