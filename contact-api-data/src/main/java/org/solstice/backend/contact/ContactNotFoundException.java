package org.solstice.backend.contact;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(org.springframework.http.HttpStatus.NOT_FOUND)
public class ContactNotFoundException extends RuntimeException {

	public ContactNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
