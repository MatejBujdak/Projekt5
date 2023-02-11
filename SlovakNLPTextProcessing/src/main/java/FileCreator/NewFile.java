package FileCreator;

import sk.textprocessor.arguments.ArgumentParser;

import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class NewFile {

    public static boolean fileCreated;
    public static String fullPath;

//  function that creates a new file
    public void NewFileCreate(String fileName){
    String path = System.getProperty("user.home") + "/Desktop";
    String filename = fileName + ".txt";
    fullPath = Paths.get(path, filename).toString();

    try{
        Files.createFile(Paths.get(fullPath));
    }catch(IOException e){
        System.out.println(e.getMessage());
    }
}

//   function that overwrites the selected file
   public void rewriteFile(String rewrite){

        if(fileCreated){
            try {
                FileWriter fw = new FileWriter(fullPath);
                fw.write(rewrite);
                fw.close();
                System.out.println("Nahranie súboru úspešné!");
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
            }
            }else{
            try {
                FileWriter fw = new FileWriter(ArgumentParser.getInputFile());
                fw.write(rewrite);
                fw.close();
                System.out.println("Súbor bol úspešne preuložený!");
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
        }





}




