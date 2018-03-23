package com.m2i.formation.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contact  implements Serializable{
	
	@Id @GeneratedValue
	private Long id ; 
	private String nom ; 
	private String prenom ; 
	private String email ;
	@Temporal(value=TemporalType.DATE)
	private Date dateNaissance ; 
	private String tel ; 
	private String photo ;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String nom, String prenom, String email, Date dateNaissance, String tel, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.dateNaissance = dateNaissance;
		this.tel = tel;
		this.photo = photo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	} 
	
	
	

}
