import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Random;
import models.Planner;

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

                   planner.couponVerify(coupon);

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
                    String beverageString = "";
                    String bandString = "";
                    String foodString = "";
                    System.out.println("Alright! Let's plan your party. But first, what is your name?");
                    String nameofPartyPlanner = bufferedReader.readLine();

                    System.out.println("One more question : How many people will attend your party? We'll do the rest!");
                    int numberOfGuests = Integer.parseInt(bufferedReader.readLine());

                    Planner tempPlanner = new Planner(nameofPartyPlanner, numberOfGuests, bandString, foodString, beverageString);

                    int randomNumber = tempPlanner.randomNumber(4);
                    beverageString = tempPlanner.beverageNamePicker(randomNumber);
                    bandString = tempPlanner.bandNamePicker(randomNumber);
                    foodString = tempPlanner.foodNamePicker(randomNumber);
                    int price = tempPlanner.reverseStringstoNumbersPricing(bandString, foodString, beverageString, numberOfGuests);

                    System.out.println("Here is your band: " + bandString);
                    System.out.println("Here is your food: " + foodString);
                    System.out.println("Here is your beverage selection: " + beverageString);
                    System.out.println("This party will cost: $" + price);

                    System.out.println("Do you want to add this cool and totally random party to your list of parties? YES or NO?");
                        if (bufferedReader.readLine().toUpperCase().equals("YES")) {
                            Planner realPlanner = new Planner (nameofPartyPlanner, numberOfGuests, bandString, foodString, beverageString);
                            int realPrice = realPlanner.reverseStringstoNumbersPricing(bandString, foodString, beverageString, numberOfGuests);
                            realPrice = realPlanner.getTotalPrice();
                            allParties.add(realPlanner);
                            System.out.println("#############################  Your party has been added! The details are below!  ########################");
                            System.out.println("The party planner: " + realPlanner.getNameofPartyPlanner());
                            System.out.println("The number of guests: " + realPlanner.getNumberOfGuests());
                            System.out.println("The band name: " + realPlanner.getBandName());
                            System.out.println("The food menu: " + realPlanner.getFoodMenu());
                            System.out.println("The beverage choice: " + realPlanner.getBeverageMenu());
                            System.out.println("Total cost: $" + realPlanner.getTotalPrice());
                        }
                        else{
                            System.out.println("Ok! No worries! What would you like to do next?");
                            programRunning = true;
                        }
                }
                else if (navigationChoice.toUpperCase().equals("BROWSE PACKAGES")){

                    System.out.println("We have three packages to choose from. They are discounted by 25% upon adding to your Parties List. A great deal! Here they are: ");
                    System.out.println("#############################  PACKAGES  ########################");
                    System.out.println("The Wedding package features up to 200 guests with 'You're the Project playing all night long! Deluxe International buffet and an Unlimited Well Bar for the evening.");
                    System.out.println("The Birthday package features up to 30 guests and the music of 'Perry and the Developers'. Deluxe International Buffet with Unlimited Bar Well drinks for the night!");
                    System.out.println("The reunion package is for up to 100 people with the music of 'Resubmit for Indentation. Backyard Barbeque is served with wine and beer.");


                    System.out.println("Would you like to choose one of these packages to add to the parties you are planning? YES or NO");

                    if (bufferedReader.readLine().toUpperCase().equals("YES")) {
                        System.out.println("Make your choice: birthday, reunion or wedding");
                        if (bufferedReader.readLine().toUpperCase().equals("BIRTHDAY")) {
                            Planner birthday = new Planner ("The Birthday Package", 30, "1", "1", "3");
                            System.out.println("Great! The discounted birthday package total is" + birthday.discountedPackagePrice(birthday.getNumberOfGuests(), birthday.getFoodMenu(), birthday.getBandName(), birthday.getBeverageMenu()));
                            birthday.convertChoices(birthday.getBandName());
                            birthday.convertChoicesFood(birthday.getFoodMenu());
                            birthday.convertChoicesBeverage(birthday.getBeverageMenu());
                            allParties.add(birthday);
                        }
                        else if (bufferedReader.readLine().toUpperCase().equals("REUNION")) {
                            Planner reunion = new Planner("The Reunion Package", 100, "3", "3", "2");
                            System.out.println("Great! The discounted birthday package total is" + reunion.discountedPackagePrice(reunion.getNumberOfGuests(), reunion.getFoodMenu(), reunion.getBandName(), reunion.getBeverageMenu()));
                            reunion.convertChoices(reunion.getBandName());
                            reunion.convertChoicesFood(reunion.getFoodMenu());
                            reunion.convertChoicesBeverage(reunion.getBeverageMenu());
                            allParties.add(reunion);

                        }
                        else if (bufferedReader.readLine().toUpperCase().equals("WEDDING")) {
                            Planner wedding = new Planner("The Wedding Package", 200, "2", "1", "3");
                            System.out.println("Great! The discounted birthday package total is" + wedding.discountedPackagePrice(wedding.getNumberOfGuests(), wedding.getFoodMenu(), wedding.getBandName(), wedding.getBeverageMenu()));
                            wedding.convertChoices(wedding.getBandName());
                            wedding.convertChoicesFood(wedding.getFoodMenu());
                            wedding.convertChoicesBeverage(wedding.getBeverageMenu());
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
