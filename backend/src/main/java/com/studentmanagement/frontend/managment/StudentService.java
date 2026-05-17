package com.studentmanagement.frontend.managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // ADD
    public String addStudent(Student student) {
        repository.save(student);
        return "Student Added Successfully";
    }

    // SHOW
    public List<Student> showAllStudent() {
        return repository.findAll();
    }

    // UPDATE
    public String updateStudent(Integer id, Student updatedStudent) {

        Optional<Student> optionalStudent = repository.findById(id);

        if (optionalStudent.isPresent()) {

            Student existingStudent = optionalStudent.get();

            existingStudent.setName(updatedStudent.getName());
            existingStudent.setQuanta(updatedStudent.getQuanta());
            existingStudent.setEmail(updatedStudent.getEmail());

            repository.save(existingStudent);

            return "Updated Successfully";
        }

        return "Student Not Found";
    }

    // DELETE
    public String deleteStudent(Integer id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Deleted Successfully";
        }

        return "Student Not Found";
    }
}