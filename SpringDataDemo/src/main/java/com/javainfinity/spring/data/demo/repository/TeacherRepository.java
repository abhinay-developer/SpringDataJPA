package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
