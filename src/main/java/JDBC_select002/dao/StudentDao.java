package JDBC_select002.dao;

import JDBC_select002.api.Student;

import java.util.List;

public interface StudentDao {
    void insert(Student student);
    void insert(List<Student> studentList);


    List<Student> findAllStudents();

    void cleanUp();

    Student findStudentByRollNo(int rollNo);

}
