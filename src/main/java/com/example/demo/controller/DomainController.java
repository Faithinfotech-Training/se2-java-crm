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

import com.example.demo.entity.Domain;
import com.example.demo.entity.Qualification;
import com.example.demo.service.DomainService;

@RestController
@RequestMapping("/api")
public class DomainController {
	
	private DomainService domainService;
	
	@Autowired
	public DomainController(DomainService domainService) {
		this.domainService = domainService;
	}

	//get all domain
	@GetMapping("/domain")
	public List<Domain> findAllDomains() {
		return domainService.findAllDomain();
	}

	//get domain by id
	@GetMapping("/domain/{domainId}")
	public Domain getDomain(@PathVariable int domainId) {
		Domain Domain = domainService.findDomainById(domainId);
		if (Domain == null) {
			throw new RuntimeException("Domain id not found - " + domainId);
		}
		return Domain;
	}

	//add domain
	@PostMapping("/domain")
	public Domain addDomain(@RequestBody Domain Domain) {
		Domain.setDomainId(0);
		domainService.save(Domain);
		return Domain;
	}
	
	//edit domain
	@PutMapping("/domain")
    public Domain updateDomain(@RequestBody Domain domain) {
		domainService.save(domain);
        return domain;
    }
	
	//delete domian
	@DeleteMapping("/domain/{domainId}")
	public String deleteDomainById(@PathVariable int domainId) {
		Domain Domain = domainService.findDomainById(domainId);
		if (Domain == null) {
			throw new RuntimeException("Domain id not found - " + domainId);
		}
		domainService.deleteDomainById(domainId);
		return "Deleted Domain id - " + domainId;
	}
}
