package JDBC_select002.dao;

import JDBC_select002.api.Ability;

import java.util.List;

public interface AbilityDao {
    void insert(Ability ability);
    void insert(List<Ability> abilityList);


    List<Ability> findAllAbility();

    void cleanUp();

    Ability findAbilityByID(int rollNo);
}
