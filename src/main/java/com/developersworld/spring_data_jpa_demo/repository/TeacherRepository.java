package com.developersworld.spring_data_jpa_demo.repository;

import com.developersworld.spring_data_jpa_demo.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
