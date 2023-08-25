package com.crudspring.crudspring.repository;

import com.crudspring.crudspring.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRespository extends JpaRepository<Course, Long> {


}
