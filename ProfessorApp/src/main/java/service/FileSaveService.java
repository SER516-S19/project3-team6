package service;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONObject;

import constant.Constants;
import listener.ChangeStateListener;


/**
 * The Main File Save service for the application.
 * @author Abhinab Mohanty GIT ID: 53
 *
 */

public class FileSaveService {
    private String filePath;
    private String dirPath;
    public FileSaveService(JSONObject obj, String fileName) {
        // Get Filepath for Quizzes Directory
        File quizFileDir = new File(Constants.QUIZ_DIR);
        dirPath = quizFileDir.getAbsolutePath();
        writeFile(obj,fileName,dirPath);

    }

    private void writeFile(JSONObject obj, String fileName,String dirPath) {
        try (FileWriter file = new FileWriter(Constants.QUIZ_DIR+fileName+".json")) {
            filePath = Constants.QUIZ_DIR+fileName+".json";
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);

        } catch (IOException  e) {
            e.printStackTrace();
        }

        checkFileSuccess(obj,filePath,dirPath);
    }

    private void checkFileSuccess(JSONObject obj, String filePath, String dirPath){
        File checkFile = new File(filePath);
        if(checkFile.exists())
            new ChangeStateListener().actionPerformed(new ActionEvent(obj,400,"File "+checkFile.getName()+" Successfully Created at: "+dirPath));
        else
            new ChangeStateListener().actionPerformed(new ActionEvent(obj,202,"File Not Found!! Error Occurred"));
    }
}
