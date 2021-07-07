package com.exadev.projet.controller;

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

import com.exadev.projet.Model.Patient;
import com.exadev.projet.service.PatientService;

@RestController
@RequestMapping("api/patient")
public class PatientController {
	
@Autowired	private PatientService patientService ;
	
	@GetMapping()
	public List<Patient> getAllPatients(){
		return patientService.getallPatient();
	}
	@GetMapping("/{id}")
	public Patient  getPatientById(@PathVariable  Long id){
		return patientService.getPatientById(id);
		
		
		
	}
	@PostMapping()
	public Patient addPatient(@RequestBody Patient patient){
		return  patientService.addPatient(patient);
	}
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id){
		patientService.deletePatient(id);
	}

@PutMapping()
public Patient  updatePatient (@RequestBody Patient patient){
	return  patientService.updatePatient(patient);
	
}


}
