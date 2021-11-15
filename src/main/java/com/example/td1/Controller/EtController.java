package com.example.td1.Controller;
/*
import java.util.Collection;
import java.util.List;*/

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.td1.DAO.EtudiantRepository;
import com.example.td1.Model.Departement;
import com.example.td1.Model.Etudiant;

@RestController

@RequestMapping(value = "/etudiants")
public class EtController {

	@Autowired
	protected EtudiantRepository ER;
    
	
	@PostMapping("/AddE")
	public Etudiant ajouterE(@RequestBody Etudiant e) {
		return ER.save(e);
	}

	@GetMapping("/GetAllE")
	public List<Etudiant> afficherToutE() {
		return ER.findAll();
	}
	  @GetMapping("/Q1") public List<Etudiant> question1() { 
		  return  ER.findBydateEntree(); }
			  
	@GetMapping("/Q2") 
	public List<Etudiant> question2(){
		return ER.findByNomEContainingAndNomEContaining("m","l"); }

	
	  @GetMapping("/Q3") public Departement afficherdept() { return
	 ER.departementEtPlusAncien(); }
	
	  
	 @GetMapping("/Q4") public Double question4()
	 { return ER. MMoyenne(); }
	  
	  @GetMapping("/Q5") public List<Etudiant> question5() 
	 { return ER.MoyenneEByDEpt(); }
	 
	 
	  @GetMapping("/Q6") public List<Etudiant> question6()
	 { return ER.MeilleurMoyenne();}
	 
	  @GetMapping("/Q7") public Object[] question7() { return
	 ER.NBDept(); }
	  
	/* 
	 * @GetMapping("/Q8/{x}") public List<Departement> question8(@PathVariable Long
	 * x) { return ER.DeptPossedeMinNbEtud(x); }
	 * 
	 * 
	 * @GetMapping("/Q9") public List<Object> question9() { return ER.NiveauSp(); }
	 * 
	 * @GetMapping(path="/Q10") public List<Object> question10() { return ER.Ni(); }
	 * 
	 * 
	 * @GetMapping(path="/Q11/{x}") public Collection<Departement>
	 * question11(@PathVariable Long x) { return ER.DeptPossedeMaxNbEtud(x); }
	 * 
	 * @GetMapping(path="/Q12") public List<Departement> question12() { return
	 * ER.DepNexiste(); }
	 * 
	 * 
	 * @GetMapping(path="/Q13") public List<Object> question13() { return
	 * ER.grandNbEt(); }
	 * 
	 * 
	 * 
	 * 
	 * @GetMapping(path="/Q15") public List<Departement> question15() { return
	 * ER.grandNb(); }
	 * 
	 * 
	 */

}