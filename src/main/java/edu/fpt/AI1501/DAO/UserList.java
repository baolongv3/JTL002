package edu.fpt.AI1501.DAO;

import java.util.ArrayList;

import com.google.gson.Gson;

import edu.fpt.AI1501.DTO.User;
import edu.fpt.AI1501.Utils.EssentialUtils;
import edu.fpt.AI1501.Utils.Menu;
import edu.fpt.AI1501.View.InputUserUtils;
import edu.fpt.AI1501.View.PrintUtils;

public class UserList extends ArrayList<User> {

    /**
     *
     */

    private static final long serialVersionUID = 1L;
    final String PATH = System.getProperty("userDir", "/user/user.txt");

    public UserList() {
        
    }

    public Integer search(String username) {
        return this.indexOf(new User(username));
    }

    public void add() {

        while (true) {
            String username;
            String password;
            String firstName;
            String lastName;
            String email;
            String phoneNumber;

            username = InputUserUtils.inputUser(false);
            password = InputUserUtils.inputPassword(false, true);
            firstName = InputUserUtils.inputFirstName(false);
            lastName = InputUserUtils.inputLastName(false);
            email = InputUserUtils.inputEmail(false);
            phoneNumber = InputUserUtils.inputPhoneNumber(false);

            User currentUser = new User(username, password, email, phoneNumber, firstName, lastName);

            System.out.println("Current Student Info:");
            PrintUtils.printUserInfo(currentUser);

            boolean isUserConfirm = EssentialUtils.chooseYN("Confirm: Add This Student?");

            if (isUserConfirm) {
                this.add(currentUser);
            } else {
                System.out.println("User NOT Added");
            }

            if (!EssentialUtils.chooseYN("Do you want to continue adding user")) {
                System.out.println("Exited!");
                return;
            }

        }
    }

    public void updateMenu() {
        Integer posID;

        if (isEmpty()) {
            System.out.println("The List is Empty!");
            return;
        }

        if ((posID = InputUserUtils.loginUser(this)) == -1) {
            return;
        }

        

        Menu menu = new Menu("Update and Delete Menu");

        menu.addItems("Update User Info");
        menu.addItems("Delete User");

        while (true) {
            menu.printMenu("Exit");
            Integer choice = menu.getChoice();

            switch (choice) {
                case 1:
                    update(posID);
                    break;
                case 2:
                    delete(posID);
                    break;
                default:
                    System.out.println("Menu Exited!");
                    return;
            }
        }

    }

    private void update(Integer posID) {

        Menu updateMenu = new Menu("Update memu");
        updateMenu.add("Update password");
        updateMenu.add("Update First Name");
        updateMenu.add("Update Last Name");
        updateMenu.add("Update email");
        updateMenu.add("Update Phone Number");

        while (true) {
            updateMenu.printMenu("Exit");
            Integer choice = updateMenu.getChoice();
            switch (choice) {
                case 1:
                    String password = InputUserUtils.inputPassword(true, true);
                    if (EssentialUtils.isEmptyString(password)) {
                        System.out.println("Password unchanged!");
                    } else {
                        this.get(posID).setPassword(password);
                        System.out.println("Password changed successfully!");
                    }
                    break;
                case 2:
                    String firstName = InputUserUtils.inputFirstName(true);
                    if (EssentialUtils.isEmptyString(firstName)) {
                        System.out.println("First Name unchanged!");
                    } else {
                        this.get(posID).setFirstName(firstName);
                        System.out.println("First Name changed successfully!");
                    }
                    break;
                case 3:
                    String lastName = InputUserUtils.inputLastName(true);
                    if (EssentialUtils.isEmptyString(lastName)) {
                        System.out.println("Last Name unchanged!");
                    } else {
                        this.get(posID).setLastName(lastName);
                        System.out.println("Last Name changed successfully!");
                    }
                    break;
                case 4:
                    String email = InputUserUtils.inputEmail(true);
                    if (EssentialUtils.isEmptyString(email)) {
                        System.out.println("Email unchanged!");
                    } else {
                        this.get(posID).setEmail(email);
                        System.out.println("Email changed successfully!");
                    }
                    break;
                case 5:
                    String phoneNumber = InputUserUtils.inputPhoneNumber(true);
                    if (EssentialUtils.isEmptyString(phoneNumber)) {
                        System.out.println("Phone Number unchanged!");
                    } else {
                        this.get(posID).setPhoneNumber(phoneNumber);
                        System.out.println("Phone Number changed successfully!");
                    }
                default:
                    System.out.println("Update Exited!");
                    return;

            }
        }
    }

    private void delete(Integer posID) {
        Boolean confirm = EssentialUtils.chooseYN("Do you want to delete this user?");
        if (!confirm) {
            System.out.println("User Remove Cancelled");
            return;
        }
        this.remove(this.get(posID));
        System.out.println("User Remove Successfully!");
    }

    public String toString(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }
    

    public void printFromFile(){
        UserList userArr = EssentialUtils.readFromFile(PATH);
        for(User userInfo : userArr){
            System.out.println(userInfo);
        }
    }

    public void findFromFile(){
        UserList tempArr = EssentialUtils.readFromFile(PATH);
        

        
        
    }

    public void saveToFile(){
        EssentialUtils.saveToFile(PATH, this.toString());
    }




    

    
}
