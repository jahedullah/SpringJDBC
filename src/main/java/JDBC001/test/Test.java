package JDBC001.test;

import JDBC001.api.Student;
import JDBC001.dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("jdbc001.xml");
        StudentDaoImpl studentDaoImpl = factory.getBean("studentDaoImpl", StudentDaoImpl.class);

        Student newStudent1 = new Student();
        newStudent1.setRoll_no(006);
        newStudent1.setName("BoogieMan");
        newStudent1.setAddress("Noida");


        studentDaoImpl.insert(newStudent1);
    }
}