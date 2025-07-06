package com.developersworld.spring_data_jpa_demo.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @SequenceGenerator(
            name = "course_material_generator",
            sequenceName = "course_material_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_generator"
    )
    @Id
    private Long courseMaterialId;
    private String url;
    @OneToOne(cascade = CascadeType.ALL,
        fetch = FetchType.EAGER,
        optional = false
    ) // need to define this otherwise java does not allow it to be saved along with the reference data
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

}
