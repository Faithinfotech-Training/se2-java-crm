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

	// get all qualification
	@GetMapping("/qualification")
	public List<Qualification> findAllQualifications() {
		return qualificationService.findAllQualification();
	}

	// get qualification by id
	@GetMapping("/qualification/{qualificationId}")
	public Qualification getQualification(@PathVariable int qualificationId) {
		Qualification Qualification = qualificationService.findQualificationById(qualificationId);
		if (Qualification == null) {
			throw new RuntimeException("Qualification id not found - " + qualificationId);
		}
		return Qualification;
	}

	// insert qualification
	@PostMapping("/qualification")
	public Qualification addQualification(@RequestBody Qualification qualification) {
		qualification.setQualificationId(0);
		qualificationService.save(qualification);
		return qualification;
	}

	//edit qualifiaction
	@PutMapping("/qualification")
	public Qualification updateQualification(@RequestBody Qualification qualification) {
		qualificationService.save(qualification);
		return qualification;
	}

	//delete qualification
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
