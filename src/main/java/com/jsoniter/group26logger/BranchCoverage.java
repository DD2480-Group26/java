package com.jsoniter.group26logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * includes functions used for branch coverage on different functions.
 * All branch coverage reports for different functions will be saved in
 * the folder "logFiles" with name {functionName}Log.txt, e.g. fooLog.txt.
 */
public class BranchCoverage {
    private static ArrayList<String> functionsName = new ArrayList<String>();
    /*
     * Each element in branchCounters is a branchCounter for the function with
     * corresponding functionIndex. BranchCounter counts how many times each branch runs
     * where the index is the branchId.
     */
    private static ArrayList<Integer[]> branchCounters = new ArrayList<Integer[]>();
    private static ArrayList<String> logFilesPath = new ArrayList<String>();
    private static FileWriter logWriter;

    /**
     * create field values and the given function's branch coverage report
     * 
     * @param funcName    given function name
     * @param fileName    name of the file the given function is in
     * @param numBranches number of branches the function has
     */
    public static Integer createFile(String funcName, int numBranches) {
        if (!functionsName.contains(funcName)) {
            try {
                // create log file and save in fields
                String logFilePath = "logFiles\\" + funcName + "Log.txt";
                logFilesPath.add(logFilePath);
                new File("logFiles").mkdir(); // create the folder
                logWriter = new FileWriter(logFilePath);
                logWriter.write("Test for function " + funcName + ":\n");
                functionsName.add(funcName);

                // create branchCounter for given function
                Integer[] branchCounter = new Integer[numBranches];
                for (int branchId = 1; branchId <= numBranches; branchId++) {
                    logWriter.append("- Branch " + branchId + " tested times: 0\n");
                    branchCounter[branchId - 1] = 0;
                }
                branchCounters.add(branchCounter);

                logWriter.close();
                return functionsName.indexOf(funcName);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return functionsName.indexOf(funcName);
    }

    /**
     * Add one to the counter in branchCounter for corresponding functionIndex and
     * branchId. Update the logFile for given function.
     * 
     * @param branchId      integer for branchId
     * @param functionIndex index for given function
     */
    public static void addBranch(int branchId, int functionIndex) {
        try {
            branchCounters.get(functionIndex)[branchId - 1]++;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(String.format("branchId (%s) or functionIndex (%s) it out if bound for function %s",
                    branchId, functionIndex, functionsName.get(functionIndex)));
            e.printStackTrace();
        }
        updateLogFile(functionIndex);
    }

    /**
     * Update the logFile for given function with that functions current branchCounter
     * 
     * @param functionIndex index for given function
     */
    private static void updateLogFile(int functionIndex) {
        String logFile = logFilesPath.get(functionIndex);
        try {
            String[] content = createContent(functionIndex);
            FileMethods.overwriteFile(logFile, String.join("\n", content));
        } catch (Exception e) {
            System.out.println("other exception in updateLogFile");
            e.printStackTrace();
        }
    }

    /**
     * Create the content based on the branchCounter for the given function
     * 
     * @param functionIndex index of the given funciton
     * @return content is String array
     */
    private static String[] createContent(int functionIndex) {
        Integer[] branchCounter = branchCounters.get(functionIndex);
        String[] content = new String[branchCounter.length + 1];
        content[0] = "Test for function " + functionsName.get(functionIndex) + ":";
        for (int branchId = 1; branchId < branchCounter.length + 1; branchId++) {
            content[branchId] = "- Branch " + branchId + " tested times: " + branchCounter[branchId - 1];
        }
        return content;
    }

    /**
     * Get the functionIndex of the given functionName
     * 
     * @param functionName the given function name
     * @return functionIndex
     */
    public static Integer getFunctionIndex(String functionName) {
        if (functionsName.contains(functionName)) {
            return functionsName.indexOf(functionName);
        } else {
            System.out.println("the given function is not registred, use createFile first");
            return null;
        }
    }
}
