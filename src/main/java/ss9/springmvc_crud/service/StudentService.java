package ss9.springmvc_crud.service;

import ss9.springmvc_crud.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    boolean create(Student student);
    void update(Student student);
    void deleteById(Integer id);
    Student findById(Integer id);
}
