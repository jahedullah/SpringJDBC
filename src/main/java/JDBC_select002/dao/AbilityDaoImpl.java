package JDBC_select002.dao;

import JDBC_select002.api.Ability;
import JDBC_select002.api.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("abilityDaoImpl")
public class AbilityDaoImpl implements AbilityDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public AbilityDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public void insert(Ability ability) {
        String sql = "INSERT INTO ABILITY VALUES (?,?,?)";
        Object[] arg = {ability.getID(),ability.getType(),ability.getCount()};

        int noOfRowInserted = jdbcTemplate.update(sql, arg);
        System.out.println("No of Row inserted: " + noOfRowInserted);
    }

    @Override
    public void insert(List<Ability> abilityList) {
        String sql = "INSERT INTO ABILITY VALUES(?,?,?)";
        ArrayList<Object[]> sqlArgs = new ArrayList<>();

        for(Ability tempAbility:abilityList){
            Object[] abilityData = {tempAbility.getID(),tempAbility.getType(),tempAbility.getCount()};
            sqlArgs.add(abilityData);
        }
        jdbcTemplate.batchUpdate(sql,sqlArgs);
        System.out.println("Batch Update Done.");

    }

    @Override
    public List<Ability> findAllAbility() {
        return null;
    }

    @Override
    public void cleanUp() {

    }

    @Override
    public Ability findAbilityByID(int rollNo) {
        return null;
    }
}
