package kr.ac.doowon.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.doowon.model.beans.Person;

public class PersonDAOImpl implements PersonDAO{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean insert(Person person) throws SQLException {		
		int t = sqlSession.insert("person.insert", person);
		if(t==1) return true;
		return false;
	}

	@Override
	public boolean delete(String name) throws SQLException {
		int t = sqlSession.delete("person.delete",name);
		if(t>0) return true;//nameÀÌ primary key¶ó¸é if(t==1)
		return false;
	}

	@Override
	public boolean update(Person person){
		int t = sqlSession.update("person.update",person);
		if(t>0) return true;
		return false;
	}

	@Override
	public Person select(String name) {		
		return sqlSession.selectOne("person.select", name);
	}

	@Override
	public List<Person> selectAll(){		
		return sqlSession.selectList("person.selectAll");
	}

}







