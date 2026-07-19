package com.org.student.service;

import com.org.student.dto.StudentDTO;
import com.org.student.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    StudentDTO getStudent(Long id) throws Exception;

    List<StudentDTO> getStudents();

    StudentEntity createStudent(StudentDTO dto) throws Exception;

    void updateStudent(Long id, StudentDTO dto) throws Exception;

    void deletStudent(Long id) throws Exception;

    void softDeleteStudent(Long id) throws Exception;
}
