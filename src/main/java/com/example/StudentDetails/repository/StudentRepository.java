package com.example.StudentDetails.repository;

import com.example.StudentDetails.entity.StudentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<StudentDetails, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM StudentDetails s WHERE s.age < 23")
    void deleteStudentsByAgeLessThan23();

}
