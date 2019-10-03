import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * @author 
 *
 */
public class FirstnameLastName_03 {
	
	private static List<Student> listOfStudents;		// List of Student objects
	private static List<GradeItem> listOfGradeItems;	// List of GradeItem objects
	private static String INPUT_FILE = "Input.txt";  	// Input file
	private static final String OUTPUT_FILE = null; 
	
	/**
	 * 
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
	 * 
	 * @param info
	 */
	public static void processStudentData(String[] info) {
		Student newStudent;
		
		if (info[1].equals("ADD")) {
			try {
				newStudent = new Student(info[2], info[3], info[4], info[5]);
				
				if (!listOfStudents.contains(newStudent)) {
					
					if(!listOfStudents.add(newStudent)) {
						
						System.err.println("Student \'" + newStudent.getStudentId()
								+ "\' could not be added to the list. Skipping this entry.");
					} else {
						System.out.println("Student \'" + newStudent.getStudentId()
						+ "\' was added to the list.");
					} // End if / else
					
				} else {
					System.err.println("Student \'" + newStudent.getStudentId()
							+ "\' already exists in the list. Skipping this entry");
					
				} // End if / else
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}  // End try / catch 
			
		} else if (info[1].equals("DEL")) {
			try { 
				newStudent = new Student(info[2], info[3], info[4], info[5]);
				
				if (!listOfStudents.remove(newStudent)) {
					
					System.err.println("Student \'" + newStudent.getStudentId()
							+ "\' could not be removed from the list. Skipping this entry.");
				} else {
					System.out.println("Student \'" + newStudent.getStudentId()
					+ "\' was removed from the list.");
				} // End if
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} // End try / catch
			
		} else {
			System.err.println("\'ADD\' or \'DEL\' tokens not found in line. \'" + info[1]
					+ "\' must be one of these two tokens to be processed");
		} // End if / else
	} // End processStudentData
	/**
	 * 
	 * @param info
	 */
	public static void processGradeItemData(String[] info) {
		GradeItem newGradeItem;
		
		if (info[1].equals("ADD")) {
			try {
				newGradeItem = new GradeItem(info[3], info[4], info[5], 
									info[6], info[2], info[7], info[8]);
				
				if (!listOfGradeItems.contains(newGradeItem)) {
					
					if (!listOfGradeItems.add(newGradeItem)) {
						
						System.err.println("Grade item \'" + newGradeItem.getGradeItemId()
								+ "\' with Student ID \'" + newGradeItem.getStudentId() 
								+ "\' could not be added to the list. Skipping this entry.");
						
					} else {
						System.out.println("Grade item \'" + newGradeItem.getGradeItemId()
						+ "\' with Student ID \'" + newGradeItem.getStudentId() 
						+ "\' was added to the list.");
					} // End if
					
				} else {
					System.err.println("Grade item \'" + newGradeItem.getGradeItemId()
						+ "\' with Student ID \'" + newGradeItem.getStudentId()
						+ "\' already exists in this list. Skipping this entry.");
				} // End if / else
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} // End try / catch 
			
		} else if (info[1].equals("DEL")) {
			try {
				newGradeItem = new GradeItem(info[3], info[4], info[5], 
									info[6], info[2], info[7], info[8]);
				
				 if (!listOfGradeItems.remove(newGradeItem)) {
					 System.err.println("Grade item \'" + newGradeItem.getGradeItemId()
						+ "\' with Student ID \'" + newGradeItem.getStudentId()
						+ "\' cannot be deleted.");
						
				 } else {
					 System.out.println("Grade item \'" + newGradeItem.getGradeItemId()
						+ "\' with Student ID \'" + newGradeItem.getStudentId()
						+ "\' was deleted.");
				 } // End if
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			} // End try / catch 
			
		} else {
			System.err.println("\'ADD\' or \'DEL\' tokens not found in line. \'" + info[1]
					+ "\' must be one of these two tokens to be processed");
		} // End if / else
	}
	/**
	 * Helper method for the generateReport method which searches a gradeItem ArrayList to look for 
	 * all objects with a similar student ID. Once those values are found, it appends them to another 
	 * array which is then returned when no more 
	 * 
	 * @param id, Student ID used to search the grade Item array for a matching value.
	 * @return ArrayList<GradeItem> : list of grade item objects which match the student ID
	 */
	public static ArrayList<GradeItem> getMatchingStudentId(String id, ArrayList<GradeItem> gradeItem) {
		ArrayList<GradeItem> results = new ArrayList<GradeItem>();
		
		for (GradeItem item : gradeItem) {
			if (item.getStudentId().equals(id)) {
				results.add(item);
			}
		}
		
		return results;
	}
	/**
	 * TODO:
	 * Does the following
	 * - Calls the TODO toArray method in the list class to get a list of Student objects
	 * - Calls the TODO toArray method in the list class to get a list of GradeItem objects. 
	 * - Generates a report which is written to an output file, Project_03_Outputxx.txt
	 */
	public static void generateReport() {
		ArrayList<Student> studentArray = new ArrayList<Student>();
		ArrayList<GradeItem> gradeItemArray = new ArrayList<GradeItem>();
		
		for (Object obj : listOfStudents.toArray()) {
			if (obj != null) {
				Student student = (Student) obj;
				studentArray.add(student);
			}
		}
		
		for (Object obj : listOfGradeItems.toArray()) {
			if (obj != null) {
				GradeItem gradeItem = (GradeItem) obj;
				gradeItemArray.add(gradeItem);
			}
		}
		
		double averageScore;
		int sumOfMaxScores; 
		int sumOfAverageScores;
		
		
		
	} // End generateReport
	
	public static void main(String[] args) {
		listOfStudents = new List<Student>();
		listOfGradeItems = new List<GradeItem>();
		
		processInput();

		generateReport();
	}
} // End class
