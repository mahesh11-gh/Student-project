package com.org.student.service;

import com.org.student.dto.StudentDTO;
import com.org.student.entity.StudentEntity;
import com.org.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO getStudent(Long id) throws Exception{
        StudentEntity entity = studentRepository.findById(id).orElseThrow(() -> new Exception("No id present"));

        return entity.getStudentDto(entity);
    }

    @Override
    public List<StudentDTO> getStudents() {

        List<StudentEntity> list = studentRepository.findAll();
        List<StudentDTO> dtoList = new LinkedList<>();
        for(StudentEntity entity: list){
            StudentDTO dto =entity.getStudentDto(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    @Override
    public StudentEntity createStudent(StudentDTO dto) throws Exception{


        if(studentRepository.findById(dto.getId()).isPresent())
            throw new Exception("Field already exists with id "+ dto.getId());

        StudentEntity entity = dto.getStudentEntity(dto);
        entity.setSoftDelete(false);
        studentRepository.save(entity);
        return entity;
    }

    @Override
    public void updateStudent(Long id, StudentDTO dto) throws Exception{
        if(!studentRepository.existsById(id))
            throw new Exception("The resource not found with id "+id);

        studentRepository.save(dto.getStudentEntity(dto));
    }

    @Override
    public void deletStudent(Long id) throws Exception{
        if(!studentRepository.existsById(id))
            throw new Exception("The resource not found with id "+id);

        studentRepository.deleteById(id);

    }

    @Override
    public void softDeleteStudent(Long id) throws Exception{

        StudentEntity entity = studentRepository.findById(id).orElseThrow(() -> new Exception("The resource not found with id "+id));
        entity.setSoftDelete(true);
        studentRepository.save(entity);

    }
}
