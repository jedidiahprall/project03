/**
 * Student.java
 * 
 * @author Nicholas Ryan
 * @version 1
 */
public class Student {
	
	private String studentId;		 // Student ID
	private String studentFirstName; // First name
	private String studentLastName;  // Last name
	private String emailAddress;	 // Email address
	/**
	 * Default constructor.
	 * 
	 * @param studentId 	: Student ID number 
	 * @param firstName 	: Student first name
	 * @param lastName  	: Student last name
	 * @param emailAddress 	: Student email address
	 * @throws IllegalArgumentException : Throws if:
	 * 		- Any parameters are blank or null
	 * 		- Email address does not contain the '@' character
	 */
	public Student(String studentId, String firstName, 
				 String lastName, String emailAddress) 
						throws IllegalArgumentException {
		
		String errorMessage = ""; // Error message
		
		if (this.checkField(firstName)) {
			errorMessage += "Student\'s first name is blank, please enter a valid name.";
		} // End if
		
		if (this.checkField(lastName)) {
			errorMessage += "\nStudent\'s last name is blank, please enter a valid name.";
		} // End if
		
		if (this.checkField(studentId)) {
			errorMessage += "\nStudent ID is blank, "
			 		+ "please enter a complete Student ID";
		} // End if
		
		if (!emailAddress.contains("@") || this.checkField(emailAddress)) {
			errorMessage += "\nEmail does not contain an \'@\' character or is blank."
					+ " Please enter email again.";
		} // End if
		
		if (!errorMessage.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);

		} else {
			
			this.studentId = studentId;
			this.studentFirstName = firstName;
			this.studentLastName = lastName;
			this.emailAddress = emailAddress;
		} // End if
	} // End constructor
	// *************************************************************************************
	/**
	 * Accessor methods for the following fields:
	 * 		- studentId
	 * 		- studentFirstName
	 * 		- studentLastName
	 * 		- emailAddress
	 */
	public String getStudentId() {
		return this.studentId;
	} // End getStudentId
	// *************************************************************************************
	public String getStudentFirstName() {
		return this.studentFirstName;
	} // End getStudentFirstName
	// *************************************************************************************
	public String getStudentLastName() {
		return this.studentLastName;
	} // End getStudentLastName
	// *************************************************************************************
	public String getEmailAddress() {
		return this.emailAddress;
	} // End emailAddress
	// *************************************************************************************
	/**
	 * Compares two instances of the Student class comparing
	 * all variables.
	 * 
	 * @param std : Another instance of a student object
	 * @return contains : true, if all variables are equal, false if not
	 */
	 // *************************************************************************************
	public boolean equals(Student other) {
		boolean contains = false;

		if (this.studentId.equals(other.getStudentId()) &&
			this.studentLastName.equals(other.getStudentLastName()) &&
			this.studentFirstName.equals(other.getStudentFirstName()) &&
			this.emailAddress.equals(other.getEmailAddress())) {
			
			contains = true;
		} // End if
		
		return contains;
	} // End equals
	// *************************************************************************************
	/**
	 * Return all string variables, formatted in the Student object. 
	 * @return all string variables in Student object.
	 */
	public String toString() {
		String contents = "";
		
		contents = "Student ID: " + this.studentId
				+ "\nStudent Last Name: " + this.studentLastName
				+ "\nStudent First Name: " + this.studentFirstName
				+ "\nStudent Email Address: " + this.emailAddress;
		
		return contents;
	} // End toString
	// *************************************************************************************
	/**
	 * Helper method which determines if an input parameter is either blank or null
	 * @return true, if input parameter isn't blank or null, or 
	 * 		   false, if input parameter is either blank or null
	 * 	
	 */
	private boolean checkField(String field) {
		return (field == null || field.equals(""));
	} // End checkField
} // End class 