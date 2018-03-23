package com.m2i.formation.web;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.formation.dao.ContactRepository;
import com.m2i.formation.entities.Contact;

@RestController
public class ContactRestService {
	
	@Autowired
	private ContactRepository contactRepository ;

	//afficher tout les contacts
	
	@RequestMapping(value="/contacts" , method= RequestMethod.GET)
	public List<Contact> getContacts(){
		
		return contactRepository.findAll();
	}
	
	// afficher un contact
	@RequestMapping(value="/contacts/{id}" , method= RequestMethod.GET)
	public Contact getContact(@PathVariable Long id){
		
		return contactRepository.findOne(id);
	}
	
	//ajouter un contact
	@RequestMapping(value="/contacts" , method= RequestMethod.POST)
	public Contact save(@RequestBody Contact c){
		
		return contactRepository.save(c);
	}
	
	//supprimer un contact
	@RequestMapping(value="/contacts/{id}" , method= RequestMethod.DELETE)
	public Boolean supprimer(@PathVariable Long id){
		contactRepository.delete(id);
		return true ;
	}
	
	//mettre à jour un contact
	@RequestMapping(value="/contacts/{id}" , method= RequestMethod.PUT)
	public Contact update(@PathVariable Long id,@RequestBody Contact c){
		c.setId(id);		
		return contactRepository.save(c);
	}
	
	// chercher par mot clé
	@RequestMapping(value="/chercher" , method= RequestMethod.GET)
	public Page<Contact> chercherByMc(@RequestParam(name="mc", defaultValue="")String mc ,
			@RequestParam(name="page" , defaultValue="0")int page ,
			@RequestParam(name="size", defaultValue="4")int size){
		
		return contactRepository.chercher("%"+mc+"%", new PageRequest(page, size));
	}
	
	
}
