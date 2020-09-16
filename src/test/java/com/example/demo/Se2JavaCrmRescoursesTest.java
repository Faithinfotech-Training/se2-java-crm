package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.ResourcesDAO;
import com.example.demo.dao.AccessDAO;
import com.example.demo.dao.StatusDAO;
import com.example.demo.service.StatusService;

import com.example.demo.entity.Access;
import com.example.demo.entity.ResourceType;
import com.example.demo.entity.Resources;
import com.example.demo.entity.Status;
import com.example.demo.service.ResourcesService;
import com.example.demo.service.AccessService;
import com.example.demo.service.ResourceTypeService;
import com.example.demo.dao.ResourceTypeDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Se2JavaCrmRescoursesTest {
	@Autowired
	private ResourcesService resourcesService;
	@MockBean
	private ResourcesDAO resourcesDAO;
	
//	Check if resourcesDAO is autowired correctly
	@Test
	public void injectedServicesAreNotNull() {
		assertThat(resourcesService).isNotNull();
	}
	@Test
	public void findAllResourcesTest() {
		
		Status status = new Status(1,"Active");
		Access access = new Access(1,"Private");
		ResourceType resourceType = new ResourceType(1,"Hall");
		
		Resources resources = new Resources("ABC hall", "A big hall", 20, 3000, status, access, resourceType);
		
		when(resourcesDAO.findAllResources()).thenReturn(Stream.of(resources).collect(Collectors.toList()));
		
		assertEquals(1, resourcesService.findAll().size());
		
		
	}
	
	
//	Check if findResourcesById works

	@Test
	public void findAllResourcesByIdTest() {
		
		Status status = new Status(1,"Active");
		Access access = new Access(1,"Private");
		ResourceType resourceType = new ResourceType(1,"Hall");
		
		Resources resources = new Resources("ABC hall", "A big hall", 20, 3000, status, access, resourceType);
		
		when(resourcesDAO.findResourcesById(1)).thenReturn(resources);

		assertEquals(new Integer(20), resourcesService.findResourcesById(1).getCapacity());
		
		
	}
	
//	Check if save resources works
	@Test
	public void saveResourceTest() {
		
		Status status = new Status(1,"Inactive");
		Access access = new Access(1,"Public");
		ResourceType resourceType = new ResourceType(1,"Classroom");
		
		Resources resources = new Resources("New Hall", "A big hall", 20, 3000, status, access, resourceType);
		
		resourcesDAO.saveResources(resources);

		verify(resourcesDAO,times(1)).saveResources(resources);
		
	}
	
}
