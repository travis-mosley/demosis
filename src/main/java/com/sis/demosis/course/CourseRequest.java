package com.sis.demosis.course;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequest {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate dropDate;
}

