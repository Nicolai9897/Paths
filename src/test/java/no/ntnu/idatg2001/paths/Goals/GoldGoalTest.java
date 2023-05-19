package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for GoldGoal instance
 */
public class GoldGoalTest {

    GoldGoal goldGoal;
    Player player;

    /**
     * Create a GoldGoal instance
     */
    @BeforeEach
    public void createGoldGoal(){
        goldGoal = new GoldGoal(1000);
        player = new Player("Markus", 100, 20, 500);
    }

    /**
     * Test that the GoldGoal instance returns true when the player has a scored
     * the required amount of points
     */
    @Test
    void testIsFullfilled(){
        assertFalse(goldGoal.isFullfilled(player));
        player.addGold(600);
        assertTrue(goldGoal.isFullfilled(player));
    }


}
