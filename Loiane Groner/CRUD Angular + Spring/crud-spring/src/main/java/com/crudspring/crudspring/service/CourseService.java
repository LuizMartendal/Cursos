package com.crudspring.crudspring.service;

import com.crudspring.crudspring.dto.CourseDTO;
import com.crudspring.crudspring.exception.RecordNotFoundException;
import com.crudspring.crudspring.model.Course;
import com.crudspring.crudspring.repository.CourseRespository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class CourseService {

    private CourseRespository courseRespository;

    public CourseService(CourseRespository courseRespository) {
        this.courseRespository = courseRespository;
    }

    public List<Course> list() {
        return this.courseRespository.findAll();
    }

    public Course findById(@NotNull @Positive Long id) {
        return this.courseRespository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course save(@Valid CourseDTO courseDTO) {
        var course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return this.courseRespository.save(course);
    }

    public void deleteById(@NotNull @Positive Long id) {
        this.courseRespository.delete(this.courseRespository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(id)));
    }

    public Course update(Long id, CourseDTO courseDTO) {
        var course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        return this.courseRespository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(course.getName());
                    recordFound.setCategory(course.getCategory());
                    return this.courseRespository.save(course);
                }).orElseThrow(() -> new RecordNotFoundException(id));
    }
}
