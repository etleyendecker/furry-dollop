/*
 *
 *
 */

import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception{
        Scanner menuInput = new Scanner(System.in);
        UI ui = new UI();
        ui.load();
        ui.printMenu();
        int input;
            do {
                input = menuInput.nextInt();
                ui.getMenuChoice(input);
                System.out.println("Press any key + enter to display menu");
                menuInput.next();
                System.out.println();
                ui.printMenu();
            } while(input != 6);
    }
}
