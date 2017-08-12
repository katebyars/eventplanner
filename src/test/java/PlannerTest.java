import models.Planner;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/4/17.
 */
public class PlannerTest {

    @Test
    public void newPlanner_Instantiates() {
        Planner planner = new Planner("Kate's Party", 10, "1","1", "1");
        assertEquals(true, planner instanceof Planner);
    }

    @Test
    public void newPlanner_parametersExist() {
        Planner planner = new Planner ("Kate's Party", 10, "Jimmy and the Developers","1", "1");
        assertEquals("Kate's Party", planner.getNameofPartyPlanner());
    }

    @Test
    public void allPartiesContainsParties_True(){
        Planner planner = new Planner ("Kate's Party", 10, "Jimmy and the Developers","1", "1");
        ArrayList <Planner> allParties = new ArrayList<>();
        allParties.add(planner);
        assertEquals(1, allParties.size());
    }

    @Test
    public void allPartiesContainsMoreThanOneParty_True () {
        Planner planner = new Planner ("Kate's Party", 10, "Jimmy and the Developers","1", "1");
        Planner otherPlanner = new Planner ("Kate's Party", 10, "Jimmy and the Developers","1", "1");
        ArrayList <Planner> allParties = new ArrayList<>();
        allParties.add(planner);
        allParties.add(otherPlanner);
        assertEquals(2, allParties.size());
    }

    @Test
    public void newPlanner_priceCalculatorCalculatesCorrectly_int (){
        Planner planner = new Planner ("Kate's Party", 10, "1","1", "1");
        assertEquals(2350, planner.calculatePartyPrice(10, "1", "1", "1"));
    }

    @Test public void calculatePriceWhenGivenStringNames_int() {
        Planner planner = new Planner ("Kate's Party", 10, "1", "1", "1");
        assertEquals(6500, planner.reverseStringstoNumbersPricing("Perry and the Developers", "American Fusion Buffet", "Soft Drinks", 100));
    }

    @Test
    public void newPlanner_changeBandChoiceToString_BandName(){
        Planner planner = new Planner ("Kate's Party", 10, "1","1", "1");
        assertEquals("Perry and the Developers", planner.convertChoices("1"));
    }

    @Test
    public void newPlanner_calculateCoupon_NewPrice(){
        Planner planner = new Planner ("Kate's Party", 10, "1","1", "1");
        assertEquals(1800, planner.couponGenerator(2000, 155, "Perry and the Developers", "Deluxe International", "Unlimited Full Well Bar"));
    }
    @Test
    public void newPlanner_calculateDiscountedPackagePrice(){
        Planner planner = new Planner ("Kate's Party", 10, "0","0", "0");
        assertEquals(900, planner.discountedPackagePrice(100, "0","0","0"));
    }
    @Test
    public void calculateRandomNumber_True() {
        Planner planner = new Planner ("Kate's Party", 10, "0","0", "0");
        int aNumber = planner.randomNumber(4);
        assertTrue(aNumber<5);
    }
    @Test
    public void randomlySelectABeverage_True() {
        Planner planner = new Planner ("Kate's Party", 10, "0","0", "0");
        int aNumber = planner.randomNumber(4);
        String aBeverage = planner.beverageNamePicker(aNumber);
//        assertEquals("Soft Drinks", aBeverage); //use this piece of code to see that actual results are random.
        assertTrue(aBeverage instanceof String);
    }
    @Test
    public void randomlySelectFood_True() {
        Planner planner = new Planner ("Kate's Party", 10, "0","0", "0");
        int aNumber = planner.randomNumber(4);
        String food = planner.foodNamePicker(aNumber);
        assertTrue(food instanceof String);
    }
    @Test
    public void randomlySelectBand_True() {
        Planner planner = new Planner ("Kate's Party", 10, "0","0", "0");
        int aNumber = planner.randomNumber(4);
        String band = planner.bandNamePicker(aNumber);
        assertTrue(band instanceof String);
    }

}