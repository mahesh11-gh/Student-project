package com.org.student.dto;

import com.org.student.entity.StudentEntity;

import java.util.List;
import java.util.Objects;

public class StudentDTO {

    private Long id ;
    private String name;
    private Integer age;
    private String standard;
    private String subjects;

    public StudentDTO(Long id, String name, Integer age, String standard, String subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.subjects = subjects;
    }

    public StudentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentDTO that = (StudentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(age, that.age) && Objects.equals(standard, that.standard) && Objects.equals(subjects, that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, standard, subjects);
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", standard='" + standard + '\'' +
                ", subjects='" + subjects + '\'' +
                '}';
    }

    public StudentEntity getStudentEntity(StudentDTO dto){

        StudentEntity entity = new StudentEntity();

        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setStandard(dto.getStandard());
        entity.setSubjects(dto.getSubjects());

        return entity;
    }
}
