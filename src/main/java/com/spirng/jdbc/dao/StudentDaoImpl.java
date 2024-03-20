package com.spirng.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.entities.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public int insert(Student s) {
		String query = "insert into Student(id, name, city) values(?,?,?)";
		int r = this.template.update(query, s.getId(), s.getName(), s.getCity());
		return r;
	}
	
	public int change(Student s) {
		String query = "update student set name=?, city=? where id=?";
		int r = this.template.update(query, s.getName(), s.getCity(), s.getId());
		return r;
	}
	
	public int delete(int studentId) {
		String query = "delete from stuDent where id=?";
		int r = this.template.update(query, studentId);
		return r;
	}
	
	public Student getStudent(int studentId) {
		String query = "select * from studenT where id=?";
		RowMapper<Student> rowMapper = new RowMapperImpl();
		Student s = this.template.queryForObject(query,rowMapper, studentId);
		return s;
	}
	
	public List<Student> students() {
		String query = "select * from sTuDenT";
		List<Student> students = this.template.query(query, new RowMapperImpl());
		return students;
	}
	
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	

	
	
	
	
	


	

}
