package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spirng.jdbc.dao.*;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
//        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
        
//        JdbcTemplate template = (JdbcTemplate) context.getBean("jdbcTemp");
//        
//        String query = "insert into Student(id, name, city) values(?, ?, ?)";
//        int result = template.update(query, 222, "akshita agg", "gurugram");
//        System.out.println("rows inserted = " + result);
        
      //StudentDaoImpl sDao = new StudentDaoImpl(); 
      //this sDao is not the bean, so it will not have ref of jdbctemp or datasource bean declared in config file

       StudentDao sDao = (StudentDao) context.getBean("studentDao"); //or you can assign bean to refvariable of type class StudentDaoImpl
       
        
        //INSERTING DATA
//        Student s = new Student();
//        s.setId(27);
//        s.setName("Kailash");
//        s.setCity("Delhi");
//        
//       int rows = sDao.insert(s);
//        System.out.println("rows inserted" + rows);
        
        
        //UPDATING DATA
//        Student s = new Student();
//        s.setId(25);
//        s.setName("Rohan Kumar");
//        s.setCity("Kanpur");
//        
//        int changedRows = sDao.change(s);
//        System.out.println("no. of rows changed " + changedRows);
       
       //DELETING DATA
//       int deletedRows = sDao.delete(222);
//       System.out.println("no. of rows deleted " + deletedRows); 
       
       //SELECTING ONE ROW
       Student stu = sDao.getStudent(25);
       System.out.println(stu);
       
       //SELECTING MULTIPLE ROWS (all rows in this eg)
       List<Student> stus = sDao.students();
       for(Student st : stus) {
    	   System.out.println(st);
       }
       
        
        
    }
}
