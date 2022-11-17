package JDBC_select002.test;

import JDBC_select002.api.Student;
import JDBC_select002.dao.StudentDaoImpl;
import JDBC_select002.service.AbilityDaoHelper;
import JDBC_select002.service.StudentDaoHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc_select002.xml");
        System.out.println("Application Started!!..");

        AbilityDaoHelper helper = factory.getBean(AbilityDaoHelper.class);
        helper.setUpAbilityTable();

//        StudentDaoHelper helper = factory.getBean(StudentDaoHelper.class);
//        helper.setUpStudentTable();
//
//        StudentDaoImpl DaoImpl = factory.getBean("studentDaoImpl", StudentDaoImpl.class);
//        List<Student> studentList = DaoImpl.findAllStudents();
//        helper.printStudents(studentList);
//
//        //Quering for a Specific Object
//        System.out.println("Fetching Student Data By ID");
//        Student student = DaoImpl.findStudentByRollNo(3);
//        System.out.println(student);
//
//        //cleanup Code
//        DaoImpl.cleanUp();


    }
}