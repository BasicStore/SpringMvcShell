package com.post.dm;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Person extends AbstractData { 
	
//	@NotNull
//	@Size(max=20)
    private String firstName;
    
    //@NotNull
    //@Size(max=20)
    private String lastName;
    	
	private String addresss;	
	
	private MaritalStatus maritalStatus;	
	
	private String occupation;    
	
	private LocalDate dateOfBirth;
	
	private String email;
	private String mobileTel;
	private String homeTel;
	private String workTel;
	private String placeOfBirth;
	private String countryOfBirth;
	
	
	public Person() {
		
	}

	public Person(String firstName, String lastName, String addresss) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresss = addresss;
	}
	
	
	public Person(String firstName, String lastName, String addresss, MaritalStatus maritalStatus, String occupation,
			LocalDate dateOfBirth, String email, String mobileTel, String homeTel, String workTel, String placeOfBirth,
			String countryOfBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.addresss = addresss;
		this.maritalStatus = maritalStatus;
		this.occupation = occupation;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.mobileTel = mobileTel;
		this.homeTel = homeTel;
		this.workTel = workTel;
		this.placeOfBirth = placeOfBirth;
		this.countryOfBirth = countryOfBirth;
	}



	public Person(long id, String firstName, String lastName, String addresss, MaritalStatus maritalStatus, String occupation,
			LocalDate dateOfBirth, String email, String mobileTel, String homeTel, String workTel, String placeOfBirth,
			String countryOfBirth) {
		this(firstName, lastName, addresss, maritalStatus, occupation,
				dateOfBirth, email, mobileTel, homeTel, workTel, placeOfBirth, countryOfBirth);
		this.id = id;
	}

	
	public String getAddress() {
		return addresss;
	}

	public void setAddress(String addresss) {
		this.addresss = addresss;
	}


	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}


	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}


	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

}
