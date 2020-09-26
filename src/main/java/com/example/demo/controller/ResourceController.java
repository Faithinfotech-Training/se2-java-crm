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

import com.example.demo.entity.Resources;
import com.example.demo.service.ResourcesService;

@CrossOrigin
@RestController
@RequestMapping("api")
public class ResourceController {
	// private ResourceDAO resourceDAO;
	private ResourcesService resourceService;

	@Autowired
	public ResourceController(ResourcesService theResourceService) {
	resourceService = theResourceService;
	}
	/*
	 * @Autowired public ResourceRestController(ResourceDAO theResourceDAO) {
	 * resourceDAO = theResourceDAO; }
	 * 
	 * @GetMapping("/resources") public List<Resource> findAll() { return
	 * resourceDAO.findAll(); }
	 */

	// expose "/resources" and return list of resources
	@GetMapping("/resources")
	public List<Resources> findAll() {
		return resourceService.findAll();
	}

	// add mapping for GET /resources/{resourceId}
	@GetMapping("/resources/{resourceId}")
	public Resources getResources(@PathVariable int resourceId) {
		Resources theResources = resourceService.findResourcesById(resourceId);
		if (theResources == null) {
			throw new RuntimeException("Resource id not found - " + resourceId);
		}
		return theResources;
	}

	// add mapping for POST /resources - add new resource
	@PostMapping("/resources")
    public Resources addResource(@RequestBody Resources theResource) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        theResource.setResourceId(0);
        resourceService.saveResources(theResource);
        return theResource;
    }

    // add mapping for PUT /resources - update existing resource
    @PutMapping("/resources")
    public Resources updateResource(@RequestBody Resources theResource) {
        resourceService.saveResources(theResource);
        return theResource;
    }
	// add mapping for DELETE /resources/{resourceId} - delete resource
	@DeleteMapping("/resources/{resourceId}")
	public String deleteResource(@PathVariable int resourceId) {
		Resources tempResource = resourceService.findResourcesById(resourceId);
		// throw exception if null
		if (tempResource == null) {
			throw new RuntimeException("Resource id not found - " + resourceId);
		}
		resourceService.deleteResourcesById(resourceId);
		return "Deleted resource id - " + resourceId;
	}
}
