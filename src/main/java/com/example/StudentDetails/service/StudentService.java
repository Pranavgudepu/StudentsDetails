package com.example.StudentDetails.service;

import com.example.StudentDetails.entity.StudentDetails;
import com.example.StudentDetails.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
        //to add the details of new student
    public StudentDetails saveStudentDetails(StudentDetails studentDetails)
    {
        return studentRepository.save(studentDetails);
    }
    //to update the all student details
    public StudentDetails updateStudentDetails(long id, StudentDetails studentDetails) {
        StudentDetails existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {

            existingStudent.setStudentName(studentDetails.getStudentName());
            existingStudent.setStudentClass(studentDetails.getStudentClass());


            return studentRepository.save(existingStudent);
        }


        return null;
    }

//get all student details
    public List<StudentDetails> getStudentDetails()
    {
        return studentRepository.findAll();
    }

    //get one student details
    public StudentDetails getStudent(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }


    //delete one student
    public void deleteStudent(long id)
    {
        studentRepository.deleteById(id);
    }

    //detelte student age lessthen23
    public void deleteStudentsByAgeLessThan23()
    {
        studentRepository.  deleteStudentsByAgeLessThan23();
    }
    //save multiple students
    public List<StudentDetails> saveMultipleStudents(List<StudentDetails> studentDetailsList) {
        return studentRepository.saveAll(studentDetailsList);
    }
//update only few colu
    public StudentDetails updateStudentDetail(long id, StudentDetails studentDetails) {
        StudentDetails existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent != null) {
            if (studentDetails.getStudentName() != null) {
                existingStudent.setStudentName(studentDetails.getStudentName());
            }
            if (studentDetails.getStudentClass() != null) {
                existingStudent.setStudentClass(studentDetails.getStudentClass());
            }
            if (studentDetails.getAge() != 0) {
                existingStudent.setAge(studentDetails.getAge());
            }

            return studentRepository.save(existingStudent);
        }
        return null;
    }
    public String updateStudentDetail(Long studentId, String studentName, Integer age, String studentClass) {

        StudentDetails student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        if (studentName != null) {
            student.setStudentName(studentName);
        }
        if (age != null) {
            student.setAge(age);
        }
        if (studentClass != null) {
            student.setStudentClass(studentClass);
        }

        studentRepository.save(student);
        return "Student updated successfully";
    }
}
