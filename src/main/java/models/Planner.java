package models;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Planner {

    private String nameofPartyPlanner;
    private int numberOfGuests;
    private String bandName;
    private String foodMenu;
    private String beverageMenu;
    private int totalPrice;

    public Planner(String nameofPartyPlanner, int numberOfGuests, String bandName, String foodMenu, String beverageMenu) {
        this.nameofPartyPlanner = nameofPartyPlanner;
        this.numberOfGuests = numberOfGuests;
        this.bandName = bandName;
        this.foodMenu = foodMenu;
        this.beverageMenu = beverageMenu;
        this.totalPrice = 0;
    }

    public String getBandName() {
        return bandName;
    }

    public String getNameofPartyPlanner() {
        return nameofPartyPlanner;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getFoodMenu() {
        return foodMenu;
    }

    public String getBeverageMenu() {
        return beverageMenu;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public int reverseStringstoNumbersPricing(String bandName, String foodMenu, String beverageMenu, int numberOfGuests){

        int totalPrice = 0;
        int foodPrice = 0;
        int bandPrice = 0;
        int beveragePrice = 0;

        if (foodMenu.equals("Deluxe International")) {
            foodPrice = numberOfGuests * 20;
        } else if (foodMenu.equals("American Fusion Buffet")) {
            foodPrice = numberOfGuests * 30;
        } else if (foodMenu.equals("Backyard Barbeque")) {
            foodPrice = numberOfGuests * 40;
        } else if (foodMenu.equals("0")) {
            foodPrice = 0;
        }
        if (bandName.equals("Perry and the Developers")) {
            bandPrice = 2000;
        } else if (bandName.equals("You're the Project")) {
            bandPrice = 3000;
        } else if (bandName.equals("Resubmit for Indentation")) {
            bandPrice = 4000;
        } else if (bandName.equals("0")) {
            bandPrice = 0;
        }
        if (beverageMenu.equals("Soft Drinks")) {
            beveragePrice = numberOfGuests * 5;
        } else if (beverageMenu.equals("Beer and Wine")) {
            beveragePrice = numberOfGuests * 12;
        } else if (beverageMenu.equals("Full Well Bar")) {
            beveragePrice = numberOfGuests * 35;
        } else if (beverageMenu.equals("0")) {
            beveragePrice = 0;
        }

        totalPrice = ((numberOfGuests * 10) + foodPrice + bandPrice + beveragePrice);
        this.totalPrice = totalPrice;
        return this.totalPrice;
    }

    public int calculatePartyPrice(int numberOfGuests, String foodMenu, String bandName, String beverageMenu) {
        int totalPrice = 0;
        int foodPrice = 0;
        int bandPrice = 0;
        int beveragePrice = 0;

        if (foodMenu.equals("1")) {
            foodPrice = numberOfGuests * 20;
        } else if (foodMenu.equals("2")) {
            foodPrice = numberOfGuests * 30;
        } else if (foodMenu.equals("3")) {
            foodPrice = numberOfGuests * 40;
        } else if (foodMenu.equals("0")) {
            foodPrice = 0;
        }
        if (bandName.equals("1")) {
            bandPrice = 2000;
        } else if (bandName.equals("2")) {
            bandPrice = 3000;
        } else if (bandName.equals("3")) {
            bandPrice = 4000;
        } else if (bandName.equals("0")) {
        bandPrice = 0;
        }
        if (beverageMenu.equals("1")) {
            beveragePrice = numberOfGuests * 5;
        } else if (beverageMenu.equals("2")) {
            beveragePrice = numberOfGuests * 12;
        } else if (beverageMenu.equals("3")) {
            beveragePrice = numberOfGuests * 35;
        } else if (beverageMenu.equals("0")) {
            beveragePrice = 0;
        }

        totalPrice = ((numberOfGuests * 10) + foodPrice + bandPrice + beveragePrice);
        this.totalPrice = totalPrice;
        return this.totalPrice;
    }

    public int couponGenerator(int totalPrice, int numberOfGuests, String bandName, String foodMenu, String beverageMenu) {

        if (bandName.equals("Perry and the Developers") && beverageMenu.equals("Unlimited Full Well Bar")) {
            totalPrice -= 200;
        }
        else if (numberOfGuests >= 150 && bandName.equals("You're the Project")){
        totalPrice -= 100;
        }
        else if (bandName.equals("Resubmit for Indentation") && beverageMenu.equals("Unlimited Full Well Bar") && foodMenu.equals("Deluxe International")){
        totalPrice-=400;
        }
        else {
            totalPrice = totalPrice;
        }
        this.totalPrice = totalPrice;
        return this.totalPrice;
    }

    public String convertChoices(String bandName){
        if (bandName.equals("1")){
            this.bandName = "Perry and the Developers";
        }
        else if (bandName.equals("2")){
            this.bandName = "You're the Project";
        }
        else if (bandName.equals("3")){
            this.bandName= "Resubmit for Indentation";
        }
        else {
            this.bandName = "N/A";
        }
        return this.bandName;
    }
    public String convertChoicesFood(String foodMenu){
        if (foodMenu.equals("1")){
            this.foodMenu = "Deluxe International";
        }
        else if (foodMenu.equals("2")){
            this.foodMenu = "American Fusion Buffet";
        }
        else if (foodMenu.equals("3")){
            this.foodMenu= "Backyard Barbeque";
        }
        else {
            this.foodMenu = "N/A";
        }
        return this.foodMenu;
    }
    public String convertChoicesBeverage(String beverageMenu){
        if (beverageMenu.equals("1")){
            this.beverageMenu = "Soft Drinks";
        }
        else if (beverageMenu.equals("2")){
            this.beverageMenu = "Beer and Wine";
        }
        else if (beverageMenu.equals("3")){
            this.beverageMenu= "Unlimited Full Well Bar";
        }
        else {
            this.beverageMenu = "N/A";
        }
        return this.beverageMenu;
    }
    public int discountedPackagePrice(int numberOfGuests, String foodMenu, String bandName, String beverageMenu){
       int nonDiscountPrice = calculatePartyPrice(numberOfGuests, foodMenu, bandName, beverageMenu);
       int DiscountPrice = nonDiscountPrice - 100;
       return DiscountPrice;
    }

    public int randomNumber(int aNumber){
        Random generateRandomNumber = new Random();
        int aRandomNumber = generateRandomNumber.nextInt(aNumber);
        return aRandomNumber;
    }
    public String beverageNamePicker (int randomNumber) {
        String beverageString = "";
        switch (randomNumber) {
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
        return beverageString;
    }
    public String bandNamePicker (int randomNumber) {
        String bandString = "";
        switch (randomNumber) {
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
        return bandString;
    }

    public String foodeNamePicker (int randomNumber) {
        String foodString = "";
        switch (randomNumber) {
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
        return foodString;
    }
}

