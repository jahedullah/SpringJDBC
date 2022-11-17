package JDBC_select002.dao;

import JDBC_select002.api.Student;
import JDBC_select002.rowMapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("studentDaoImpl")
public class StudentDaoImpl implements  StudentDao {
    //Establish the connection with mysql and jdbc while creating the JDBC template Object.
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public StudentDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO STUDENT VALUES (?,?,?)";
        Object[] arg = {student.getRoll_no(), student.getName(), student.getAddress()};

        int noOfRowInserted = jdbcTemplate.update(sql, arg);
        System.out.println("No of Row inserted: " + noOfRowInserted);
    }

    @Override
    public void insert(List<Student> studentList) {
        String sql = "INSERT INTO STUDENT VALUES(?,?,?)";
        ArrayList<Object[]> sqlArgs = new ArrayList<>();

        for(Student tempStudent:studentList){
            Object[] studentData = {tempStudent.getRoll_no(),tempStudent.getName(),tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql,sqlArgs);
        System.out.println("Batch Update Done.");

    }

    //Look in the below method we have used our custom StudentRowMapper to fetch the data from DB but now we
    //are using the BeanPropertyRowMapper to map the data and fetch it. This is the beauty of Spring. Dont forget to
    //alias to match out column names with table and the variable name of your code. Unless it will return null values.
    @Override
    public List<Student> findAllStudents() {
        String selectsql = "SELECT ROLL_NO as roll_No, STUDENT_NAME as name, STUDENT_ADDRESS as address FROM STUDENT";

        List<Student> studentList = jdbcTemplate.query(selectsql,new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }

    @Override
    public void cleanUp() {
        String cleanUpSql = "TRUNCATE TABLE STUDENT";
        jdbcTemplate.update(cleanUpSql);
        System.out.println("Table Cleaned Up.");
    }

    @Override
    public Student findStudentByRollNo(int rollNo) {
        String sql = "SELECT * FROM STUDENT WHERE ROLL_NO = ?";
        Student student = (Student) jdbcTemplate.queryForObject(sql,new StudentRowMapper(), rollNo);
        return student;
    }

    //this method gives the info to establish the connection with jdbc and mysql
}
