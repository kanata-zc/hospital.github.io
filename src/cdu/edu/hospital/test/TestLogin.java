package cdu.edu.hospital.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import cdu.edu.hospital.dao.UserDao;
import cdu.edu.hospital.entity.User;

public class TestLogin {
	ApplicationContext ac;
	UserDao dao;
	@Before
	public void init(){
		ac = new ClassPathXmlApplicationContext(new String[]{"spring-mybatis.xml","spring-service.xml"});
	}
	@Test //≤‚ ‘Mybatisµƒ≈‰÷√
	public void testMapper(){
		Object obj = ac.getBean("mapperScanner");
		System.out.println("mapperScanner:"+obj); 
	} 
	@Test //≤‚ ‘findUser
	public void testFindUser(){
		UserDao dao = ac.getBean("userDao",UserDao.class);
		User user = new User();
		user.setId("0001");
		System.out.println(dao.findUser(user));
	}
}
