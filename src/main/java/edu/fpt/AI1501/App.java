package edu.fpt.AI1501;

import edu.fpt.AI1501.DAO.UserList;
import edu.fpt.AI1501.Utils.Menu;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
        UserList mainList  = new UserList(true);
        Menu menu = new Menu("User Manager");
        
        menu.addItems("Create New User");
        menu.addItems("Check Exist User");
        menu.addItems("Search User By Name");
        menu.addItems("Update Or Delete User");
        menu.addItems("Save all Accounts To File");
        menu.addItems("Print List user From File");

        while(true){
            menu.printMenu("Exit");
            Integer userChoice = menu.getChoice();
            switch(userChoice){
                case 1:
                    mainList.add();
                    break;
                case 2:
                    mainList.checkExistFromFile();
                    break;
                case 3:
                    mainList.findNameFromFile();
                    break;
                case 4:
                    mainList.updateMenu();
                    break;
                case 5:
                    mainList.saveToFile();
                    break;
                case 6:
                    mainList.printFromFile();
                    break;
                default:
                    System.out.println("Exiting...");
                    return;

            }
        }
    }
}
