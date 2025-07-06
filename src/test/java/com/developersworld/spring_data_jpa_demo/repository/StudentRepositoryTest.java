package com.developersworld.spring_data_jpa_demo.repository;

import com.developersworld.spring_data_jpa_demo.entities.Guardian;
import com.developersworld.spring_data_jpa_demo.entities.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
         var random = new Random().nextInt(100);
        Student student = Student.builder().emailId("developersworld"+random+"@gmail.com")
                                    .firstName("developers")
                                    .lastName("world")
                                    //.guardianName("Tanuj")
                                    //.guardianEmail("tanuj2@gmail.com")
                                    //.guardianMobile("7907900092")
                                    .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(Arrays.toString(studentList.toArray()));
    }

    @Test
    public void saveStudentWithGuardian(){
        var random = new Random().nextInt(100);
        Guardian g = Guardian.builder().name("nikhil").email("nikhil"+random+"@gmail.com").mobile("9818087721").build();
        Student s = Student.builder()
                            .firstName("shivam")
                            .lastName("kumar")
                            .emailId("shivam.kumar"+random+"@gmail.com")
                            .guardian(g)
                            .build();
        studentRepository.save(s);

    }

    @Test
    public void printStudentsByGuardianName(){
        List<Student> list = studentRepository.findByGuardianName("nikhil");
        System.out.println(list);
    }

    @Test
    public void printStudentsByFirstName(){
        List<Student> list = studentRepository.findByFirstName("shivam");
        System.out.println(list);
    }

    @Test
    public void printStudentsByFirstNameContaining(){
        List<Student> list = studentRepository.findByFirstNameContaining("sh");
        System.out.println(list);
    }

    @Test
    public void printStudentsByEmail(){
        Student student = studentRepository.getStudentByEmailAddress("shivam.kumar87@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printStudentsByEmailNative(){
        Student student = studentRepository.getStudentByEmailAddressNativeSQL("shivam.kumar87@gmail.com");
        System.out.println(student);
    }


    @Test
    public void printStudentsByEmailNativeNamed(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedSQL("shivam.kumar87@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("Tanuj", "shivam.kumar@gmail.com");
    }


}