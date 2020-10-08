package edu.fpt.AI1501.View;

import edu.fpt.AI1501.DAO.UserList;
import edu.fpt.AI1501.DTO.User;

public class PrintUtils {
    
    public static void printUserInfo(User user){
        System.out.println("------------------------------------------------------------------------");
        System.out.println(String.format("Username: %s",user.getUsername()));
        System.out.println(String.format("Password: Hidden"));
        System.out.println(String.format("Name: %s",user.getName()));        
        System.out.println(String.format("Email: %s",user.getEmail()));
        System.out.println(String.format("Phone Number: %s",user.getPhoneNumber()));
        System.out.println("------------------------------------------------------------------------");
    }

    public static void printUserList(UserList list){
        if(list.isEmpty()){
            System.out.println("Empty List!");
        }

        System.out.println("User List In File");
        System.out.println(String.format("| %-20s | %-64s | %-40s | %-20s | %-20s","Username","Password","Name","Email","Phone number"));
        for(User user : list){
            System.out.println(String.format("| %-20s | %-64s | %-40s | %-20s | %-20s",user.getUsername(),user.getPassword(),user.getName(),user.getEmail(),user.getPhoneNumber()));
        }

        

    }
}
