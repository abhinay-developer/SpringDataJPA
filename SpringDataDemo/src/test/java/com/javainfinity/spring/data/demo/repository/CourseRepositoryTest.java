package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.Course;
import com.javainfinity.spring.data.demo.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;


      @Test
      public  void findAllCoursesTest(){
          List<Course> courseList=courseRepository.findAll();
          System.out.println("Course List:"+courseList);
      }

      @Test
      public void findAllPagination(){
          Pageable pageWithThreeRecords= PageRequest.of(0,3);
          Pageable pageWithTwoRecords= PageRequest.of(0,2);

         List<Course> courseList=courseRepository.findAll(pageWithThreeRecords).getContent();

         Long totalElements=
                 courseRepository.findAll(pageWithThreeRecords).getTotalElements();
          System.out.println("Total Elements:"+totalElements);
          long totalPages= courseRepository.findAll(pageWithThreeRecords).getTotalPages();
          System.out.println("Total Pages:"+totalPages);
          System.out.println("Course List:"+courseList);
      }


      @Test
      public void findAllSortingTest() {
          Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
          Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit").descending());


          Pageable sortByTitleAndCreditDesc =
                  PageRequest.of(0, 2, Sort.by("courseTitle").ascending().and(Sort.by("credit")));


          List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
          System.out.println("Sort By Title" + courses);

      }
      @Test
     public void findByCourseTitleContainingTest(){

       Pageable tenRecords=PageRequest.of(0,10);
       List<Course> courseList=courseRepository.
               findByCourseTitleContaining("D",tenRecords).getContent();

          System.out.println("Course List"+courseList);

     }


}