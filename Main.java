/**
 * @author Robert Hubbard Emily Leyendecker
 * @since 9.12.17
 *
 * Main Application class
 */

import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception{
        Scanner menuInput = new Scanner(System.in);
        DataBase.loadData();
        UI.printMenu();
        // user input for menu choice
        int input; 
            do {
                input = menuInput.nextInt();
                UI.getMenuChoice(input);
                System.out.println("Press any key + enter to display menu");
                menuInput.next();
                System.out.println();
                UI.printMenu();
            } while(input != 6);
    }
}
