package org.example.controller;

import org.example.model.Course;
import org.example.service.Service;

public class Controller {
    Service service = new Service();

    public void add(Course course) {
        service.add(course);
    }

    public void update(Course course) {
        service.update(course);
    }

    public void get(int id) {
        service.get(id);
    }

    public void delete(int id) {
        service.delete(id);
    }
}
