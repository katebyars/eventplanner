import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/4/17.
 */
public class PlannerTest {

    @Test
    public void newPlanner_Instantiate() {
        Planner planner = new Planner("Kate's Party", 30, "Jimmy and the Developers");
        assertEquals(true, planner instanceof Planner);
    }

    @Test
    public void newPlanner_parametersExist() {
        Planner planner = new Planner ("Kate's Party", 30, "Jimmy and the Developers");
        assertEquals("Kate's Party", planner.getNameofParty());
    }
    @Test
    public void newPlanner_priceCalculatorCalculatesCorrectly_int (){
        Planner planner = new Planner ("Kate's Party", 30, "Jimmy and the Developers");
        assertEquals(1, planner.calculatePartyPrice(10, "1", "1", "1"));
    }
}