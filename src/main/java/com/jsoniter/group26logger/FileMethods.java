package com.jsoniter.group26logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileMethods {
    public  static boolean fileContains(String fileName, String string) {
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
}