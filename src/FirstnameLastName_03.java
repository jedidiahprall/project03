import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.text.DecimalFormat;
/* 
   JedidiahPrallNicholasRyan_03.java 
   
   @author Nicholas Ryan, Jedidiah Prall
   
   This Program takes bulk data from an input file and processes the data 
   according to a number of parameters. This program will check the data line
   by line and look for "ADD" or "DEL" to know whether to add or delete the 
   data from the output file.
   
   This program will print the data to both the console as well as to the 
   output file. It will also organize the data into a readable format that 
   will display Student information as well as Grade information and overall
   grade for the class. 
   
   Developed using both JGrasp and Eclipse IDE on Windows 10.
   
   Vocabulary Word: Pain 
      - "a localized or generalized unpleasant bodily sensation or complex 
         of sensations that causes mild to severe physical discomfort and 
         emotional distress and typically results from bodily disorder 
         (such as injury or disease); mental or emotional distress or 
         suffering."
         
   Quote: "The reward of suffering is experience." - Harry S. Truman 
          (May 8, 1884 - December 26, 1972) 
      
*/
public class FirstnameLastName_03 {
	
	private static List<Student> listOfStudents;		// List of Student objects
	private static List<GradeItem> listOfGradeItems;	// List of GradeItem objects
	 
	 
	
	/**
	 * 
	 */
	public static void processInput(String INPUT_FILE) {
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
	public static void generateReport(PrintWriter output) {
      
            
      
		ArrayList<Student> studentArray = new ArrayList<Student>();
		ArrayList<GradeItem> gradeItemArray = new ArrayList<GradeItem>();
		
		for (Object std : listOfStudents.toArray()) {
			if (std != null) {
				Student student = (Student) std;
				studentArray.add(student);
			}
		}
		
		for (Object gitm : listOfGradeItems.toArray()) {
			if (gitm != null) {
				GradeItem gradeitem = (GradeItem) gitm;
				gradeItemArray.add(gradeitem);
			}
		}
      
      
		
		double averageScore;
		int sumOfMaxScores; 
		int sumOfAverageScores;
      
      
      String topInfo = "\n\t\t\t\t\t\t\t Student Grade Report"+
                       "\nStudent ID\tFirst Name\tLast Name" +
                       "\tEmail Address";
      String infoUnderline = "__________\t__________\t"+
                             "_________\t_____________";
     // String ID
      String gradeHdr = "Grade Items";
      //String assignment = "\t" + studentArray.get(1).getStudentId()+ "\tProject 02\t\t70\t\t65";
      //TODO Adjust separator length
      String separator = "=============================================="+
                         "======================================";
      
      
            
      System.out.println (topInfo);
      System.out.println (infoUnderline);
      // Below Student Information serves only as place Holder to aid formatting
      System.out.println(ToolkitBasic.padString(studentArray.get(1).getStudentId(),12,""," ")+
                        ToolkitBasic.padString(studentArray.get(1).getStudentFirstName(),12,""," ")+
                        ToolkitBasic.padString(studentArray.get(1).getStudentLastName(),12,""," ")+
                        studentArray.get(1).getEmailAddress());
      // TODO Student info displayed here 
      System.out.println (gradeHdr);
      System.out.println (ToolkitBasic.rightPad(gradeItemArray.get(1).getGradeItemId(),8," ")+
                          ToolkitBasic.padString(gradeItemArray.get(1).getCourseId(),10,""," ")+
                          ToolkitBasic.padString(gradeItemArray.get(1).getItemType(),8,""," ")+
                          ToolkitBasic.padString(gradeItemArray.get(1).getDate(),10,""," ")+
                          ToolkitBasic.rightPad(gradeItemArray.get(1).getMaxScore(),10," ")+ 
                          gradeItemArray.get(1).getActualScore());
      // TODO Grade Item info Displayed here
      System.out.println (separator);
      
      output.println (topInfo);
      output.println (infoUnderline);
      // Below Student Information serves only as place Holder to aid formatting
      output.println(ToolkitBasic.padString(studentArray.get(1).getStudentId(),16,""," ")+
                     ToolkitBasic.padString(studentArray.get(1).getStudentFirstName(),16,""," ")+
                     ToolkitBasic.padString(studentArray.get(1).getStudentLastName(),16,""," ")+
                     studentArray.get(1).getEmailAddress());
      // TODO Student info displayed here 
      output.println (gradeHdr);
      output.println (ToolkitBasic.rightPad(gradeItemArray.get(1).getGradeItemId(),8," ")+
                      ToolkitBasic.padString(gradeItemArray.get(1).getCourseId(),10,""," ")+
                      ToolkitBasic.padString(gradeItemArray.get(1).getItemType(),8,""," ")+
                      ToolkitBasic.padString(gradeItemArray.get(1).getDate(),10,""," ")+
                      ToolkitBasic.rightPad(gradeItemArray.get(1).getMaxScore(),10," ")+ 
                      gradeItemArray.get(1).getActualScore());
      // TODO Grade Item info Displayed here
      output.println (separator);
      

      
      
       
      
		
		
		
		
	} // End generateReport
   	
	public static void main(String[] args) throws IOException {
		listOfStudents = new List<Student>();
		listOfGradeItems = new List<GradeItem>();
      String xx = FileNumber.getFileNumber(args, "from user");
      final String INPUT_FILE = "Project_03_Input"+xx+".txt";
      final String OUTPUT_FILE = "Project_03_Output"+xx+".txt";
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
		
      
		processInput(INPUT_FILE);

		generateReport(outputFile);
      
      outputFile.close();
	}
} // End class