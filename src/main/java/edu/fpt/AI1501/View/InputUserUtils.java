package edu.fpt.AI1501.View;

import java.util.Scanner;

import edu.fpt.AI1501.DAO.UserList;
import edu.fpt.AI1501.Utils.EssentialUtils;


public class InputUserUtils {
    static Scanner sc = new Scanner(System.in);

    public static String inputUsername(boolean isReturnNullAllowed) {
        while (true) {            
            sc = new Scanner(System.in);
            System.out.print("Input Username:  ");
            String username = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(username);
            boolean isUsernameValid = EssentialUtils.isUsernameValid(username);
            if(isReturnNullAllowed && isNull){
                return null;
            }
            if(!isNull && isUsernameValid){
                return username;
            }
            System.out.println("Username cannot be null And Must Above 5 Character And No Space");
        }
    }


    public static String inputEmail(boolean isReturnNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(email);
            boolean isEmailValid = EssentialUtils.isEmailValid(email);
            if(isReturnNullAllowed && isNull){
                return null;
            }
            if(!isNull && isEmailValid){
                return email;
            } else{
                System.out.println("Email Format isnt valid!");
            }

        }
    }

    public static String inputPassword(boolean isReturnNullAllowed, boolean isRegister){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Input password: ");
            String password = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(password);
            boolean isPasswordValid = EssentialUtils.isPasswordValid(password);
            if(isReturnNullAllowed && isNull) {
                return null;
            }
            if (!isNull && isPasswordValid && isRegister) {
                if (confirmPassword(password)) {
                    return EssentialUtils.encryptMessage(password);
                }
            }
            if (!isNull && isPasswordValid) {
                return EssentialUtils.encryptMessage(password);
            }
            System.out.println("Password Format Incorrect! Must be above 8 and no space");

        }
    }

    public static boolean confirmPassword(String srcPassword) {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Enter the typed password: ");
            String conPassword = sc.nextLine();
            if (conPassword.equals(srcPassword)) {
                return true;
            } else {
                System.out.println("Try Again!");
            }

        }
    }

    public static String inputPhoneNumber(boolean isReturnNullAllowed) {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Enter phone number:  ");
            String phoneNumber = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(phoneNumber);
            boolean isPhoneNumberValid = EssentialUtils.isPhoneNumberValid(phoneNumber);
            if (isReturnNullAllowed && isNull) {
                return null;
            }
            if (!isNull && isPhoneNumberValid) {
                return phoneNumber;
            }
            System.out.println("Phone Number Format Invalid!");
        }
    }

    public static String inputLastName(boolean isReturnNullAllowed) {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Enter Last Name:  ");
            String lastName = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(lastName);
            if (isNull && isReturnNullAllowed) {
                return null;
            }
            if (!isNull) {
                return EssentialUtils.capitalizeName(lastName);
            }
            System.out.println("Last Name cannot be empty!");
        }
    }

    public static String inputFirstName(boolean isReturnNullAllowed) {
        while (true) {
            sc = new Scanner(System.in);
            System.out.print("Enter First Name:  ");
            String firstName = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(firstName);
            if (isNull && isReturnNullAllowed) {
                return null;
            }
            if(!isNull){
                return EssentialUtils.capitalizeName(firstName);
            }
            System.out.println("First Name cannot be empty!");
        }
    }

    public static String inputName(boolean isNullAllowed){
        while(true){
            sc = new Scanner(System.in);
            System.out.print("Enter Portion of a Name:  ");
            String name = sc.nextLine();
            boolean isNull = EssentialUtils.isEmptyString(name);
            if(isNull && isNullAllowed){
                return null;
            }
            if(!isNull){
                return name;
            }
            System.out.println("Name cannot be empty!");
        }
    }

    public static Integer loginUser(UserList list){

        sc = new Scanner(System.in);
        System.out.println("Input Username And Password To Perform Delete Action");
        String username = inputUsername(true);
        String password = inputPassword(true,false);
        Integer posId = list.search(username);
        if(posId == -1){
            System.out.println("No Username Exist Or Incorrect Password!");
            return -1;
        }
        
        if(password.equals(list.get(posId).getPassword())){
            return posId;
        } else{
            System.out.println("No Username Exist Or Incorrect Password!");
            return -1;
        }

        

    }
}
