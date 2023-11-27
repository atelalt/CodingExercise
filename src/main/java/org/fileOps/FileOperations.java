package org.fileOps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOperations {

    public String reverse(String string){

        return Stream.of(string)
                .map(word-> new StringBuilder(word).reverse())
                .collect(Collectors.joining(" "));
    }

    public boolean readAndWriteTheFile(Path pathToRead , Path pathToWrite){

        if(null == pathToRead || !Files.exists(pathToRead)){
            System.out.println("File to read doesn't exist");
            return false;
        }

        if(null == pathToWrite){
            System.out.println("File to write doesn't exist");
            return false;
        }
        List<String> list = new ArrayList<>();
        try(Stream<String> stream = Files.lines(pathToRead)){
            list = stream
                    .map(string -> reverse(string))
                    .collect(Collectors.toList());

            Files.write(pathToWrite, list);
        } catch (IOException e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
