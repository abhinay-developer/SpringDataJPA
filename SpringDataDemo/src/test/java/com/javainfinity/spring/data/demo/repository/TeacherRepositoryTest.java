package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.Course;
import com.javainfinity.spring.data.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacherTest(){
        Course courseDSA=Course.builder().courseTitle("DSA").credit(5).build();
        Course courseJPA=Course.builder().courseTitle("JPA").credit(5).build();


        List<Course> courseList=new ArrayList<>();
            courseList.add(courseDSA);
            courseList.add(courseJPA);


        Teacher teacher=
                Teacher.builder()
                        .firstName("Ram")
                        .lastName("kumar")
                        .courses(courseList).build();
        teacherRepository.save(teacher);

    }
}
