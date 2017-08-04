import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.Planner;


/**
 * Created by Guest on 8/4/17.
 */
public class App {
    public static void main(String[] args) {
        Planner planner = new Planner();
        BufferedReader bufferedReader = new BufferedReader(InputStreamReader(System.in));
        System.out.println("Hello and welcome to the party planner! Let's go over a few questions so that we can work up a custom quote for you.");
        System.out.println("For our records, what is the name of your party?");
        String nameofParty = bufferedReader.readLine();

        System.out.println("How many guests will you have?");
        int numberOfGuests = bufferedReader.readLine();

        System.out.println("We have several menus to choose from. Please type in the number of the menu you would like: 1. Deluxe International 2. American Fusion Buffet 3. Backyard Barbeque");
        String foodMenu = bufferedReader.readLine();

        System.out.println("Would you like a band for the evening? Please type the number of the band you would like. You may select from the following house bands : 1.Perry and the Developers 2.You're the Project 3. Resubmit For Indentation");
        String bandName = bufferedReader.readLine();

        System.out.println("Would you like beverages at your party? We offer many choices. Please type the number of your choice: 1.Soft Drinks 2.Beer and Wine 3.Full Well Bar, Unlimited");
        String beverageMenu = bufferedReader.readLine();

        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
