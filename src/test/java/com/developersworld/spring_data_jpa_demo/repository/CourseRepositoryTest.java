package com.developersworld.spring_data_jpa_demo.repository;

import com.developersworld.spring_data_jpa_demo.entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> list = courseRepository.findAll();
        System.out.println(list);

    }

    @Test
    public void findAllPagination(){
        Pageable pageable = PageRequest.of(0,3);
        Pageable pageable1 = PageRequest.of(1,2);
        List<Course> list = courseRepository.findAll(pageable).getContent();
        Long totalElements = courseRepository.findAll(pageable).getTotalElements();
        int totalPages = courseRepository.findAll(pageable).getTotalPages();
        System.out.println(totalPages);
        System.out.println(totalElements);
        System.out.println(list);

    }

    @Test
    public void findAllPaginationSorting(){
        Pageable pageable = PageRequest.of(0,3, Sort.by("title"));
        Pageable pageable1 = PageRequest.of(1,2);
        List<Course> list = courseRepository.findAll(pageable).getContent();
        Long totalElements = courseRepository.findAll(pageable).getTotalElements();
        int totalPages = courseRepository.findAll(pageable).getTotalPages();
        System.out.println(totalPages);
        System.out.println(totalElements);
        System.out.println(list);

    }

    @Test
    public void findAllPaginationSortingTitle(){
        Pageable pageable = PageRequest.of(0,3, Sort.by("title"));
        Pageable pageable1 = PageRequest.of(1,2);
        Page<Course> list = courseRepository.findByTitleContaining("ds", pageable);
        System.out.println("pageable response *************"+ list);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){
        Course course = Course.builder()
                .credit(14)
                .title("AI")
                .build();
        var random = new Random().nextInt(100);
        Guardian g = Guardian.builder().name("Tanuj").email("tanuj"+random+"@gmail.com")
                    .mobile("9818087721").build();
        Student s = Student.builder()
                .firstName("Jordan")
                .lastName("kathuria")
                .emailId("Jordan"+random+"@gmail.com")
                .guardian(g)
                .build();

        course.addStudents(s);
        courseRepository.save(course);

    }

//    @Test
//    public void saveCourseWithTeacher(){
//        Teacher teacher = Teacher.builder().
//                firstName("Vani")
//                .lastName("Taneja")
//                .build();
//        Course course = Course.builder()
//                .credit(1)
//                .title("python")
//                .teacher(teacher)
//                .build();
//        courseRepository.save(course);
//    }

}