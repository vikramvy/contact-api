package org.solstice.backend.contact;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ContactRepository extends CrudRepository<Contact, String>{

	//getAllContacts
	//getContact(String id)
	//CreateContact
	//upateContact
	//Delete Contact
	
	Optional<Contact> findByemail(String email);
	Optional<Contact> findBypersonalPhone(String personalPhone);
	Optional<Contact> findByworkPhone(String workPhone);

	@Query("SELECT t FROM Contact t where t.addressState = ?1")
    public List<Contact> findByaddressState(String state);


	@Query("SELECT t FROM Contact t where t.addressCity = ?1")
    public List<Contact> findByaddressCity(String city);


}


