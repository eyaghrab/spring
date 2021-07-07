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

import com.exadev.projet.Model.Consultation;
import com.exadev.projet.service.ConsultationService;


@RestController
@RequestMapping("api/Consultation")
public class ConsultationControlleur {
	@Autowired private  ConsultationService  consultationService;
	
	//public ConsultationControlleur(ConsultationService consultationService) {
		//super();
		//this.consultationService = consultationService;
	//}
	@GetMapping()
	public List<Consultation> getallConsultation(){
		return consultationService.getallConsultation();
	}
	@GetMapping("/{id}")
	public Consultation  getConsultationById(@PathVariable  Long id){
		return consultationService.getConsultationById(id);
		
		
		
	}
	@PostMapping()
	public Consultation addConsultation(@RequestBody Consultation consultation){
		return  consultationService.addConsultation(consultation);
	}
	@PutMapping()
	public Consultation  updateConsultation (@RequestBody Consultation consultation ){
		return  consultationService.addConsultation(consultation);
		
	}
	@DeleteMapping("/{id}")
	public void  deleteConsultation (@PathVariable Long id){
		consultationService.deleteConsultation(id);
	}



}




