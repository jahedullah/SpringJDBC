package JDBC_select002.service;

import JDBC_select002.api.Ability;
import JDBC_select002.dao.AbilityDao;
import JDBC_select002.dao.AbilityDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("abilityDaoHelper")
public class AbilityDaoHelper {
    @Autowired
    private AbilityDao AbilityDaoImpl;
    public void setUpAbilityTable(){
        Ability newA1 = new Ability();
        newA1.setID(1);
        newA1.setType("Flash");
        newA1.setCount(2);

        Ability newA2 = new Ability();
        newA2.setID(2);
        newA2.setType("Grenade");
        newA2.setCount(1);

        Ability newA3 = new Ability();
        newA3.setID(3);
        newA3.setType("Freeze");
        newA3.setCount(3);

        ArrayList<Ability> abilityList = new ArrayList<>();
        abilityList.add(newA1);
        abilityList.add(newA2);
        abilityList.add(newA3);


        AbilityDaoImpl.insert(abilityList);
    }
}
