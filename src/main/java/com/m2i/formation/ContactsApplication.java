package com.m2i.formation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.m2i.formation.dao.ContactRepository;
import com.m2i.formation.entities.Contact;

@SpringBootApplication
public class ContactsApplication implements CommandLineRunner{
	
	@Autowired
	private ContactRepository contactRepository ;

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}

	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	@Override
	public void run(String... args) throws Exception {
		contactRepository.save(new Contact("walid", "hachani", "walid@gmail.Com" ,df.parse("20/08/1985"), "0778021366", "walid.jpg"));
		contactRepository.save(new Contact("skander", "hachani", "skander@gmail.Com" ,df.parse("20/08/2016"), "0778021366", "saknder.jpg"));
		contactRepository.save(new Contact("meriem", "hachani", "meriem@gmail.Com" ,df.parse("20/08/1983"), "0778021366", "meriem.jpg"));
		contactRepository.findAll().forEach(c-> {
			System.out.println(c.getNom());
		});
		
	}
}
