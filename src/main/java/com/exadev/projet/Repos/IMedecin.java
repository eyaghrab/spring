package com.exadev.projet.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exadev.projet.Model.Medecin;



public interface IMedecin extends JpaRepository<Medecin, Long> {
	Medecin getMedecinById(Long id );
}
