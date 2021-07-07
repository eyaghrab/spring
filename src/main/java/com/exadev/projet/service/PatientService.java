package com.exadev.projet.service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.exadev.projet.Model.Patient;
import com.exadev.projet.Repos.IPatient;
import com.exadev.projet.Repos.PatientRepository;
@Service
public class PatientService {
	
@Autowired	private IPatient patientRepo;
	
	




	public Patient addPatient(   Patient patient){
          return  patientRepo.save(patient);
		}
	public void deletePatient(Long id){
		patientRepo.delete(id);
		

	}
	public Patient updatePatient(Patient patient){
		return patientRepo.save(patient);
		
	}
	
	public Patient getPatientById(Long id ) {
		return patientRepo.getOne(id);
	}
	
	
	
	public List<Patient> getallPatient() {
		return patientRepo.findAll();
		}

	
	
	
		
		
		
	}


		
	
	

	


