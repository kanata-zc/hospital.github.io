package cdu.edu.hospital.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.junit.Test;

public class TestRodm {
	@Test
	public void test01(){
		Long ok = System.currentTimeMillis();
		System.out.println(ok);
	}
	@Test
	public void testDate() throws ParseException{
		java.util.Date worktime = null;
		String time = "2017-04-21 14:01:05";
		if (!(time == null || "".equals(time))) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.ENGLISH);
			sdf.setLenient(false);   
			worktime =  sdf.parse(time);
		}
		System.out.println("时间转换后："+new Timestamp(worktime.getTime()));
	} 
	@Test
	public void testDate01(){
		String time = "2017-04-21";
		java.sql.Date worktime  =java.sql.Date.valueOf(time);
		System.out.println(worktime);
	}
}
