package com.teamreact;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class QlsvApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(QlsvApplication.class, args);
//		java.sql.Date date = java.sql.Date.valueOf("2000-12-29");
//		System.out.println(date.toString());
	}
	
	public static Date parseDate(String date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

}
