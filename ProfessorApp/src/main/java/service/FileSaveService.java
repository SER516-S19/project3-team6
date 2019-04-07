package service;
import listener.ChangeStateListener;
import org.json.simple.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static constant.Constants.backEnd;

public class FileSaveService {
    String filePath;
    public FileSaveService(JSONObject obj, String fileName) {
        // try-with-resources statement based on post comment below :)
        File quizFileDir = new File("src/../../Quizzes");
        if (!quizFileDir.exists()) {
            System.out.println("creating directory: " + quizFileDir.getName());
            boolean result = false;

            try{
                quizFileDir.mkdir();
                result = true;
            }
            catch(SecurityException se){
                //handle it
                se.printStackTrace();
            }
            if(result) {
                System.out.println("DIR created");
                    writeFile(obj,fileName);
            }
        }else
            writeFile(obj,fileName);

    }

    private void writeFile(JSONObject obj, String fileName) {
        try (FileWriter file = new FileWriter("src/../../Quizzes/"+fileName+".json")) {
            filePath = "src/../../Quizzes/"+fileName+".json";
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
            checkFileSuccess(obj,filePath);
//            backEnd.join();


        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    private void checkFileSuccess(JSONObject obj,String filePath){
        File checkFile = new File(filePath);
        if(checkFile.exists())
            new ChangeStateListener().actionPerformed(new ActionEvent(obj,400,"Successfully Created Quiz"));
        else
            new ChangeStateListener().actionPerformed(new ActionEvent(obj,202,"File Not Found!! Error Occurred"));
    }
}
