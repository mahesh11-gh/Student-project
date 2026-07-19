package com.org.student.entity;

import com.org.student.dto.StudentDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity(name = "Student")
public class StudentEntity {

    @Id
    private Long id ;
    private String name;
    private Integer age;
    private String standard;
    private String subjects;
    private Boolean softDelete;


    public Boolean getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Boolean softDelete) {
        this.softDelete = softDelete;
    }



    public StudentEntity() {
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

    public StudentEntity(Long id, String name, Integer age, String standard, String subjects, Boolean softDelete) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.subjects = subjects;
        this.softDelete = softDelete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity entity = (StudentEntity) o;
        return Objects.equals(id, entity.id) && Objects.equals(name, entity.name) && Objects.equals(age, entity.age) && Objects.equals(standard, entity.standard) && Objects.equals(subjects, entity.subjects) && Objects.equals(softDelete, entity.softDelete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, standard, subjects, softDelete);
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", standard='" + standard + '\'' +
                ", subjects='" + subjects + '\'' +
                ", softDelete=" + softDelete +
                '}';
    }

    public StudentDTO getStudentDto(StudentEntity entity){

        StudentDTO dto = new StudentDTO();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setAge(entity.getAge());
        dto.setStandard(entity.getStandard());
        dto.setSubjects(entity.getSubjects());

        return dto;
    }

}
