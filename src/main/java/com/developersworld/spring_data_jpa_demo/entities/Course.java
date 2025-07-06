package com.developersworld.spring_data_jpa_demo.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@ToString
public class Course {
    @SequenceGenerator(
            name = "course_generator",
            sequenceName = "course_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_generator"
    )
    @Id
    private Long courseId;
    private String title;
    private Integer credit;
    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

//    @ManyToOne(
//            cascade = CascadeType.ALL
//    )
//    @JoinColumn(
//            name = "teacher_id",
//            referencedColumnName = "teacherId"
//    )
//    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_courses_map",
            joinColumns = @JoinColumn(
                    name = "course_Id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_Id",
                    referencedColumnName = "studentId"
            )
    )
    List<Student> studentList;

    public void addStudents(Student s){
        if(studentList == null)
            studentList = new ArrayList<>();
        studentList.add(s);
    }

}
