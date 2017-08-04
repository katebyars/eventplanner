import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
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
            System.out.println("Hello and welcome to the party planner! Let's go over a few questions so that we can work up a custom quote for you. Enter one of the following navigation choices: PLAN, EXIT, SEE MY PARTIES, PLAN IT FOR ME, BROWSE PACKAGES");
            try {
                String navigationChoice = bufferedReader.readLine().toUpperCase();
                if (navigationChoice.equals("PLAN")) {
                    programRunning = true;

                    System.out.println("Hello! What is your name?");
                    String nameofPartyPlanner = bufferedReader.readLine();

                    System.out.println(nameofPartyPlanner + ", how many guests will you have?");
                    int numberOfGuests = Integer.parseInt(bufferedReader.readLine());

                    System.out.println("Let's talk about what you will eat. We have several menus to choose from. Please type in the number of the menu you would like: 0. No menu requested 1. Deluxe International 2. American Fusion Buffet 3. Backyard Barbeque.");
                    String foodMenu = bufferedReader.readLine();

                    System.out.println("Would you like a band for the evening " + nameofPartyPlanner + "?" + " Please type the number of the band you would like. You may select from the following house bands : 0. No band requested 1.Perry and the Developers2.You're the Project 3. Resubmit For Indentation");
                    String bandName = bufferedReader.readLine();

                    System.out.println("Would you like beverages at your party? We offer many choices. Please type the number of your choice: 0.No beverages requested 1.Soft Drinks 2.Beer and Wine 3.Full Well Bar, Unlimited");
                    String beverageMenu = bufferedReader.readLine();


                    Planner planner = new Planner(nameofPartyPlanner, numberOfGuests, bandName, foodMenu, beverageMenu);

                    planner.convertChoices(bandName);
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
                    String nicePrice1 = NumberFormat.getIntegerInstance().format(planner.calculatePartyPrice(numberOfGuests, foodMenu, bandName, beverageMenu));
                    System.out.println("Total cost: $" + nicePrice1);

                    System.out.println("Are you eligible for any coupons? If so, you may apply them to your total now. Remember: you may only redeem one coupon for each party that you plan. If you input a coupon that you are not eligible for, our system will apply any other qualifying coupons instead.");
                    System.out.println("###############################  COUPON CODES  ################################");
                    System.out.println("code - PERRY: Perry and the Developers + Full Well Bar - 200.00 off order");
                    System.out.println("code - YOU: 150 Guests + You're the Project - 100.00 off order");
                    System.out.println("code - YAY: Resubmit For Indentation + Full Well Bar + Deluxe International Menu - 400.00 off order");
                    System.out.println("#############################  ENTER YOUR COUPON CODE  ########################");

                    String coupon = bufferedReader.readLine().toUpperCase();

                    if (coupon.equals("PERRY") && planner.getBandName().equals("Perry and the Developers") && planner.getBeverageMenu().equals("Unlimited Full Well Bar")) {
                        String nicePrice3 = NumberFormat.getIntegerInstance().format(planner.couponGenerator(planner.getTotalPrice(), planner.getNumberOfGuests(), planner.getBandName(), planner.getFoodMenu(), planner.getBeverageMenu()));
                        System.out.println("Ok! Here is your discount! Your order total is: " + nicePrice3);
                    }
                    else if (coupon.equals("YOU") && planner.getNumberOfGuests()>=150 && planner.getBandName().equals("You're the Project")){
                        String nicePrice3 = NumberFormat.getIntegerInstance().format(planner.couponGenerator(planner.getTotalPrice(), planner.getNumberOfGuests(), planner.getBandName(), planner.getFoodMenu(), planner.getBeverageMenu()));
                        System.out.println("Ok! Here is your discount! Your order total is: " + nicePrice3);
                    }
                    else if (coupon.equals("YAY") && planner.getBandName().equals("Resubmit for Indentation") && planner.getBeverageMenu().equals("Unlimited Full Well Bar")){
                        String nicePrice3 = NumberFormat.getIntegerInstance().format(planner.couponGenerator(planner.getTotalPrice(), planner.getNumberOfGuests(), planner.getBandName(), planner.getFoodMenu(), planner.getBeverageMenu()));
                        System.out.println("Ok! Here is your discount! Your order total is: " + nicePrice3);
                    }
                    else {
                        System.out.println("Whoops! It looks like you don't qualify for a coupon!");
                    }
                } else if (navigationChoice.equals("SEE MY PARTIES")) {
                    System.out.println("Ok, here are your parties!");
                    programRunning = true;
                    System.out.println("#############################  Here are all of your planned parties  ########################");
                    for (Planner individualParty : allParties){
                        System.out.println("Your Party Planner: " + individualParty.getNameofPartyPlanner());
                        System.out.println("Guest Count: " + individualParty.getNumberOfGuests());
                        System.out.println("The Band: " + individualParty.getBandName());
                        System.out.println("The Menu: " + individualParty.getFoodMenu());
                        System.out.println("Beverage Selection: " + individualParty.getBeverageMenu());
                        String nicePrice = NumberFormat.getIntegerInstance().format(individualParty.getTotalPrice());
                        System.out.println("Total Price: $" + nicePrice);
                        System.out.println("###############################################################################");
                    }

                } else if (navigationChoice.equals("EXIT")) {
                    System.out.println("Goodbye!");
                    programRunning = false;
                } else if (navigationChoice.equals("PLAN IT FOR ME")){

                    String bandString = "";
                    String foodString = "";
                    String beverageString = "";

                    System.out.println("Alright! Let's plan your party. But first, what is your name?");
                    String nameofPartyPlanner = bufferedReader.readLine();

                    System.out.println("One more question : How many people will attend your party? We'll do the rest!");
                    int numberOfGuests = Integer.parseInt(bufferedReader.readLine());

                    Random RandomGeneratorTwo = new Random();
                    int bandNamePicker = RandomGeneratorTwo.nextInt(4);
                    int band = bandNamePicker ;
                    switch (band) {
                        case 1:
                            bandString = "Perry and the Developers";
                            break;
                        case 2:
                            bandString = "You're the Project";
                            break;
                        case 3:
                            bandString = "Resubmit for Indentation";
                            break;
                    }

                    Random RandomGeneratorThree = new Random();
                    int foodNamePicker = RandomGeneratorThree.nextInt(4);
                    int food = bandNamePicker ;
                    switch (food) {
                        case 1:
                            foodString = "Deluxe International";
                            break;
                        case 2:
                            foodString = "American Fusion Buffet";
                            break;
                        case 3:
                            foodString = "Backyard Barbeque";
                            break;
                    }

                    Random RandomGeneratorOne = new Random();
                    int beverageNamePicker = RandomGeneratorOne.nextInt(4);
                    int beverage = bandNamePicker ;
                    switch (beverage) {
                        case 1:
                            beverageString = "Soft Drinks";
                            break;
                        case 2:
                            beverageString = "Beer and Wine";
                            break;
                        case 3:
                            beverageString = "Unlimited Full Well Bar";
                            break;
                    }

                    System.out.println("Here is your band: " + bandString);
                    System.out.println("Here is your food: " + foodString);
                    System.out.println("Here is your beverage selection: " + beverageString);

                    System.out.println("Do you want to add this cool and totally random party to your list of parties? YES or NO?");
                        if (bufferedReader.readLine().toUpperCase().equals("YES")) {
                            Planner planner = new Planner(nameofPartyPlanner, numberOfGuests, bandString, foodString, beverageString);
                            allParties.add(planner);

                            System.out.println("#############################  Your party has been added! The details are below!  ########################");
                            System.out.println("The party planner: " + planner.getNameofPartyPlanner());
                            System.out.println("The number of guests: " + planner.getNumberOfGuests());
                            System.out.println("The band name: " + planner.getBandName());
                            System.out.println("The food menu: " + planner.getFoodMenu());
                            System.out.println("The beverage choice: " + planner.getBeverageMenu());
                            String nicePrice5 = NumberFormat.getIntegerInstance().format(planner.calculatePartyPrice(numberOfGuests, foodString, bandString, beverageString));
                            System.out.println("Total cost: $" + nicePrice5);
                        }
                        else{
                            System.out.println("Ok! No worries! What would you like to do next?");
                            programRunning = true;
                        }
                }
                else if (navigationChoice.toUpperCase().equals("BROWSE PACKAGES")){

                    Planner wedding = new Planner("The Wedding Package", 200, "2", "1", "3");
                    wedding.convertChoices(wedding.getBandName());
                    wedding.convertChoicesFood(wedding.getFoodMenu());
                    wedding.convertChoicesBeverage(wedding.getBeverageMenu());

                    Planner birthday = new Planner ("The Birthday Package", 30, "1", "1", "3");
                    birthday.convertChoices(birthday.getBandName());
                    birthday.convertChoicesFood(birthday.getFoodMenu());
                    birthday.convertChoicesBeverage(birthday.getBeverageMenu());

                    Planner reunion = new Planner("The Reunion Package", 100, "2", "3", "2");
                    reunion.convertChoices(reunion.getBandName());
                    reunion.convertChoicesFood(reunion.getFoodMenu());
                    reunion.convertChoicesBeverage(reunion.getBeverageMenu());

                    System.out.println("We have three packages to choose from. Here they are: ");
                    System.out.println("#############################  PACKAGES  ########################");
                    System.out.println(wedding.getNameofPartyPlanner() + " for up to " + wedding.getNumberOfGuests()  + " guests. Menu: " + wedding.getFoodMenu() + " | Beverage Service: " + wedding.getBeverageMenu());
                    System.out.println(birthday.getNameofPartyPlanner() + " for up to " + birthday.getNumberOfGuests()  + " guests. Menu: " + birthday.getFoodMenu() + " | Beverage Service: " + birthday.getBeverageMenu());
                    System.out.println(reunion.getNameofPartyPlanner() + " for up to " + reunion.getNumberOfGuests()  + " guests. Menu: " + reunion.getFoodMenu() + " | Beverage Service: " + reunion.getBeverageMenu());

                    System.out.println("Would you like to choose one of these packages to add to the parties you are planning? YES or NO");

                    if (bufferedReader.readLine().toUpperCase().equals("YES")) {
                        System.out.println("Make your choice: birthday, reunion or wedding");
                        if (bufferedReader.readLine().toUpperCase().equals("BIRTHDAY")) {
                            allParties.add(birthday);
                        }
                        else if (bufferedReader.readLine().toUpperCase().equals("REUNION")) {
                            allParties.add(reunion);
                        }
                        else if (bufferedReader.readLine().toUpperCase().equals("WEDDING")) {
                            allParties.add(wedding);
                        }
                    }
                    else
                    {
                        System.out.println("Oops! Sorry ... I don't think we have a package by that name!");
                    }
                    System.out.println("Great! Thanks for browsing. I have added that package to your list of parties. I'll take you back to the main menu now.");
                }
                else {
                    System.out.println("I'm sorry, we don't recognize your input");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
