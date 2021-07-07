package com.exadev.projet.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Patients")
public class Patient implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Lob
	private String email;
	private String tel;
	private String numCnam;

	public Patient() {
		super();
	}

	@ManyToMany
	@JoinTable(name = "Pat_MedSp", joinColumns = {
			@JoinColumn(name = "Patient_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "MedSpec_id", referencedColumnName = "id") })
	private List<MedecinSpecialiste> courses;

	@ManyToOne(cascade = CascadeType.MERGE)
	private MedecinGeneraliste generaliste;

	@OneToMany(mappedBy = "patient")
	private Collection<Consultation> consultations;

	public Patient(String nom, String prenom, Date dateNaissance, String email, String tel,
			String numCnam) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.tel = tel;
		this.numCnam = numCnam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom
				;
	}

	public void setNom(String name) {
		this.nom = name;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	
	

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getNumCnam() {
		return numCnam;
	}

	public void setNumCnam(String numCnam) {
		this.numCnam = numCnam;
	}

	public List<MedecinSpecialiste> getCourses() {
		return courses;
	}

	public void setCourses(List<MedecinSpecialiste> courses) {
		this.courses = courses;
	}

	public MedecinGeneraliste getGeneraliste() {
		return generaliste;
	}

	public void setGeneraliste(MedecinGeneraliste generaliste) {
		this.generaliste = generaliste;
	}

	// TODO add getters and setters for all properties

}
