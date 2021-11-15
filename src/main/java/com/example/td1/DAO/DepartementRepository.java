package com.example.td1.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.td1.Model.Departement;

@RepositoryRestResource
public interface DepartementRepository extends JpaRepository <Departement, Long>{
	
	  //Donner le nombre des étudiants de chaque département ==> non
	  @RestResource(path="/Q7")
	  @Query("select d, count(e) from Departement d join d.etudiants e group by d")
	   Object[] NBDept();
}
