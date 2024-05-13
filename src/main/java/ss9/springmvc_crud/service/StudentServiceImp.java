package ss9.springmvc_crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ss9.springmvc_crud.model.Student;
import ss9.springmvc_crud.reponsitory.StudentReponsitory;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{
    @Autowired
    private StudentReponsitory studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public boolean create(Student student) {
        return studentRepository.create(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Student student) {
        studentRepository.update(student);
    }
}
