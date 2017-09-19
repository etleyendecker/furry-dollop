/*
 * Created by robert hubbard on 9/12/17.
 */
import java.util.*;
class UI {
    //DataBase db = new DataBase();
    private Scanner menuInput = new Scanner(System.in);
    DataBase db = new DataBase();

    void load() throws Exception {
        db.loadData();
    }

    void printMenu() throws Exception{
        System.out.println("1-Show all packages");
        System.out.println("2-Add a new package");
        System.out.println("3-Delete a package");
        System.out.println("4-Search for package (tracking number)");
        System.out.println("5-Show packages within a given weight range");
        System.out.println("6-Exit Program");
    }
    private void printDataBase(){
        String[] categories = {"TRACKING NUMBER", "TYPE", "SPECIFICATION",
                "MAILING CLASS", "WEIGHT", "VOLUME"};
        System.out.println("\n--------------------------------------" +
                           "---------------------------------------");
        for (String x: categories) {
            System.out.print(x + "    ");
        }
        System.out.println("\n--------------------------------------" +
                           "---------------------------------------");
        for (int x = 0; x < db.List.size(); x++){
            printPackage(x);
        }

    }
    private void printPackage(int x){
        System.out.printf("%-19s", db.List.get(x).getTrackingNumber());
        System.out.printf("%-8s", db.List.get(x).getType());
        System.out.printf("%-17s", db.List.get(x).getSpecification());
        System.out.printf("%-17s", db.List.get(x).getMailingClass());
        System.out.printf("%-10.2f", db.List.get(x).getWeight());
        System.out.printf("%-10d", db.List.get(x).getVolume());
        System.out.println();
    }
    void getMenuChoice(int x) throws Exception{
        switch (x) {
            // Show all existing packages records in the database (unordered)
            case 1:
                printDataBase();
                break;
            // Adds new package to database
            case 2:
                db.addPackage();
                break;
            // Deletes package from database
            case 3:
                System.out.println("Enter the tracking number: ");
                String stringInput = menuInput.nextLine();
                db.deletePackage(stringInput);
                break;
            // Search for a package (by tracking number)
            case 4:
                System.out.println("Please enter the tracking number");
                stringInput = menuInput.nextLine();
                int i = db.trackingNumberMatch(stringInput);
                if (i != -1){
                    printPackage(i);
                }
                else
                    System.out.println("No packages found with tracking number: " + stringInput);
                break;

            // Shows a list of packages within a given weight range
            case 5:
                System.out.println("Minimum weight: ");
                float floatInput1 = menuInput.nextFloat();
                System.out.println("Maximum weight: ");
                float floatInput2 = menuInput.nextFloat();
                for (int j = 0; j < db.List.size(); j++){
                    if (db.withinWeightRange(j, floatInput1, floatInput2)){
                        printPackage(j);
                    }
                }
                break;
            // Exits program
            case 6:
                // Save Database to file
                db.updateDatabase();
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
