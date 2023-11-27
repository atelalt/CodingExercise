package org.fileOps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileOperationsTest {

    @TempDir
    Path directory;

    @Test
    void testStringReverse(){
        assertEquals("aleT" , new FileOperations().reverse("Tela"));
    }

    @Test
    void readAndWriteTheFile() throws IOException{

        Path fileToRead = directory.resolve("InputFile.txt");

        List<String> lines = Arrays.asList("Anuj\n" , "Tela\n" , "Pune\n");
        Files.write(fileToRead, lines);

        Path fileToWrite = directory.resolve("OutputFile.txt");

        assertEquals(true , new FileOperations().readAndWriteTheFile(fileToRead, fileToWrite));
    }

    @Test
    void failToReadAndWriteTheFile() throws IOException{

        assertEquals(false , new FileOperations().readAndWriteTheFile(null, null));

        Path fileToRead = directory.resolve("InputFile.txt");

        assertEquals(false , new FileOperations().readAndWriteTheFile(fileToRead, null));
    }
}