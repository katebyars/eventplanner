import models.Planner;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/4/17.
 */
public class PlannerTest {

    @Test
    public void newPlanner_Instantiate() {
        Planner planner = new Planner("Kate's Party", 10, "1","1", "1");
        assertEquals(true, planner instanceof Planner);
    }

    @Test
    public void newPlanner_parametersExist() {
        Planner planner = new Planner ("Kate's Party", 10, "Jimmy and the Developers","1", "1");
        assertEquals("Kate's Party", planner.getNameofPartyPlanner());
    }

    @Test
    public void newPlanner_priceCalculatorCalculatesCorrectly_int (){
        Planner planner = new Planner ("Kate's Party", 10, "1","1", "1");
        assertEquals(2350, planner.calculatePartyPrice(10, "1", "1", "1"));
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

}