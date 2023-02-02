package ca.georgiancollege.comp1011winter2023thursdayafternoon.filemanipulation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class SDL {

    /*
            Student Directory Listing
            Add Student
            Modify Student
            Delete Student
            View Student
            View Students
            Exit

     */

    public static void main(String[] args) {

        new SDL();

    }
    private Path path;
    private ArrayList<String> list = new ArrayList<String>();
    private Scanner input = new Scanner(System.in);
    private final String DIR_SEP = File.separator;
    private final String extension = ".txt";
    private BufferedReader reader =
            new BufferedReader(new InputStreamReader(System.in));
    private StringBuilder sb = new StringBuilder();

    public SDL(){
        prepProgram();
        System.out.println("Welcome to Student Directory Listing");
        while(true){
            System.out.println("Menu is Below, Choose 1 of the available options");
            System.out.printf("1)Add Student%n2)Modify Student%n3)Delete Student%n" +
                    "4)View Student%n5)View Students%n6)Exit%nYour option is: ");


            try{
                int option = input.nextInt();

                if(option == 6)
                    break;
                if(option < 1 || option > 6)
                    throw new IllegalArgumentException("Select an option between 1-6");

                switch (option){

                    case 1:
                        addStudent();
                        break;
                    case 2:
                        modifyStudent();
                        break;
                    case 3:
                        deleteStudent();
                        break;
                    case 4:
                        viewStudent();
                        break;
                    case 5:
                        viewStudents();
                        break;
                    case 6:
                        break;
                }
            }
            catch (IOException e){
                System.err.println("IO Error occurred: " + e.getMessage());
                break;
            }
            catch (Exception e){
                System.out.println("General Error occurred: " + e.getMessage());
                break;
            }
        }

    }
    private void viewStudent() throws IOException{

        System.out.println("You will view a single a student");
        System.out.println("Enter student #");
        clearStringBuilder();
        sb.append(reader.readLine());
        if(!checkIfStudentFileExists(sb.toString())){
            throw new IOException("Student not found");
        }
        System.out.println(Files.readString(path.resolve(sb.toString() + extension) ));

    }
    private void viewStudents() throws IOException{
        System.out.println("Here are the list of students");

        //get a list of all students.
        //already done. How? Instance variable of

        //iterate through list above and output SID, FN, LN
        loadList();
        for(String currentFile : list){

            //System.out.println(currentFile);
            System.out.println("*".repeat(10));
            System.out.println("Student ID = "  + currentFile.split(extension)[0]);
            System.out.println(Files.readString(path.resolve(currentFile)));
            System.out.println("*".repeat(10));
        }

    }//ctl+H => replaced fileName with studentID
    private void addStudent(String studentID, String firstName, String lastName) throws IOException{
        clearStringBuilder();
        sb.append(firstName + "\n" + lastName);
        Files.writeString(path.resolve(studentID + extension), sb.toString());

    }
    private String extensionChecker(String studentID){
        return null;
    }
    private void clearStringBuilder(){
        sb.setLength(0); //clear the contents of stringbuilder
    }
    private boolean validStudentID(String studentID){

        //attempt to convert the studentID into an integer
        //determine if the length of studentID is exactly 9 characters
        try{
            int num = Integer.parseInt(studentID);
            return studentID.length() == 9 && num >=100000000;
        }
        catch (Exception e){
            return false;
        }
    }
    //check to valid firstname and lastname
    private void addStudent() throws IOException{
        String sid, fn, ln;
        System.out.println("Enter StudentID");
        clearStringBuilder();
        sb.append(reader.readLine());

        if(!validStudentID(sb.toString())){
            throw new IllegalArgumentException("Student ID is invalid");
        }
        else if(checkIfStudentFileExists(sb.toString())){
            throw new IllegalArgumentException("Student ID of " + sb.toString() + " already exists");
        }
        sid = sb.toString();

        System.out.println("Enter first name");
        clearStringBuilder();
        sb.append(reader.readLine());
        fn = sb.toString();

        System.out.println("Enter last name");
        clearStringBuilder();
        sb.append(reader.readLine());
        ln = sb.toString();

        //check to valid firstname and lastname
        addStudent(sid, fn, ln);
    }
    private boolean checkIfStudentFileExists(String studentID){

        //return True is student file exists
        //        return false;
        //.Path somePath = path.resolve(studentID + extension);
        //return Files.exists(somePath);
        return Files.exists(path.resolve(studentID + extension));
    }
    private void modifyStudent() throws IOException{

        System.out.println("You will modify a student");
        System.out.println("Enter student #");

        clearStringBuilder();
        sb.append(reader.readLine());
        //sb stores studentID

        if(!checkIfStudentFileExists(sb.toString())){
            throw new IOException("Student ID invalid or student does not exists");
        }
        //at this point, everything is ok

        String sid = sb.toString();

        System.out.println("Enter new first name");
        clearStringBuilder();
        sb.append(reader.readLine());

        String fn = sb.toString();

        System.out.println("Enter new last name");
        clearStringBuilder();
        sb.append(reader.readLine());

        addStudent(sid, fn, sb.toString());


    }
    private void deleteStudent() throws IOException{
        System.out.println("You will delete a student");
        System.out.println("Enter student #");
        clearStringBuilder();
        sb.append(reader.readLine());
        if(!checkIfStudentFileExists(sb.toString())){
            throw new IOException("Student ID not found");
        }

        Files.delete(path.resolve(sb.toString() + extension));

    }
    private void loadList(){
        list.clear();
        //get all files from directory above
        for(String currentFile : path.toFile().list()){
            list.add(currentFile);
        }

    }
    private void prepProgram(){

        try {
            //Ensure Directory Exists
            path = Paths.get("src/main/java/ca/georgiancollege/comp1011winter2023thursdayafternoon/filemanipulation/SDL");

            if (!path.toFile().exists())
                Files.createDirectory(path);

            loadList();
        }
        catch (Exception e){
            System.err.println(e);
        }

    }



}

