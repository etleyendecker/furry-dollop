/*\
 * Created by robert hubbard on 9/7/17.
 */
class Package{
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

    String getTrackingNumber(){
        return trackingNumber;
    }
    String getType() {
        return type;
    }
    String getSpecification(){
        return specification;
    }
    String getMailingClass(){
        return mailingClass;
    }
    float getWeight(){
        return weight;
    }
    int getVolume(){
        return volume;
    }
}
