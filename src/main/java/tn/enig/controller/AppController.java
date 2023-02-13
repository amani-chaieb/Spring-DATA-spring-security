package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IMateriel;
import tn.enig.model.Departement;
import tn.enig.model.Materiel;

@Controller
public class AppController {

	@Autowired
	private IDepartement dao;
	@Autowired
	private IMateriel dao1;
	
	public void setDao(IDepartement dao) {
		this.dao=dao;
	}
	public void setDao(IMateriel mat) {
		this.dao1=mat;
	}
	@GetMapping("/depts")
	public String f1(Model m) {
		List<Departement> listeDepartement=dao.findAll();
		m.addAttribute("ld", listeDepartement);
		return"departements";
		
		}
	@GetMapping("/mtrl/{id}")
	public String f2(Model m, @PathVariable int id) {
		List<Materiel>liste=dao1.getAllMaterielByDepartement(id);
		Departement dept=dao.findOne(id);
		m.addAttribute("liste", liste);
		m.addAttribute("dept", dept);
		return "ListeMaterielsDepartement";
	}
	@GetMapping("/ajout")
	public String f3(Model m) {
		Materiel mat=new Materiel();
		m.addAttribute("mat",mat);
		List<Departement>lp=dao.findAll();
		m.addAttribute("lp", lp);
		return "AjouterMateriel";	
	}
	@PostMapping("/save")
	public String f4(Model m, @ModelAttribute("mat") Materiel mat) {
		dao1.save(mat);
		return "redirect:/depts";
		
	}
	@GetMapping("/delete/{id}")
	public String f5(@PathVariable int id) {
		dao1.delete(id);
		return "redirect:/depts";
	}
	
	
	
	
	
	
}
