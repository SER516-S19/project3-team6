package service;
import listener.ChangeStateListener;
import org.json.simple.JSONObject;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


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
        File quizFileDir = new File("src/../../Quizzes");
        dirPath = quizFileDir.getAbsolutePath();
        if (!quizFileDir.exists()) {
            System.out.println("creating directory: " + quizFileDir.getName());
            boolean result = false;

            try{
                quizFileDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle Security exception
                se.printStackTrace();
            }
            if(result) {
                System.out.println("DIR created");
                    writeFile(obj,fileName,dirPath);
            }
        }else
            writeFile(obj,fileName,dirPath);

    }

    private void writeFile(JSONObject obj, String fileName,String dirPath) {
        try (FileWriter file = new FileWriter("src/../../Quizzes/"+fileName+".json")) {
            filePath = "src/../../Quizzes/"+fileName+".json";
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
