/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fpt.AI1501.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;



/**
 *
 * @author ACER
 */
public class EssentialUtils {
    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^\\w+[A-Z0-9._%+-]?+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[\\s]+$");
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    private static Scanner sc = new Scanner(System.in);

    // Validate phone number through RegExp
    public static boolean isPhoneNumberValid(String number) {
        Matcher matcher = PHONE_PATTERN.matcher(number);
        return matcher.matches();
    }

    // Validate email through RegExp
    public static boolean isEmailValid(String email) {
        final Matcher matcher = EMAIL_PATTERN.matcher(email);
        final boolean isValid = matcher.find();
        return isValid;
    }

    // Validate Date through date
    public static boolean isDateValid(String date) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(date);

        } catch (final ParseException e) {
            return false;
        }
        return true;
    }

    // Check null and empty String
    public static boolean isEmptyString(String string) {
        return string.isBlank();
    }

    

    // Utility for checking returning yes or no with Question dialog
    public static boolean chooseYN(String questionDialog) {
        String userChoice = null;
        boolean choice = false;
        do {
            System.out.print(questionDialog);
            userChoice = sc.nextLine().toUpperCase();
            if (userChoice.equals("N")) {
                choice = false;
            } else if (userChoice.equals("Y")) {
                choice = true;
            } else {
                System.out.println("Must be Y or N");
            }
        } while (!"N".equals(userChoice) && !"Y".equals(userChoice));

        return choice;
    }

    public static String capitalizeName(String name){
        name = name.toLowerCase().trim();
        String[] nameArray = name.split("\\s");
        StringBuilder newName = new StringBuilder();
        for(String word : nameArray){
            newName.append(StringUtils.capitalize(word));
            newName.append(" ");
        }
        return newName.toString().trim();
    }
    
    public static boolean isPasswordValid(String password){
        Matcher matcher = PASSWORD_PATTERN.matcher(password);


        if(password.length() < 8){
            return false;
        }

        if(matcher.find()){
            return false;
        }

        return true;

        
    }

    public static String encryptMessage(String text){
        String encryptedText = DigestUtils.sha256Hex(text);
        return encryptedText;
    }

    public static ArrayList<String> readFromFile(String path){
        Path filePath = Paths.get(path);
        ArrayList<String> itemArray = new ArrayList<>();
        try{
            String info = Files.readString(filePath);
            StringTokenizer stk = new StringTokenizer(info,"\n");
            while(stk.hasMoreTokens()){
                itemArray.add(stk.nextToken());
            }         

            if(itemArray.isEmpty()){
                System.out.println("Nothing to read!");
                return null;
            } else{
                return itemArray;
            }

        }catch(IOException e){
            System.out.println("File inaccessible!");
            return null;
        }
        

    }

    public boolean saveToFile(String fileName, String infoOut){
        Path path = Paths.get(fileName);

        try{
            Files.writeString(path, infoOut, StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            return true;
        }catch(IOException e){
            System.out.println("Save Failed!");
            return false;
        }
    }
    



}
