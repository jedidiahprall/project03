import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author 
 *
 */
public class FirstnameLastName_03 {
	
	private static List listOfStudents;
	private static List listOfGradeItems;
	private static final String INPUT_FILE = null;
	private static final String OUTPUT_FILE = null;
	
	/**
	 * TODO:
	 * - Open the input file. 
	 * 	- Display an error message using the err (System.err.print*) stream if the file is not found
	 * 	- Include the NAME of the missing file in the message (be user friendly)
	 * - Read all lines of text (if it can be open)
	 * 	- Use the split function to parse the line
	 * 	- If the first field is STUDENT, call processStudentData method
	 * 	 - Pass it the current line array
	 * 	- Else, if the first field is GRADE ITEM, call the processGradeItemData method
	 * 	 - Do the same as above	 	
	 */
	public static void processInput() {
		int lineNum = 0; 	  // Indicates which line the reader is on
		File file;			  // Declares a file
		Scanner fileReader;	  // Declares an input stream
		String[] workingLine; // Array which holds information, split into an array at the ',' character.
		
		try {
			
			file = new File(INPUT_FILE);
			fileReader = new Scanner(file);
			
			while (fileReader.hasNext()) {
				workingLine = fileReader.nextLine().split(",");
				
				if (workingLine[0].equals("STUDENT")) {
					processStudentData(workingLine);
					
				} else if (workingLine[0].equals("GRADE ITEM")) {
					processGradeItemData(workingLine);
					
				} else {
					System.err.println("\'STUDENT\' or \'GRADE ITEM\' token not found."
								+ " Skipping line " + lineNum + ".");
				} // End if / else 
				lineNum++;
			} // End while
			
		} catch (Exception e) {
			System.err.println("File \'" + INPUT_FILE + "\' not found.");
		} // End try / catch
	} // End processInput
	/**
	 * TODO:
	 * Does the following:
	 * - Recieves an array of type string with student data 
	 * 	- if the second field is ADD, do the following: (implemented the same as the second project)
	 * 	- Create an instance of Student
	 * 	- Use the TODO contains method in the List class to make sure Student is unique. 
	 * 	 - If it's already in the list, display an error message that includes the student ID
	 * 	- Call the TODO add method in the List class to add the Student object to the list of students. 
	 * 	 - If the add method's return value indicates an error, display a message with the Student ID
	 * 	- If the second field is DEL:
	 * 	 - Create a student object. 
	 * 	 - Call the TODO remove value from the call to the remove method. If the entry is not found, print a
	 * 	   error message using System.err.print*
	 * - If ADD or DEL are not found, write an error message that states it, showing the second field where 
	 *   the token should be. 
	 */
	public static void processStudentData(String[] info) {
		
	}
	/**
	 * TODO:
	 * Does the following:
	 * - Recieves an array of type string with grade item data 
	 * 	- if the second field is ADD, do the following: (implemented the same as the second project)
	 * 	- Create an instance of GradeItem
	 * 	- Use the TODO contains method in the List class to make sure GradeItem is unique. 
	 * 	 - If it's already in the list, display an error message that includes the GradeItem ID and student ID
	 * 	- Call the TODO add method in the List class to add the GradeItem object to the list of GradeItems. 
	 * 	 - If the add method's return value indicates an error, display a message with the GradeItem ID and student ID
	 * 	- If the second field is DEL:
	 * 	 - Create a GradeItem object. 
	 * 	 - Call the TODO remove value from the call to the remove method. If the entry is not found, print a
	 * 	   error message using System.err.print*
	 * - If ADD or DEL are not found, write an error message that states it, showing the second field where 
	 *   the token should be. 
	 */
	public static void processGradeItemData(String[] info) {
		
	}
	/**
	 * TODO:
	 * Does the following
	 * - Calls the TODO toArray method in the list class to get a list of Student objects
	 * - Calls the TODO toArray method in the list class to get a list of GradeItem objects. 
	 * - Generates a report which is writeen to an output file, Project_03_Outputxx.txt
	 */
	public static void generateReport() {
		
	}
	
	/**
	 * TODO:
	 * 	- Instantiate both listOfStudents and listOfGradeItems
	 * 	- Call the processInput method
	 * 	- Call the generateReport method
	 * @param args
	 */
	public static void main(String[] args) {
		listOfStudents = new List('S');
		listOfGradeItems = new List('G');
		
		processInput();

		generateReport();
	}
} // End class
