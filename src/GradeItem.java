/**
 * GradeItem.java 
 * 
 * @author Nicholas Ryan
 * @version 1
 */
public class GradeItem {
	
	private String studentId; // Student ID
	private String courseId;  // Course ID
	private String itemType;  // Item type
	private String date;	  // Date
	
	private int gradeItemId;  // Grade item ID
	private int maxScore;	  // Maximum score
	private int actualScore;  // Actual score
	/**
	 * Default constructor. 
	 * 
	 * @param studentId : Student ID
	 * @param courseId	: Course ID
	 * @param itemType 	: Item type, consists of one of the following: 
	 * 		- HW, Quiz, Class Work, Test and Final
	 * @param date		  : Date, in format yyyymmdd
	 * @param gradeItemId : Grade item ID
	 * @param maxScore	  : Maximum grade
	 * @param actualScore : Actual grade
	 * @throws IllegalArgumentException	: Throws if: 
	 * 		- Any parameters are blank or null
	 * 		- itemType is not one of the following types:
	 * 			- HW, Quiz, Class Work, Test or Final
	 * 		- Parameters gradeItemId, maxScore, and actualScore cannot
	 * 		  be parsed into an integer from a string
	 * 		- maxScore is less than 0
	 * 		- actualScore is greater than maxScore and actualScore is less than zero
	 */
	public GradeItem(String studentId, String courseId, String itemType, 
		   String date, String gradeItemId, String maxScore, String actualScore) 
		   throws IllegalArgumentException {
		
		// Possible item types. Must be one of the following. 
		String[] possibleTypes = {"HW", "Quiz", "Class Work", "Test", "Final"};
		boolean isValidCourseId = false;  //  Is valid course ID
		boolean canBeParsed = true;		  //  If the parameter can be parsed to an int
		
		int gradeItem = 0; // Grade item
		int max = 0;	   // Max score
		int actual = 0;    // Actual score
		
		String errorMessage = ""; // Error message
		
		if (this.checkField(studentId)) {
			errorMessage += "Student ID is blank. Please enter a valid student ID";
		} // End if
		
		if (this.checkField(courseId)) {
			errorMessage += "\nCourse ID is blank. Please eneter a valid course ID";
		} // End if
			
		if (this.checkField(itemType)) {
			errorMessage += "\nItem type is blank. Please enter a valid item type";
		} // End if
		
		if (this.checkField(date)) {
			errorMessage += "\nDate is blank. Please enter a valid date";
		} // End if
		
		if (this.checkField(gradeItemId)) {
			errorMessage += "\nGrade ID is blank. Please enter a valid grade ID";
			canBeParsed = false;
		} // End if
		
		if (this.checkField(maxScore)) {
			errorMessage += "\nMax score is blank. Please enter a valid max score";
			canBeParsed = false;
		} // End if
		
		if (this.checkField(actualScore)) {
			errorMessage += "\nActual score is blank. Please enter a valid actual score";
			canBeParsed = false;
		} // End if 
		
		for (String type : possibleTypes) {
			if (itemType.equals(type)){
				isValidCourseId = true;
			} // End if
		} // End for
		
		if (!isValidCourseId) {
			errorMessage += "Not a valid item type. Must contain one of the following: "
					+ "\nHW, Quiz, Class Work, Test or Final";
		} // End if
		
		if (canBeParsed) {
			try { 
				gradeItem = Integer.parseInt(gradeItemId);
				max = Integer.parseInt(maxScore);
				actual = Integer.parseInt(actualScore);
				
				if (max <= 0 || (max < actual && actual <= 0)) {
					errorMessage += "Max score or actual score is less than zero";
				} // End if
				
			} catch (Exception e) {
				errorMessage += "Max score, actual score, or grade item ID is less than zero,"
						+ "or an unrecognizable number. Please try again.";
			} // End try/catch
		} // End if
		
		if (!errorMessage.isEmpty()) {
			throw new IllegalArgumentException(errorMessage);
			
		} else { 
			this.studentId = studentId;
			this.courseId  = courseId;
			this.itemType = itemType;
			this.date = date;
			
			this.gradeItemId = gradeItem;
			this.maxScore = max;
			this.actualScore = actual;
		} // End if
	} // End constructor
	// *************************************************************************************
	/**
	 * Accessor methods for the following fields:
	 * 		- studentId
	 * 		- courseId
	 * 		- itemType
	 * 		- date
	 * 		- gradeItemId
	 * 		- maxScore
	 * 		- actualScore
	 */
	public String getStudentId() { 
		return this.studentId;
	} // End getStudentId
	// *************************************************************************************
	public String getCourseId() {
		return this.courseId;
	} // End getCourseId
	// *************************************************************************************
	public String getItemType() {
		return this.itemType;
	} // End getItemType
	// *************************************************************************************
	public String getDate() {
		return this.date;
	} // End getDate
	// *************************************************************************************
	public int getGradeItemId() {
		return this.gradeItemId;
	} // End getGradeItemId
	// *************************************************************************************
	public int getMaxScore() {
		return this.maxScore;
	} // End getMaxScore
	// *************************************************************************************
	public int getActualScore() {
		return this.actualScore;
	} // End getActualScore
	// *************************************************************************************
	/**
	 * Compares two instances of the GradeItem class comparing
	 * all variables.
	 * 
	 * @param gitem : Another instance of a GradeItem object
	 * @return contains : true, if all variables are equal, false if not
	 */
	public boolean equals(GradeItem gitem) {
		boolean contains = false;
		
		if (this.studentId.equals(gitem.getStudentId()) &&
			this.courseId.equals(gitem.getCourseId()) &&
			this.itemType.equals(gitem.getItemType()) &&
			this.date.equals(gitem.getDate()) &&
			this.maxScore == gitem.getMaxScore() &&
			this.actualScore == gitem.getActualScore()) {
			
			contains = true;
		} // End if
		
		return contains;
	} // End equals
	// *************************************************************************************
	/**
	 * Return all string variables, formatted in the GradeItem object. 
	 * @return all string variables in GradeItem object.
	 */
	public String toString() {
		String result = "";
		
		result = "Student ID: " 	+ this.studentId
				+ "\nCourse ID: " 	+ this.courseId
				+ "\nItem type: "	+ this.itemType
				+ "\ndate: " 		+ this.date
				+ "\nGrade item ID: " + this.gradeItemId
				+ "\nMaximum score: " + this.maxScore
				+ "\nActual score: "  + this.actualScore;
		
		return result;
	} // End toString
	/**
	 * Helper method which determines if an input parameter is either blank or null
	 * @return true, if input parameter isn't blank or null, or 
	 * 		   false, if input parameter is either blank or null
	 */
	private boolean checkField(String field) {
		return (field == null || field.equals(""));
	} // End checkField
} // End class