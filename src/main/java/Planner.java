import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Guest on 8/4/17.
 */
public class Planner {

    private String nameofParty;
    private int numberOfGuests;
    private ArrayList<String> foodItems;
    private ArrayList<String> beverages;
    private String bandName;

    public Planner(String nameofParty, int numberOfGuests, String bandName){
    }

    public String getBandName() {
        return bandName;
    }
    public String getNameofParty() {
        return nameofParty;
    }
    public int getNumberOfGuests() {
        return numberOfGuests;
    }
    public ArrayList<String> getFoodItems() {
        return foodItems;
    }
    public ArrayList<String> getBeverages() {
        return beverages;
    }

}
