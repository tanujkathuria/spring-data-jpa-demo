package com.developersworld.spring_data_jpa_demo.repository;

import com.developersworld.spring_data_jpa_demo.entities.Course;
import com.developersworld.spring_data_jpa_demo.entities.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @Test
    public void saveTeacherWithCourse(){
        Course course1 = Course.builder()
                .credit(11)
                .title("DSA")
                .build();
        Course course2 = Course.builder()
                .credit(6)
                .title("Java")
                .build();
        List<Course> courseList = List.of(course1,course2);
        Teacher teacher = Teacher.builder().
                firstName("Rahul")
                .lastName("Gupta")
                .courseList(courseList)
                .build();
        teacherRepository.save(teacher);

    }

}