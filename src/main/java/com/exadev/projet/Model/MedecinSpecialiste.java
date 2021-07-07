package com.exadev.projet.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import net.minidev.json.annotate.JsonIgnore;

@Entity
@DiscriminatorValue("MS")
public class MedecinSpecialiste extends Medecin implements Serializable {

	private String specialite;
	
	
	@ManyToMany(mappedBy = "courses")
	private List<Patient> students;

	public MedecinSpecialiste() {
		super();
	}

	public MedecinSpecialiste(String nom, String prenom, String dateNaissance, String email,
			String codePublic, String specialite) {
		super(nom, prenom, dateNaissance, email, codePublic);
		this.specialite = specialite;
	}

	public String getspecialite() {
		return specialite;
	}

	public void setspecialite(String specialite) {
		this.specialite = specialite;
	}

	
	public List<Patient> getStudents() {
		return students;
	}

	public void setStudents(List<Patient> students) {
		this.students = students;
	}

	// TODO getters and setters for all properties

}
