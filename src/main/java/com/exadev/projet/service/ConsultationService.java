package com.exadev.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exadev.projet.Model.Consultation;
import com.exadev.projet.Repos.ConsultationRepository;
@Service
public class ConsultationService {
	@Autowired	private ConsultationRepository  Consul;
	
	
	public Consultation addConsultation( Consultation consultation){
        return  Consul.save(consultation);
		}
	
	public void deleteConsultation(Long id){
		Consul.delete(id);
		

	}

	
	public Consultation getConsultationById(Long id ) {
		return Consul.getOne(id);
	}
	
	
	
	public List<Consultation> getallConsultation() {
		return Consul.findAll();
		}

	public Consultation updateConsultation(Consultation consultation) {
		return Consul.save(consultation);

	}
	


}
