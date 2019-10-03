import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;

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
public class WorkingFile {
	
	private static List<Student> listOfStudents;		// List of Student objects
	private static List<GradeItem> listOfGradeItems;	// List of GradeItem objects
	private static String xx = "01";
   private static String INPUT_FILE = "Project_03_Input"+xx+".txt";  
	private static String OUTPUT_FILE = "Project_03_Output01"+xx+".txt";
   
	
   
	/*
       
	 */
	public static void processInput() {
		int lineNum = 0; 	  // Indicates which line the reader is on
		File file;			  // Declares a file
		Scanner fileReader;	  // Declares an input stream
		String[] workingLine; 
      /*
         Array which holds information, 
         split into an array at the ',' character.
      */
		
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
					} // End if
					
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
	 * TODO:
	 * Does the following
	 * - Calls the TODO toArray method in the list class to get a list of Student objects
	 * - Calls the TODO toArray method in the list class to get a list of GradeItem objects. 
	 * - Generates a report which is written to an output file, Project_03_Outputxx.txt
	 */
	public static void generateReport(PrintWriter output) {
		Object[] studentArray = listOfStudents.toArray();
		Object[] gradeItemArray = listOfGradeItems.toArray();
		
		double averageScore;
		int sumOfMaxScores; 
		int sumOfAverageScores;
      String header = "This is the header.";
      System.out.println (header);
      output.print (header);
      
      
      
		
		
	} // End generateReport
	
	public static void main(String[] args) {
		listOfStudents = new List<Student>();
		listOfGradeItems = new List<GradeItem>();
      String xx = FileNumber.getFileNumber(args, "from user");
      
      //private static String INPUT_FILE = "Project_03_Input"+xx+".txt";  
	   //private static String OUTPUT_FILE = "Project_03_Output01"+xx+".txt";
		
      FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
      PrintWriter outputFile = new PrintWriter(outputDataFile);
		
      processInput();
		System.out.println(listOfGradeItems.getCurrentSize());
		System.out.println(listOfStudents.getCurrentSize());
				
		generateReport(PrintWriter);
	}
} // End class
