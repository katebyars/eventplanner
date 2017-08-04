import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guest on 8/4/17.
 */
public class PlannerTest {

    @Test
    public void newPlanner_Instantiate() {
        Planner planner = new Planner("Kate's Party");
        assertEquals(true, planner instanceof Planner);
    }
}