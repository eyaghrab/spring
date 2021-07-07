package com.exadev.projet.Model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("MG")
public class MedecinGeneraliste extends Medecin implements Serializable {

	
	@OneToMany(mappedBy = "generaliste")
	private List<Patient> patients;


	public MedecinGeneraliste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MedecinGeneraliste(String nom, String prenom, String dateNaissance, String email,
			String codePublic) {
		super(nom, prenom, dateNaissance, email, codePublic);
		// TODO Auto-generated constructor stub
	}

	
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

}
