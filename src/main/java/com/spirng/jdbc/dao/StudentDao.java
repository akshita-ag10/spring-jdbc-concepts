package com.spirng.jdbc.dao;
import java.util.List;

import com.spring.jdbc.entities.Student;

public interface StudentDao {
	
	public int insert(Student s);
	public int change(Student s);
	public int delete(int studentId);
	public Student getStudent(int studentId);
	public List<Student> students();

}
