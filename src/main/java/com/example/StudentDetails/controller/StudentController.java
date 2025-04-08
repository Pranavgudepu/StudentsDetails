package com.example.StudentDetails.controller;

import com.example.StudentDetails.entity.StudentDetails;
import com.example.StudentDetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentdetails")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public StudentDetails saveStudentDetails(@RequestBody StudentDetails studentDetails) {
        return studentService.saveStudentDetails(studentDetails);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<StudentDetails> update(@PathVariable Long id, @RequestBody StudentDetails studentDetails) {
        StudentDetails updatedStudent = studentService.updateStudentDetails(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }
    @GetMapping("/get")
    public List<StudentDetails> getStudents() {
        return studentService.getStudentDetails();
    }

    @GetMapping("/getonestudent/{id}")
    public StudentDetails getStudent(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @DeleteMapping("/delete/age-less-than-23")
    public void deleteStudentsByAgeLessThan23() {
        studentService.deleteStudentsByAgeLessThan23();
    }

    @PostMapping("/add/multiple")
    public List<StudentDetails> saveMultipleStudents(@RequestBody List<StudentDetails> studentDetailsList) {
        return studentService.saveMultipleStudents(studentDetailsList);
    }

    @PutMapping("/upda/{id}")
    public ResponseEntity<StudentDetails> upda(@PathVariable Long id, @RequestBody StudentDetails studentDetails) {
        StudentDetails updatedStudent = studentService.updateStudentDetail(id, studentDetails);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }
    @PutMapping("/updateStudentDetail")
    public String updateStudentDetail(
            @RequestParam Long studentId,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String studentClass) {
        String updatedStudent = studentService.updateStudentDetail(studentId, studentName, age, studentClass);
        if (updatedStudent != null) {
            return "Student updated successfully";

        } else {
            System.out.println("Student not found with id " + studentId);
            return "Student not found with id " + studentId;
        }
    }

}