package com.javainfinity.spring.data.demo.repository;

import com.javainfinity.spring.data.demo.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial ,Long> {
}
