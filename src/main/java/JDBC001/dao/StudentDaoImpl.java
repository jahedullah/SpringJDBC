package JDBC001.dao;

import JDBC001.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
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

    //this method gives the info to establish the connection with jdbc and mysql
}
