package cdu.edu.hospital.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	ApplicationContext ac;
	@Test
	public void testSpring(){
		 ac = new ClassPathXmlApplicationContext("spring-mybatis.xml");
		 System.out.println("ac="+ac);
	} 
}