package com.javainfinity.spring.data.demo;

import com.javainfinity.spring.data.demo.entity.Guardian;
import com.javainfinity.spring.data.demo.entity.Student;
import com.javainfinity.spring.data.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
//@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudentTest(){
        Student student=Student.builder()
                .emailId("abhinay@gmail.com")
                .firstName("abhinay")
                .lastName("galipally").build();
              //  .guardianName("Ram")
                //.guardianEmail("ram@gmail.com")
                //.guardianMobile("9666147856").build();
         studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder().
                name("Raj").email("raj@gmail.com").mobile("8000800077").build();
        Student student=Student.builder().
                firstName("shiva").
                lastName("kumar").
                emailId("shivakumar@gmail.com").
                guardian(guardian).build();
        studentRepository.save(student);
    }

    @Test
    public void  findAllStudentsTest(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("Students List:"+studentList);
    }

    @Test
    public void findByFirstNameTest(){
        List<Student> studentList=studentRepository.findByFirstName("shiva");
        System.out.println(studentList);
    }
    @Test
    public void findByFirstNameContainingTest(){
        List<Student> studentList=studentRepository.findByFirstNameContaining("sh");
        System.out.println(studentList);
    }

    @Test
    public void findAllByGuardianName(){
        List<Student> studentList=studentRepository.findByGuardianName("Ram");
        System.out.println(studentList);
    }

    @Test
    public void findByEmailAddressTest() {
        Student student =
                studentRepository.getStudentByEmailAddress("abhinay@gmail.com");
        System.out.println(student);

    }

    @Test
    public void getStudentFirstNameByEmailAddressTest(){
        String s=studentRepository.getStudentFirstNameByEmailAddress("abhinay@gmail.com");
        System.out.println(s);
    }

    @Test
    public void findByEmailAddressNativeTest(){

        Student student=studentRepository.getStudentByEmailAddressNative("abhinay@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParamTest(){

        Student student=studentRepository.getStudentByEmailAddressNativeNamedParam("abhinay@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
      studentRepository.updateStudentNameByEmailId("abhi","abhinay@gmail.com");

    }
}
