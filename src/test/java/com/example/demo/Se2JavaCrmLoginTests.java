package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.CourseEnquiryDAO;
import com.example.demo.dao.LoginDAOImplementation;
import com.example.demo.entity.LoginInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmLoginTests

{
	@MockBean
	private LoginDAOImplementation loginDAOImplementation;
	
	@Test
	public void loginTest()
	{
		String response=loginDAOImplementation.login("","");
		assertEquals(null,response);
		
	}
}
