package edu.fpt.AI1501.DTO;

import edu.fpt.AI1501.Utils.EssentialUtils;

public class User implements Comparable<User> {
    /**
     *
     */
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String firstName;
    private String lastName;

    public User(String username, String password, String phoneNumber, String email, String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public User(String username){
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName(){
        return firstName + " " + lastName;
    }

    public boolean equals(Object user){
        return this.getUsername().equals(((User) user).getUsername());
    }

    public String toString(){
        return String.format("%s;%s;%s;%s;%s;%s",username,password,firstName,lastName,email,phoneNumber);
    }

    public boolean checkValid(){
        if(!EssentialUtils.isUsernameValid(username))  return false;
        if(!EssentialUtils.isEncryptedPasswordValid(password)) return false;
        if(!EssentialUtils.isPhoneNumberValid(phoneNumber)) return false;
        if(!EssentialUtils.isEmailValid(email)) return false;
        return true;

        
    }

    @Override
    public int compareTo(User o) {
        return this.getFirstName().compareTo(o.getFirstName());
        
    }

    
    
}
