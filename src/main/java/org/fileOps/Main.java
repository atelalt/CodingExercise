package org.fileOps;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {


        Path pathToRead = Paths.get("C:\\Users\\Anuj\\InputFile.txt");
        Path pathToWrite = Paths.get("C:\\Users\\Anuj\\OutputFile.txt");

        FileOperations fileOperations = new FileOperations();
        if(fileOperations.readAndWriteTheFile(pathToRead, pathToWrite)){
            System.out.println("The file read , reverse and write operation is successful!");
        }
        else {
            System.out.println("The file read , reverse and write operation is not successful!");

        }
    }
}