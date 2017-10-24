package org.solstice.backend.contact;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	@Size(min=2) @NotNull
	private String name;
	@Size(min=4)
	private String company;
	@Email
	@NotNull
	private String email;
	@NotNull
	private String birthDate;
	@Size(min = 10, message="Phone Number entered [${validatedValue}] is Invalid. It mush have at least {min} digits")
	private String workPhone;
	@Size(min = 10, message ="phone number entered [${validatedValue}] is invalid. It must have at least {min} digits")
	private String personalPhone;
	private String addressLine1;
	private String addressLine2;
	private String addressCity;
	private String addressState;
	private String addressCountry;
	private String profileImageUrl;
	
	
	
	public Contact()
	{
		
	}
	
	//(String id,
	public Contact( String name, String company, String email, String birthDate, String workPhone,
			String personalPhone, String addressLine1, String addressLine2, String addressCity, String addressState,
			String addressCountry, String profileImageUrl) {
		super();
		//this.id = id;
		this.name = name;
		this.company = company;
		this.email = email;
		this.birthDate = birthDate;
		this.workPhone = workPhone;
		this.personalPhone = personalPhone;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressCity = addressCity;
		this.addressState = addressState;
		this.addressCountry = addressCountry;
		this.profileImageUrl = profileImageUrl;
	}


	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getPersonalPhone() {
		return personalPhone;
	}
	public void setPersonalPhone(String personalPhone) {
		this.personalPhone = personalPhone;
	}
	
	public String getProfileImageUrl() {
		return profileImageUrl;
	}
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	public String getAddressCountry() {
		return addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}
	
	@Override
	public String toString()
	{
		return ("Contact is : "+this.id+" "+this.getName()+" "+this.personalPhone+" "+this.email);
	}
}
