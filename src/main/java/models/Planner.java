package models;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Guest on 8/4/17.
 */
public class Planner {

    private String nameofPartyPlanner;
    private int numberOfGuests;
    private String bandName;
    private String foodMenu;
    private String beverageMenu;
    private int totalPrice;

    public Planner(String nameofParty, int numberOfGuests, String bandName, String foodMenu, String beverageMenu) {
        this.nameofPartyPlanner = nameofParty;
        this.numberOfGuests = numberOfGuests;
        this.bandName = bandName;
        this.foodMenu = foodMenu;
        this.beverageMenu = beverageMenu;
        this.totalPrice = 0;
    }

    public String getBandName() {
        return bandName;
    }

    public String getNameofParty() {
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
        }
        if (bandName.equals("1")) {
            bandPrice = 2000;
        } else if (bandName.equals("2")) {
            bandPrice = 3000;
        } else if (bandName.equals("3")) {
            bandPrice = 4000;
        }
        if (beverageMenu.equals("1")) {
            beveragePrice = numberOfGuests * 5;
        } else if (beverageMenu.equals("2")) {
            beveragePrice = numberOfGuests * 12;
        } else if (beverageMenu.equals("3")) {
            beveragePrice = numberOfGuests * 35;
        }

        totalPrice = ((numberOfGuests * 10) + foodPrice + bandPrice + beveragePrice);
        return totalPrice;
    }

    public int couponGenerator (int totalPrice, String numberOfGuests, String bandName, String foodMenu) {

        int numberOfGuestsDiscount = (Integer.parseInt(numberOfGuests))*100;
        int bandNameDiscountDiscount = (Integer.parseInt(bandName))*100;
        int foodMenuDiscountDiscount = (Integer.parseInt(foodMenu))*100;
        return totalPrice = (totalPrice -= (numberOfGuestsDiscount + bandNameDiscountDiscount + foodMenuDiscountDiscount));
    }

}

