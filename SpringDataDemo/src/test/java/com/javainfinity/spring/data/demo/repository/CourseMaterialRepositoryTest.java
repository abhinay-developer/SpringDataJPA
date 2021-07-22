package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.Course;
import com.javainfinity.spring.data.demo.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterialTest(){
        Course course=Course.builder().courseTitle("Java").credit(1).build();
        CourseMaterial courseMaterial=
                CourseMaterial.builder().
                        url("www.google.com").course(course).build();

             courseMaterialRepository.save(courseMaterial);
    }


    @Test
    public  void findAllCourseMaterialsTest(){

        List<CourseMaterial> courseMaterialList=courseMaterialRepository.findAll();
        System.out.println(courseMaterialList);
    }
}