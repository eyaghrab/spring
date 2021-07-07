package com.exadev.projet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exadev.projet.Model.Medecin;
import com.exadev.projet.Model.MedecinGeneraliste;
import com.exadev.projet.Model.MedecinSpecialiste;
import com.exadev.projet.Repos.IMedecin;


@Service
public class MedcinService {

	
	
	@Autowired	private IMedecin medecinRepos;
	public Medecin addMedecin( Medecin medecin){
        return  medecinRepos.save(medecin);
		}
	public void deleteMedecin(Long id){
		medecinRepos.delete(id);
		

	}
	public Medecin updateMedecin(Medecin medecin){
		return medecinRepos.save(medecin);
		
	}
	
	public Medecin getMedcinById(Long id ) {
		return medecinRepos.getMedecinById(id);
	}
	
	
	
	public List<Medecin> getallMedecin() {
		return medecinRepos.findAll();
		}
	public MedecinGeneraliste save(MedecinGeneraliste med) {
		// TODO Auto-generated method stub
		return medecinRepos.save(med);
	}
	public MedecinSpecialiste saveMedecinSpecialiste(MedecinSpecialiste med) {
		// TODO Auto-generated method stub
		return medecinRepos.save(med);
	}
	

	public Medecin updateMedecinSpecialiste(MedecinSpecialiste med){
		return medecinRepos.save(med);
		
	}
	public Medecin updateMedecinGeneraliste(MedecinGeneraliste med){
		return medecinRepos.save(med);
		
	}
	

}
