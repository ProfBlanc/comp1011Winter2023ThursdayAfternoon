package ca.georgiancollege.comp1011winter2023thursdayafternoon.filemanipulation;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Basics {

    static void review(){

        /*
            File Manipulation
                create data that will persist

            Packages
                java.io
                java.nio

            Classes
                Path
                    an object (create an instance)
                    location of ________ (file or folder)
                Paths
                    static methods to execute certain functions related to file/folder locations

                File
                    an object (create an instance)
                    Given a specific file or folder, execute certain functions
                Files
                    static methods to execute certain functions related to ONE specific file or folder
                    always takes a Path object as argument

            Steps to working with FM
            1) Specific a Path location
                using Path or Paths
                save with Path location to a path object

         */
            Path p1 = Path.of("src");
            Path p2 = Paths.get("src/main");

            /*
             2) Either create or open the specified Path
                Files object to createDirectory or createFile
                OR
                Files object to read, write or delete Path location

            3) In case you want to get more details about the SPECIFIC file or folder in Step1)
                Create a File object, using the multiple methods available to you.
             */


    }

    public static void main(String[] args) {

        try{
            example2();
        }
        catch (Exception e){
            System.err.println(e);
        }

    }
    static Path rootPath = Paths.get("src/main/java/ca/georgiancollege/comp1011winter2023thursdayafternoon/filemanipulation");

    static void example1() throws Exception{
        //TOGETHER
        //lets create a new directory in the filemanipulation package
        System.out.println(rootPath.toFile().exists());
        //name this directory 'newDir'
        Path p1 = rootPath.resolve("newDir");
        if(!p1.toFile().exists())
            Files.createDirectory(p1);

        //YOU:
        //ask the user for a filename
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a filename");
        String file = input.nextLine();
        //create an empty file with this filename
        Files.createFile(rootPath.resolve(file));

    }
    static void example2() throws Exception{
        /*
                1) create a new file named test.txt by appending test.txt to the end of rootPath
                2) Create the new file using static method of a class
                3) transform new path to an instance of an object (File) (not needed but for practice)
                4) use Files class to write string content to the new path
                5) Files class to then read the file content of new path
                6) search either File or Files to delete the text.txt content
         */
        Path textFile = rootPath.resolve("test.txt");
        Files.createFile(textFile);
        File fileObject = textFile.toFile();
        Files.writeString(textFile, "Hello World", StandardOpenOption.APPEND);
        StringBuilder sb = new StringBuilder(Files.readString(textFile));
        System.out.println(sb.toString());
        Files.delete(textFile);
    }

}
