package com.restassured.automation.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SpecialMethods {

    public static Properties properties;

    public static String validationGetName, validationGetLastName, validationGetToken, validationPostJob,
            validationPatchName, validationPutJob, validationGetId;


    public static void configPropertiesRead(){
        properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/test_data/conf.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readTxtFile(){
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("src/main/resources/test_data/validations.txt");
            if (fileReader.ready()) {
                bufferedReader = new BufferedReader(fileReader);
                validationGetName = bufferedReader.readLine();
                validationGetLastName = bufferedReader.readLine();
                validationGetToken = bufferedReader.readLine();
                validationPostJob = bufferedReader.readLine();
                validationPatchName = bufferedReader.readLine();
                validationPutJob = bufferedReader.readLine();
                validationGetId = bufferedReader.readLine();
            }
            else{
                System.out.println("File could not be uploaded");
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


}
