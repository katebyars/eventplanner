import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import models.Planner;


/**
 * Created by Guest on 8/4/17.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello and welcome to the party planner! Let's go over a few questions so that we can work up a custom quote for you. Type YES if you would like to continue!");

        try {
            String navigationChoice = bufferedReader.readLine();
            if (navigationChoice.equals("YES")) {

                System.out.println("Hello! What is your name?");
                String nameofPartyPlanner = bufferedReader.readLine();

                System.out.println(nameofPartyPlanner + ", how many guests will you have? If you have 150 guests or more, you'll receive $50.00 your entire price!");
                int numberOfGuests = Integer.parseInt(bufferedReader.readLine());

                System.out.println(nameofPartyPlanner + ", we have many discounts available for your party next to each item.");
                System.out.println("Let's talk about what you will eat. We have several menus to choose from. Please type in the number of the menu you would like: 1. Deluxe International - $100 off your order! 2. American Fusion Buffet 3. Backyard Barbeque.");
                String foodMenu = bufferedReader.readLine();

                System.out.println("Would you like a band for the evening " + nameofPartyPlanner + "?" + "Please type the number of the band you would like. You may select from the following house bands : 1.Perry and the Developers - $100 off your order! 2.You're the Project 3. Resubmit For Indentation");
                String bandName = bufferedReader.readLine();

                System.out.println("Would you like beverages at your party? We offer many choices. Please type the number of your choice: 1.Soft Drinks - $100 off your order! 2.Beer and Wine 3.Full Well Bar, Unlimited");
                String beverageMenu = bufferedReader.readLine();


                Planner planner = new Planner(nameofPartyPlanner, numberOfGuests, bandName, foodMenu, beverageMenu);
                planner.convertChoicesBand(bandName);
                System.out.println("Great! Here are the details of your party:");
                System.out.println("___________________________________________");
                System.out.println("The party planner:" + planner.getNameofPartyPlanner());
                System.out.println("The number of guests:" + planner.getNumberOfGuests());
                System.out.println("The band name:" + planner.getBandName());
                System.out.println("The food menu:" + planner.getFoodMenu());
                System.out.println("The beverage choice:" + planner.getBeverageMenu());
                System.out.println("Total cost: $" + planner.calculatePartyPrice(numberOfGuests, foodMenu, bandName, beverageMenu));

                System.out.println("Do you have any coupons you would like to apply to this total?");
                int totalPrice = planner.calculatePartyPrice(numberOfGuests, foodMenu, bandName, beverageMenu);
                int newTotal = planner.couponGenerator(totalPrice, numberOfGuests, bandName, foodMenu, beverageMenu);
                System.out.println("AND guess what " + nameofPartyPlanner +"! you qualified for a few discounts because of your selections! Your new total is : " + newTotal);
            }

            else {
                System.out.println("Ok! Happy shopping elsewhere!");
            }

    }
    catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
