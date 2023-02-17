package com.sis.demosis.course;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) {
        LocalDate startDate = courseRequest.getStartDate();
        LocalDate endDate = courseRequest.getEndDate();
        LocalDate dropDate = courseRequest.getDropDate();
        Course course = courseService.createCourseForAdmin(courseRequest.getName(), courseRequest.getDescription(), startDate, endDate, dropDate);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(course.getId())
                .toUri();
        return ResponseEntity.created(location).body(course);
    }
}

