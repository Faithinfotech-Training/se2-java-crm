package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Qualification;
import com.example.demo.service.QualificationService;

@RestController
@RequestMapping("/api")
public class QualificationController {
	
	private QualificationService qualificationService;
	
	@Autowired
	public QualificationController(QualificationService qualificationService) {
		this.qualificationService = qualificationService;
	}


	@GetMapping("/qualification")
	public List<Qualification> findAllQualifications() {
		return qualificationService.findAllQualification();
	}

	
	@GetMapping("/qualification/{qualificationId}")
	public Qualification getQualification(@PathVariable int qualificationId) {
		Qualification Qualification = qualificationService.findQualificationById(qualificationId);
		if (Qualification == null) {
			throw new RuntimeException("Qualification id not found - " + qualificationId);
		}
		return Qualification;
	}

	@PostMapping("/qualification")
	public Qualification addQualification(@RequestBody Qualification Qualification) {
		Qualification.setQualificationId(0);
		qualificationService.save(Qualification);
		return Qualification;
	}

	@DeleteMapping("/qualification/{qualificationId}")
	public String deleteQualificationById(@PathVariable int qualificationId) {
		Qualification Qualification = qualificationService.findQualificationById(qualificationId);
		if (Qualification == null) {
			throw new RuntimeException("Qualification id not found - " + qualificationId);
		}
		qualificationService.deleteQualificationById(qualificationId);
		return "Deleted Qualification id - " + qualificationId;
	}
}