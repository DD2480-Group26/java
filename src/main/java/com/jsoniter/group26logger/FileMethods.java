package com.jsoniter.group26logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * contains functions used for file
 */
public class FileMethods {

    
    /**
     * check if the given file contains the string
     * @param fileName name of the given file
     * @param string the given string
     * @return true if the file contains the string
     */
    public static boolean fileContains(String fileName, String string) {
    	File file = new File(fileName);

    	try {
    	    Scanner scanner = new Scanner(file);
    	    while (scanner.hasNextLine()) {
    	        String line = scanner.nextLine();
    	        if(line.equals(string)) {
    	        	scanner.close();
    	        	return true;
    	        }
    	    }
    	    scanner.close();
    	    return false;
    	} catch(FileNotFoundException e) { 
    	    return false;
    	}
    }

    /**
     * make the content in a file to a ArrayList separeted by "\n"
     * 
     * @param fileName  file name
     * @return String Array of file content
     * @throws IOException
     */
    public static String[] fileToStrArray(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        String content = Files.readString(filePath, StandardCharsets.US_ASCII);
        String[] contentArray = content.split("\n");
        return contentArray;
    }

    /**
     * overwrite the content of a given file with given content
     * @param fileName given file name
     * @param content the given content in String
     */
    static void overwriteFile(String fileName, String content) {
        try {
            File file = new File(fileName);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}