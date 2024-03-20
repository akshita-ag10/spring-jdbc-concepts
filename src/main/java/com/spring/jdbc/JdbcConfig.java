package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spirng.jdbc.dao.StudentDaoImpl;


@Configuration
@ComponentScan(basePackages = {"com.spirng.jdbc.dao"})
public class JdbcConfig {
	
	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("root");		
		return ds;
	}
	
	//METHOD 1 OF REF INJECTION
	@Bean("jdbcTemp")
	public JdbcTemplate getJdbcTemplate(DriverManagerDataSource dsAny) {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dsAny);
		return template;		
	}
	
	//we can also use autowired annotation instead of this
//	@Bean("studentDao")
//	public StudentDaoImpl getStudentDaoImpl(JdbcTemplate template) {
//		StudentDaoImpl sDao = new StudentDaoImpl();
//		sDao.setTemplate(template);
//		return sDao;
//		
//	}
	
	
	
	//METHOD 2 OF REF INJECTION
//	@Bean("jdbcTemp")
//	public JdbcTemplate getJdbcTemplate() {
//		JdbcTemplate template = new JdbcTemplate();
//		template.setDataSource(getDataSource());
//		return template;
//	}
//	
//	@Bean("studentDao")
//	public StudentDaoImpl getStudentDaoImpl() {
//		StudentDaoImpl sDao = new StudentDaoImpl();
//		sDao.setTemplate(getJdbcTemplate());
//		return sDao;
//	}
}
