package JDBC_select002.service;

import JDBC_select002.api.Student;
import JDBC_select002.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("studentDaoHelper")
public class StudentDaoHelper {
    @Autowired
    private StudentDao studentDaoImpl;

    public void setUpStudentTable(){
        Student newS1 = new Student();
        newS1.setRoll_no(1);
        newS1.setName("Jett");
        newS1.setAddress("Korea");

        Student newS2 = new Student();
        newS2.setRoll_no(2);
        newS2.setName("Raze");
        newS2.setAddress("Brazil");

        Student newS3 = new Student();
        newS3.setRoll_no(3);
        newS3.setName("Reyna");
        newS3.setAddress("No Home");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(newS1);
        studentList.add(newS2);
        studentList.add(newS3);


        studentDaoImpl.insert(studentList);
    }



    public void printStudents(List<Student> studentList){
        for(Student tempStudent:studentList){
            System.out.println(tempStudent);
        }
    }
}
