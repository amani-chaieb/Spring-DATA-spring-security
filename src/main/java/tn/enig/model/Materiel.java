package tn.enig.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Materiel {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String type;
	private int serialNumber;
	private String state; 
	@ManyToOne
	@JoinColumn(name="depts_id")
	private Departement depts;
	public Materiel() {
		super();
		
	}
	public Materiel(Integer id, String title, String type, int serialNumber, String state, Departement depts) {
		super();
		this.id = id;
		this.title = title;
		this.type = type;
		this.serialNumber = serialNumber;
		this.state = state;
		this.depts = depts;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Departement getDepts() {
		return depts;
	}
	public void setDepts(Departement depts) {
		this.depts = depts;
	}
	
	
	
}
