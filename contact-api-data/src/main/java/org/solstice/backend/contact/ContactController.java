package org.solstice.backend.contact;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
	
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/contacts")
	public List<Contact> getAllContacts()
	{
		log.info("log: accessing contacts resource get all contacts");
		return contactService.getAllContacts();
	}
	@RequestMapping("/contacts/{id}")
	public Contact getContact(@PathVariable String id)
	{
		return contactService.getContact(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/contacts")
	public void addContact(@Valid @RequestBody Contact contact)
	{
		contactService.addContact(contact);		
	}
	@RequestMapping(method=RequestMethod.PUT, value="/contacts/{id}")
	public void updateContact(@RequestBody Contact contact, @PathVariable String id)
	{
		contactService.updateContact(contact, id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/contacts/{id}")
	public void deleteContact(@PathVariable String id)
	{
		contactService.deleteContact(id);
	}
	@RequestMapping(method = RequestMethod.GET, value = "/contacts/phone/{phone}")
	public Contact findbyPhone(@PathVariable String phone)
	{		
		return contactService.findbyPhone(phone);
	}
	@RequestMapping(method = RequestMethod.GET, value ="/contacts/search", params ="email")
	@ResponseBody
	public Contact findByPhoneEmail(@RequestParam("email") String email)
	{
		Contact contact = contactService.searchByPhoneEmail(email);
		if(contact ==null)
		{
			throw new ContactNotFoundException("Contact for Email "+email+" Not Found");
		}
		return contact;
	}
	@RequestMapping(method = RequestMethod.GET, value ="/contacts/search", params ="phone")
	@ResponseBody
	public Contact findByPhone(@RequestParam("phone") String phone)
	{
		Contact contact = contactService.searchByPhone(phone);
		if(contact ==null)
		{
			throw new ContactNotFoundException("Contact for Email "+phone+" Not Found");
		}
		return contact;
	}
	@RequestMapping(method = RequestMethod.GET, value = "/contacts/state/{state}")
	public List<Contact> findContactsbyState(@PathVariable String state)
	{		
		return contactService.findbyState(state);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/contacts/city/{city}")
	public List<Contact> findContactsbyCity(@PathVariable String city)
	{		
		return contactService.findbyState(city);
		
	}
	
	
	
}
