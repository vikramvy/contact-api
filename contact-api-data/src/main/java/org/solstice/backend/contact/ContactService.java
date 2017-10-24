package org.solstice.backend.contact;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("contactService")
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	/*private List<Contact> contacts = new ArrayList<Contact>(Arrays.asList(	
		
		new Contact("1", "A", "S", "a@email.com", "10/10/2017", "312-11-2222", "312-11-2221", "Test Address", "/user.jpg"),
		new Contact("2", "b", "S", "b@email.com", "10/10/2017", "312-11-2222", "312-11-2221", "Test Address", "/user.jpg"),
		new Contact("3", "c", "S", "c@email.com", "10/10/2017", "312-11-2222", "312-11-2221", "Test Address", "/user.jpg")
		
		));*/
	
	public List<Contact> getAllContacts()
	{
		List<Contact> contacts = new ArrayList<Contact>();
		contactRepository.findAll()
		.forEach(contacts::add);
		return contacts;
	}
	
	public Contact getContact(String id)
	{
		//return contacts.stream().filter(c->c.getId().equals(id)).findFirst().get();
		Contact contact = contactRepository.findOne(id);
		if(contact==null)
		{
			throw new ContactNotFoundException("ID - "+id +"Not Found");
			
		}
		return contact;
			
	}
	public void addContact(Contact contact) {
		contactRepository.save(contact);
			
	}
	public void updateContact(Contact contact, String id)
	{
		contactRepository.save(contact);
		
	}
	
	public void deleteContact(String id)
	{
		contactRepository.delete(id);	
		
	}
	
	public Contact findbyPhone(String phone)
	{
		List<Contact> list = new ArrayList<Contact> ();
		contactRepository.findAll().forEach(list::add);
		Contact contactwithPhone = list.stream().filter(c->c.getPersonalPhone().equals(phone)).findAny().get();
		if(contactwithPhone==null)
			{
				throw new ContactNotFoundException("Contact with Phone "+phone +"Not Found");
				
			}
		contactwithPhone.toString();
		return contactwithPhone;
		
	}

	public Contact searchByPhoneEmail(String email)
	{
		
		Optional<Contact> contact = contactRepository.findByemail(email);
				return contact.get();
	}
	
	public Contact searchByPhone(String phone)
	{
		
		Optional<Contact> contactLazy ;
		Contact contact = new Contact();
		contactLazy = contactRepository.findBypersonalPhone(phone);
		if(contactLazy.isPresent())
		{	contact =  contactLazy.get();
		}
		else
		{
			contactLazy = contactRepository.findByworkPhone(phone);
			if(contactLazy.isPresent())
			{
				contact = contactLazy.get();
			}
		}
		return contact;		
	}
	
	public List<Contact> findbyState(String state){
		
		List<Contact> contactList = new ArrayList<Contact> ();
		contactList = contactRepository.findByaddressState(state);
		
		return contactList;
	}
	
	public List<Contact> findbyCity(String city){
		
		List<Contact> contactList = new ArrayList<Contact> ();
		contactList = contactRepository.findByaddressCity(city);
		
		return contactList;
	}
	
}
