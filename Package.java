/**
 * @author Robert Hubbard Emily Leyendecker
 * @since 9/7/17.
 *
 * constructs Package object for data entry
 */

public class Package{
    private String origionalString;
    private String trackingNumber;
    private String type;
    private String specification;
    private String mailingClass;
    private float weight;
    private int volume;

    public Package(String tN, String tP, String sP,
                   String mC, float wT, int vM){
        trackingNumber = tN;
        type = tP;
        specification = sP;
        mailingClass = mC;
        weight = wT;
        volume = vM;
    }
    Package (String oS){
        origionalString = oS;
    }
    public String getTrackingNumber(){
        return trackingNumber;
    }
    public String getType() {
        return type;
    }
    public String getSpecification(){
        return specification;
    }
    public String getMailingClass(){
        return mailingClass;
    }
    public float getWeight(){
        return weight;
    }
    public int getVolume(){
        return volume;
    }
}
