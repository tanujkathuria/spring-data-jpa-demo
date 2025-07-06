package com.developersworld.spring_data_jpa_demo.repository;

import com.developersworld.spring_data_jpa_demo.entities.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

}
