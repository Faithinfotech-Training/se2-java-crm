package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ResourceType;
import com.example.demo.service.ResourceTypeService;


@RestController
@RequestMapping("api")
public class ResourceTypeController {
	// private ResourceDAO resourceTypeDAO;
		private ResourceTypeService resourceTypeService;

		@Autowired
		public ResourceTypeController(ResourceTypeService theResourceService) {
		resourceTypeService = theResourceService;
		}
		/*
		 * @Autowired public ResourceRestController(ResourceDAO theResourceDAO) {
		 * resourceTypeDAO = theResourceDAO; }
		 * 
		 * @GetMapping("/resourceTypes") public List<Resource> findAll() { return
		 * resourceTypeDAO.findAll(); }
		 */

		// expose "/resourceTypes" and return list of resourceTypes
		@GetMapping("/resourceTypes")
		public List<ResourceType> findAll() {
			return resourceTypeService.findAll();
		}

		// add mapping for GET /resourceTypes/{resourceTypeId}
		@GetMapping("/resourceTypes/{resourceTypeId}")
		public ResourceType getResources(@PathVariable int resourceTypeId) {
			ResourceType theResourceType = resourceTypeService.findResourceTypeById(resourceTypeId);
			if (theResourceType == null) {
				throw new RuntimeException("Resource id not found - " + resourceTypeId);
			}
			return theResourceType;
		}

		// add mapping for POST /resourceTypeTypes - add new resourceType
		@PostMapping("/resourceTypes")
		public ResourceType addResource(@RequestBody ResourceType theResource) {
			// also just in case they pass an id in JSON ... set id to 0
			// this is to force a save of new item ... instead of update
			theResource.setResourceTypeId(0);
			resourceTypeService.saveResourceType(theResource);
			return theResource;
		}

		// add mapping for PUT /resourceTypes - update existing resourceType
		@PutMapping("/resourceTypes")
		public ResourceType updateResource(@RequestBody ResourceType theResource) {
			resourceTypeService.saveResourceType(theResource);
			return theResource;
		}

		// add mapping for DELETE /resourceTypes/{resourceTypeId} - delete resourceType
		@DeleteMapping("/resourceTypes/{resourceTypeId}")
		public String deleteResource(@PathVariable int resourceTypeId) {
			ResourceType tempResource = resourceTypeService.findResourceTypeById(resourceTypeId);
			// throw exception if null
			if (tempResource == null) {
				throw new RuntimeException("Resource id not found - " + resourceTypeId);
			}
			resourceTypeService.deleteResourceTypeById(resourceTypeId);
			return "Deleted resourceType id - " + resourceTypeId;
		}
}
