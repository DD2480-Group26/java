package com.jsoniter.group26logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * includes function to preform branch coverage
 */
public class BranchCoverage {
    private static String fileName = "logFile.txt";
    private static boolean created = false;
    private static int[] branchCounters = new int[branchNum];
    private static int branchNum = 23;
    private static FileWriter logWriter;

    /**
     * create field values and log document for branch coverage
     */
    public static void createFile(String funcName) {
        if (!created) {
            created = true;
            try {
                logWriter = new FileWriter(fileName);
                logWriter.write("Test for " + funcName + ":\n");
                for (int branchId = 1; branchId <= branchNum; branchId++) {
                    logWriter.append("- Branch " + branchId + " tested times: 0\n");
                    branchCounters[branchId-1] = 0;
                }
                logWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * add one to the counter for corresponding branchID
     * @param branchId integer for branchId
     */
    public static void addBranch(int branchId) {
        branchCounters[branchId-1]++;
    }

    /**
     * update the logFile with the current branchCounter
     */
    public static void updateLogFile() {
        try {
            String[] content = FileMethods.fileToStrArray(fileName);
            for (int branchId = 1; branchId < branchCounters.length + 1; branchId++) {
                content[branchId] = "- Branch " + branchId + " tested times: " + branchCounters[branchId - 1];
            }
            FileMethods.overwriteFile(fileName, String.join("\n", content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
