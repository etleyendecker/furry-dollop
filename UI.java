/*
 * Created by robert hubbard on 9/12/17.
 */
import java.util.*;
public class UI {
    static Scanner menuInput = new Scanner(System.in);
    static String stringInput;
    static float floatInput1; // minimum weight input 
    static float floatInput2; // maximum weight input
    public static void printMenu(){
        System.out.println("1-Show all packages");
        System.out.println("2-Add a new package");
        System.out.println("3-Delete a package");
        System.out.println("4-Search for package (tracking number)");
        System.out.println("5-Show packages within a given weight range");
        System.out.println("6-Exit Program");
    }
    public static void printDataBase(){
        String[] categories = {"TRACKING NUMBER", "TYPE", "SPECIFICATION",
                "MAILING CLASS", "WEIGHT", "VOLUME"};
        System.out.println("\n--------------------------------------" +
                           "---------------------------------------");
        for (String x: categories) {
            System.out.print(x + "    ");
        }
        System.out.println("\n--------------------------------------" +
                           "---------------------------------------");
        for (int x = 0; x < DataBase.List.size(); x++){
            printPackage(x);
        }

    }
    public static void printPackage(int x){
        System.out.printf("%-19s", DataBase.List.get(x).getTrackingNumber());
        System.out.printf("%-8s", DataBase.List.get(x).getType());
        System.out.printf("%-17s", DataBase.List.get(x).getSpecification());
        System.out.printf("%-17s", DataBase.List.get(x).getMailingClass());
        System.out.printf("%-10.2f", DataBase.List.get(x).getWeight());
        System.out.printf("%-10d", DataBase.List.get(x).getVolume());
        System.out.println();
    }
    public static void getMenuChoice(int x) throws Exception{
        switch (x) {
            // Show all existing packages records in the database (unordered)
            case 1:
                printDataBase();
                break;
            // Adds new package to database
            case 2:
                DataBase.addPackage();
                break;
            // Deletes package from database
            case 3:
                System.out.println("Enter the tracking number: ");
                stringInput = menuInput.nextLine();
                DataBase.deletePackage(stringInput);
                break;
            // Search for a package (by tracking number)
            case 4:
                System.out.println("Please enter the tracking number");
                stringInput = menuInput.nextLine();
                int i = DataBase.trackingNumberMatch(stringInput);
                if (i != -1){
                    printPackage(i);
                }
                else
                    System.out.println("No packages found with tracking number: " + stringInput);
                break;

            // Shows a list of packages within a given weight range
            case 5:
                System.out.println("Minimum weight: ");
                floatInput1 = menuInput.nextFloat();
                System.out.println("Maximum weight: ");
                floatInput2 = menuInput.nextFloat();
                for (int j = 0; j < DataBase.List.size(); j++){
                    if (DataBase.withinWeightRange(j, floatInput1, floatInput2)){
                        printPackage(j);
                    }
                }
                break;
            // Exits program
            case 6:
                // Save Database to file
                DataBase.updateDatabase();
                System.out.println("-Database Saved-");
                System.exit(0);
                break;
            // Invalid user input
            default:
                System.err.println("Please enter an integer within the range (1-6)");
                int intInput = menuInput.nextInt();
                getMenuChoice(intInput);
                break;
        }
    }

}
