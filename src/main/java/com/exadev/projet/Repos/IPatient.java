package com.exadev.projet.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exadev.projet.Model.Patient;

@Repository
public interface IPatient extends JpaRepository<Patient, Long> {

 

}
