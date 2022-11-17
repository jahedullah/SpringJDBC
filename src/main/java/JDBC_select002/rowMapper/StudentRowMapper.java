package JDBC_select002.rowMapper;

import JDBC_select002.api.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student fetchedStudent = new Student();

        fetchedStudent.setRoll_no(resultSet.getInt("ROLL_NO"));
        fetchedStudent.setName(resultSet.getString("STUDENT_NAME"));
        fetchedStudent.setAddress(resultSet.getString("STUDENT_ADDRESS"));

        return fetchedStudent;
    }
}
