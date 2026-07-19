package com.org.student.controller;

import com.org.student.dto.StudentDTO;
import com.org.student.entity.StudentEntity;
import com.org.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id) throws Exception{

        StudentDTO dto = studentService.getStudent(id);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("students")
    public ResponseEntity<List<StudentDTO>> getStudents(){

        List<StudentDTO> dto = studentService.getStudents();

        return ResponseEntity.ok(dto);
    }

    @PostMapping("student")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO dto) throws Exception{

        StudentEntity result = studentService.createStudent(dto);

        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.CREATED.value())).body("Student is created with id "+ result.getId());
    }

    @PutMapping("student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id ,@RequestBody StudentDTO dto) throws Exception{

        studentService.updateStudent(id, dto) ;

        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.NO_CONTENT.value())).build();
    }

    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) throws Exception{

        studentService.deletStudent(id);

        return ResponseEntity.ok().build();
    }

    @PatchMapping("student/delete-soft")
    public ResponseEntity<String> softDeleteStudent(@RequestParam Long id) throws Exception{

        studentService.softDeleteStudent(id);

        return ResponseEntity.ok().body("The student record is deleted with id "+ id);
    }


}
