import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import models.Planner;


/**
 * Created by Guest on 8/4/17.
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Planner> allParties = new ArrayList<Planner>();
        boolean programRunning = true;

        while (programRunning) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Hello and welcome to the party planner! Let's go over a few questions so that we can work up a custom quote for you. Enter one of the following navigation choices: PLAN, EXIT, SEE MY PARTIES");
            try {
                String navigationChoice = bufferedReader.readLine();
                if (navigationChoice.equals("PLAN")) {
                    programRunning = true;

                    System.out.println("Hello! What is your name?");
                    String nameofPartyPlanner = bufferedReader.readLine();

                    System.out.println(nameofPartyPlanner + ", how many guests will you have?");
                    int numberOfGuests = Integer.parseInt(bufferedReader.readLine());

                    System.out.println("Let's talk about what you will eat. We have several menus to choose from. Please type in the number of the menu you would like: 1. Deluxe International 2. American Fusion Buffet 3. Backyard Barbeque.");
                    String foodMenu = bufferedReader.readLine();

                    System.out.println("Would you like a band for the evening " + nameofPartyPlanner + "?" + " Please type the number of the band you would like. You may select from the following house bands : 1.Perry and the Developers2.You're the Project 3. Resubmit For Indentation");
                    String bandName = bufferedReader.readLine();

                    System.out.println("Would you like beverages at your party? We offer many choices. Please type the number of your choice: 1.Soft Drinks 2.Beer and Wine 3.Full Well Bar, Unlimited");
                    String beverageMenu = bufferedReader.readLine();


                    Planner planner = new Planner(nameofPartyPlanner, numberOfGuests, bandName, foodMenu, beverageMenu);

                    planner.convertChoicesBand(bandName);
                    planner.convertChoicesFood(foodMenu);
                    planner.convertChoicesBeverage(beverageMenu);
                    allParties.add(planner);

                    System.out.println("Great! Here are the details of your party:");
                    System.out.println("###############################################################################");
                    System.out.println("The party planner: " + planner.getNameofPartyPlanner());
                    System.out.println("The number of guests: " + planner.getNumberOfGuests());
                    System.out.println("The band name: " + planner.getBandName());
                    System.out.println("The food menu: " + planner.getFoodMenu());
                    System.out.println("The beverage choice: " + planner.getBeverageMenu());
                    System.out.println("Total cost: $" + planner.calculatePartyPrice(numberOfGuests, foodMenu, bandName, beverageMenu));

                    System.out.println("Are you eligible for any coupons? If so, you may apply them to your total now. Remember: you may only redeem one coupon for each party that you plan. If you input a coupon that you are not eligible for, our system will apply any other qualifying coupons instead.");
                    System.out.println("###############################  COUPON CODES  ################################");
                    System.out.println("code - PERRY: Perry and the Developers + Full Well Bar - 200.00 off order");
                    System.out.println("code - YOU: 150 Guests + You're the Project - 100.00 off order");
                    System.out.println("code - YAY: Resubmit For Indentation + Full Well Bar + Deluxe International Menu - 400.00 off order");
                    System.out.println("#############################  ENTER YOUR COUPON CODE  ########################");

                    String coupon = bufferedReader.readLine();

                    if (coupon.equals("PERRY") || coupon.equals("YOU") || coupon.equals("YAY")) {
                        System.out.println("Great! You got a discount! Your new order total is: " + planner.couponGenerator(planner.getTotalPrice(), planner.getNumberOfGuests(), planner.getBandName(), planner.getFoodMenu(), planner.getBeverageMenu()));
                    } else {
                        System.out.println("Whoops! It looks like you don't qualify for a coupon!");
                    }
                } else if (navigationChoice.equals("SEE MY PARTIES")) {
                    System.out.println("Ok, here are your parties!");
                    programRunning = true;
                    System.out.println("#############################  Here are all of your planned parties  ########################");
                    for (Planner individualParty : allParties){
                        System.out.println(individualParty.nameofPartyPlanner();
                        System.out.println(individualParty.numberOfGuests();
                        System.out.println(individualParty.bandName();
                        System.out.println(individualParty.foodMenu();
                        System.out.println(individualParty.beverageMenu();
                        System.out.println(individualParty.totalPrice();
                    }

                } else if (navigationChoice.equals("EXIT")) {
                    System.out.println("Goodbye!");
                    programRunning = false;
                } else {
                    System.out.println("I'm sorry, we don't recognize your input");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
