package com.example.td1.DAO;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.td1.Model.*;

@RepositoryRestResource
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

	@RestResource(path = "/Q1")
	@Query("select e from Etudiant e where e.iddepartement.nomDepartement='informatique' order by e.dateEntree DESC")
	List<Etudiant> findBydateEntree();
   
		
	  //Donner les noms des étudiants qui contiennent les Lettres L et M ==>non
	  
	  @RestResource(path="/Q2")
	   List<Etudiant> findByNomEContainingAndNomEContaining(String x, String y);
	 

	// Donner le département qui a l’étudiant le plus ancien==> oui
	@RestResource(path ="/Q3")
	@Query("select distinct e.iddepartement from Etudiant e where e.dateEntree = (select min(e.dateEntree) from Etudiant e)")
	Departement departementEtPlusAncien();

	// Donner la moyenne des Moyennes des étudiants => oui
	@RestResource(path = "/Q4")
	@Query("select AVG(e.moyenne) from Etudiant e ")
	Double MMoyenne();

	// Donner les étudiants ayant les meilleurs moyens dans chaque département==>
	// oui
	@RestResource(path = "/Q5")
	@Query("select e from Etudiant e where e.moyenne =(select max(e1.moyenne) from Etudiant e1 where e1.iddepartement=e.iddepartement)")
	List<Etudiant> MoyenneEByDEpt();

	// Donner le ou les étudiant(s) ayant la meilleure moyenne

	@RestResource(path = "/Q6")
	@Query("select e from Etudiant e where e.moyenne =(select max(e1.moyenne) from Etudiant e1)")
	List<Etudiant> MeilleurMoyenne();

	
	  //Donner le nombre des étudiants de chaque département ==> non
	  
	  @RestResource(path="/Q7")
	  @Query("select count(e.iddepartement),e.iddepartement from Etudiant e group by e.iddepartement")
	   Object[] NBDept();
	  
	
		
		/*
		 * //Donner le département qui possède le moins des étudiants==>non
		 * 
		 * @RestResource(path="/Q8")
		 * 
		 * @Query("") List<Departement> DeptPossedeMinNbEtud();
		 */
		 
	  
	  //Donner les niveaux de chaque spécialité ==>non 
	  
		/*
		 * @RestResource(path="/Q9")
		 * 
		 * @Query("select distinct e.niveau from Etudiant e") List<Integer> NiveauSp();
		 */
	 
		/*
		 * //Donner le niveau ayant le plus d’étudiants
		 * 
		 * @RestResource(path="/Q9")
		 * 
		 * @Query("") List<Departement> DeptPossedeMinNbEtud();
		 */
}
