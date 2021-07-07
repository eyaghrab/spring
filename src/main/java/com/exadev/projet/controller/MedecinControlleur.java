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

import com.exadev.projet.Model.Medecin;
import com.exadev.projet.Model.MedecinGeneraliste;
import com.exadev.projet.Model.MedecinSpecialiste;
import com.exadev.projet.service.MedcinService;


@RestController
@RequestMapping("api/medecin")
public class MedecinControlleur {

	
	
	@Autowired	private MedcinService medecinService ;
	
	@GetMapping()
	public List<Medecin> getallMedecin(){
		return  medecinService.getallMedecin();
	}
	@GetMapping("/{id}")
	public Medecin  getMedcinById(@PathVariable  Long id){
		
		return medecinService.getMedcinById(id);
		
		
		
	}
	@PostMapping()
	public Medecin addMedecin(@RequestBody Medecin medecin){
		return  medecinService.addMedecin(medecin);
	}
	@DeleteMapping("/{id}")
	public void deletePatient(@PathVariable Long id){
		medecinService.deleteMedecin(id);
	}

@PutMapping()
public Medecin  updateMedecin (@RequestBody Medecin medecin){
	return  medecinService.updateMedecin(medecin);
	
}
@PostMapping(value="/saveMedecinG")
public MedecinGeneraliste save(@RequestBody MedecinGeneraliste med){
	return medecinService.save(med);
}
@PostMapping(value="/saveMedecinSpec")
public MedecinSpecialiste saveMedecinSpecialiste(@RequestBody MedecinSpecialiste med){
	return medecinService.saveMedecinSpecialiste(med);
}
@PutMapping(value="/saveMedecinSpec")
public Medecin  updateMedecinSpecialiste (@RequestBody MedecinSpecialiste med){
	return  medecinService.updateMedecinSpecialiste(med);

}

@PutMapping(value="/saveMedecinG")
public Medecin  updateMedecinGeneraliste (@RequestBody MedecinGeneraliste med){
	return  medecinService.updateMedecinGeneraliste(med);

}

	


}
