package edu.fpt.AI1501.View;

import edu.fpt.AI1501.DTO.User;

public class PrintUtils {
    
    public static void printUserInfo(User user){
        System.out.println(String.format("Username: %s",user.getUsername()));
        System.out.println(String.format("Password: Hidden"));
        System.out.println(String.format("Name: %s",user.getName()));        
        System.out.println(String.format("Email: %s",user.getEmail()));
        System.out.println(String.format("Phone Number: %s",user.getPhoneNumber()));
    }
}
