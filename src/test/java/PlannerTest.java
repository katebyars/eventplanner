import models.Planner;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/4/17.
 */
public class PlannerTest {

    @Test
    public void newPlanner_Instantiate() {
        Planner planner = new Planner("Kate's Party", 30, "Jimmy and the Developers","0", "0");
        assertEquals(true, planner instanceof Planner);
    }

    @Test
    public void newPlanner_parametersExist() {
        Planner planner = new Planner ("Kate's Party", 30, "Jimmy and the Developers","0", "0");
        assertEquals("Kate's Party", planner.getNameofParty());
    }
    @Test
    public void newPlanner_priceCalculatorCalculatesCorrectly_int (){
        Planner planner = new Planner ("Kate's Party", 30, "Jimmy and the Developers","0", "0");
        assertEquals(2350, planner.calculatePartyPrice(10, "1", "1", "1"));
    }
    @Test
    public void newPlanner_couponFor150GuestsOrMore_newPrice(){
        Planner planner = new Planner("Kate's Party", 30, "Jimmy and the Developers","0", "0");
        assertEquals("", planner.couponFor150GuestsOrMore(2350, 150));

    }

}