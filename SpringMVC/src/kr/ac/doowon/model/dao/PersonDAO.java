package kr.ac.doowon.model.dao;

import java.sql.SQLException;
import java.util.List;

import kr.ac.doowon.model.beans.Person;

public interface PersonDAO {
   public boolean insert(Person person)throws SQLException;
   public boolean delete(String name)throws SQLException;
   public boolean update(Person person);//throws SQLException;
   public Person select(String name);//throws SQLException;
   public List<Person> selectAll();
}







