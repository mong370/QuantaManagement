package com.studentmanagement.frontend.managment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentService service;

    // ADD
    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) {
        return service.addStudent(student);
    }

    // SHOW
    @GetMapping("/show")
    public List<Student> showAllStudents() {
        return service.showAllStudent();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updateStudent(@PathVariable Integer id,
                                @RequestBody Student student) {

        return service.updateStudent(id, student);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        return service.deleteStudent(id);
    }
}