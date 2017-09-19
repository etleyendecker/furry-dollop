/*
 * Created by robert hubbard on 9/12/17.
 *
 *
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.*;
public class DataBase {

    static ArrayList<Package> List = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void addPackage(){
        System.out.println("Please enter the Tracking Number: ");
        String a = input.nextLine();
        System.out.println("Please enter the Type: ");
        String b = input.nextLine();
        System.out.println("Please enter the Specification: ");
        String c = input.nextLine();
        System.out.println("Please enter the Mailing Class: ");
        String d = input.nextLine();
        System.out.println("Please enter the Weight: ");
        float e = input.nextFloat();
        System.out.println("Please enter the Volume: ");
        int f = input.nextInt();
        List.add(new Package(a, b, c, d, e, f));

    }

    public static int trackingNumberMatch(String tN) {
        for (int i = 0; i < DataBase.List.size(); i++) {
            if (DataBase.List.get(i).getTrackingNumber().equals(tN)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean withinWeightRange(int i, float f1, float f2){
        if (List.get(i).getWeight() >= f1 && List.get(i).getWeight() <= f2){
            return true;
        }
        else{
            return false;
        }
    }

    public static void deletePackage(String tN){
        int i = trackingNumberMatch(tN);
        if (i != -1){
            List.remove(i);
        }
        //Remove from ArrayList

    }

    public static void loadData() throws Exception{
        File file = new File ("packages.txt");
        file.createNewFile();
        Scanner inFile = new Scanner(new FileReader("packages.txt"));
        String getDataString;
        String[] dataWord;
        while (inFile.hasNextLine()){
            getDataString = inFile.nextLine();
            dataWord = getDataString.split(" ");
            String a = dataWord[0];
            String b = dataWord[1];
            String c = dataWord[2];
            String d = dataWord[3];
            float e = Float.parseFloat(dataWord[4]);
            int f = Integer.parseInt(dataWord[5]);
            List.add(new Package(a, b, c, d, e, f));
        }
        inFile.close();
    }

    public static void updateDatabase() throws Exception{
        PrintWriter outFile = new PrintWriter("packages.txt");
        for (int x = 0; x < DataBase.List.size(); x++){
            outFile.println(List.get(x).getTrackingNumber() + " " +
                    List.get(x).getType() + " " +
                    List.get(x).getSpecification() + " " +
                    List.get(x).getMailingClass() + " " +
                    List.get(x).getWeight() + " " +
                    List.get(x).getVolume());
        }
        outFile.close();
    }
}
