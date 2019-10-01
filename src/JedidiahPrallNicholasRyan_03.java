/** 
  *
  *Vocabulary Word:
  *Suffuse:
  *"to spread over or through in the manner of fluid or light : flush, fill" 
  *
  *
*/ 

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class JedidiahPrallNicholasRyan_03 {

   Student [] newStudent = new Student[6]; // six items in each student object
   GradeItem [] newGradeItem = new GradeItem[9]; // nine items in each grade item object
   
   static Toolkit tools = new Toolkit();
   public static void main(Strings[] args) throws IOException {
   
   String xx = "";
   Scanner scan = new Scanner(System.in);
   System.out.print("Enter file number: ");
   xx = scan.next();
   final String INPUT_FILENAME = "Project_02_Input" + xx + ".txt";
   File file = new File(INPUT_FILENAME);
   final String OUTPUT_FILENAME = "Project_02_Output01.txt";
   
   FileWriter outputDataFile = new FileWriter(OUTPUT_FILE);
   PrintWriter outputFile = new PrintWriter(outputDataFile);
   
   
    
   
   
} // End Main

//*****************************************************************************

/* Methods will follow below. Methods will call for filling lists and 
organizing data, and finally printing the data to an output file.
*/

//*****************************************************************************

public static void processInput () throws IllegalArgumentException {
   
   File inputDataFile = null;
   Scanner inputFile = null; 
   String line = "";
   
   try {
      inputDataFile = new File (INPUT_FILE);
      inputFile = new Scanner(inputDataFile);
   }
   catch (FileNotFoundException e) {
      System.out.println("File not found.");
      System.exit (0);
   }
   
   while (inputFile.hasNextLine()) {
      for (int i = 0; i >= 15; i++) {
         
      
   
   Student[] newStudent = line.split (",", 10);
      
   inputFile.close();
      
      
   
   

      

}// End processInput

//*****************************************************************************

public static void processStudentData (String[] info) throws IllegalArgumentException {

   

}// End processStudentData 

//*****************************************************************************

public static void processGradeItemData (String[] info) throws 
                                         IllegalArgumentException {

}// End processGradeItemData

//*****************************************************************************

public static void generateReport () {


}// End generateReport


} // End JedidiahPrallNicholasRyan_03
   