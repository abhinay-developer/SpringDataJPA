package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    public Page<Course> findByCourseTitleContaining(String title,Pageable pageable);

}


