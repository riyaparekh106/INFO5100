

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import static java.awt.SystemColor.text;

public class FileOperations {
    public List<String> readFile(String path)  {
        List<String> fileContents = new ArrayList<>();
        try {
            File myFile = new File(path);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                fileContents.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return fileContents;
    }

    public void WriteFile(String path, List<String> contents ) {
        List<String> fileContents = new ArrayList<>();
        try {
            File file = new File("example.txt");
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            output.write(String.valueOf(text));
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
 }

