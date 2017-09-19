/*
 * Created by robert hubbard on 9/12/17.
 *
 *
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.FileReader;
import java.util.*;
class DataBase {

    ArrayList<Package> List = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    void addPackage(){
        System.out.println("Please enter the Tracking Number: ");
        String a = input.next();
        System.out.println("Please enter the Type: ");
        String b = input.next();
        System.out.println("Please enter the Specification: ");
        String c = input.next();
        System.out.println("Please enter the Mailing Class: ");
        String d = input.next();
        System.out.println("Please enter the Weight: ");
        float e = input.nextFloat();
        System.out.println("Please enter the Volume: ");
        int f = input.nextInt();
        List.add(new Package(a, b, c, d, e, f));

    }

    int trackingNumberMatch(String tN) {
        for (int i = 0; i < List.size(); i++) {
            if (List.get(i).getTrackingNumber().equals(tN)) {
                return i;
            }
        }
        return -1;
    }

    boolean withinWeightRange(int i, float f1, float f2){
        if (List.get(i).getWeight() >= f1 && List.get(i).getWeight() <= f2){
            return true;
        }
        else{
            return false;
        }
    }

    void deletePackage(String tN){
        int i = trackingNumberMatch(tN);
        if (i != -1){
            List.remove(i);
        }
        //Remove from ArrayList

    }

    void loadData() throws Exception{
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

    void updateDatabase() throws Exception{
        PrintWriter outFile = new PrintWriter("packages.txt");
        for (Package aList : List) {
            outFile.println(aList.getTrackingNumber() + " " +
                    aList.getType() + " " +
                    aList.getSpecification() + " " +
                    aList.getMailingClass() + " " +
                    aList.getWeight() + " " +
                    aList.getVolume());
        }
        outFile.close();
    }
}
