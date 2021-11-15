package com.example.td1.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
public class Etudiant {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long numE;
	
	
	private String nomE;
	
	private int niveau;
	
	@DateTimeFormat (pattern = "Yyyy-mm-dd")
    private Date dateEntree;
	
	
	public Etudiant() {
		super();
	}

	public Etudiant(Long numE, String nomE, int niveau, Date dateEntree, Specialite idspecialite,
			Departement iddepartement, double moyenne) {
		super();
		this.numE = numE;
		this.nomE = nomE;
		this.niveau = niveau;
		this.dateEntree = dateEntree;
		this.idspecialite = idspecialite;
		this.iddepartement = iddepartement;
		this.moyenne = moyenne;
	}

	@ManyToOne
	@JoinColumn(name="idSpecialite")
	private Specialite idspecialite;
	
	@ManyToOne
	@JoinColumn(name="idDept")
	private Departement iddepartement;
	
	private double moyenne;

	public Long getNumE() {
		return numE;
	}

	public void setNumE(Long numE) {
		this.numE = numE;
	}

	public String getNomE() {
		return nomE;
	}

	public Departement getIddepartement() {
		return iddepartement;
	}

	public void setIddepartement(Departement iddepartement) {
		this.iddepartement = iddepartement;
	}

	public void setNomE(String nomE) {
		this.nomE = nomE;
	}
	
	public int getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Date getDateEntree() {
		return dateEntree;
	}

	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
   
	
	public Specialite getIdspecialite() {
		return idspecialite;
	}
	
	public void setIdspecialite(Specialite idspecialite) {
		this.idspecialite = idspecialite;
	}
	


	public double getMoyenne() {
		return moyenne;
	}

	public void setMoyenne(double moyenne) {
		this.moyenne = moyenne;
	}

	@Override
	public String toString() {
		return "Etudiants [IdE=" + numE + ", NomE=" + nomE + ", Niveau=" + niveau + ", DateE=" + dateEntree + ", st=" + idspecialite
				+ ", dt=" +iddepartement + ", moyenne=" + moyenne + "]";
	}
}
