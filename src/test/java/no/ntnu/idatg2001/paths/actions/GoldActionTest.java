package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for GoldAction instance
 */
class GoldActionTest {
    GoldAction goldAction;
    Player player;

    /**
     * Create a player to execute the action on.
     */
    @BeforeEach
    public void createGoldAction(){

        player = new Player("Markus", 100, 20, 50);
    }

    /**
     * Test that the GoldAction instance adds the correct amount of gold to the player
     */
    @Test
    void testExecute(){
        goldAction = new GoldAction(100);
        goldAction.execute(player);
        assertEquals(150, player.getGold());
    }

    /**
     * Test that the GoldAction instance removes the correct amount of gold to the player
     */
    @Test
    void testExecuteNegative(){
        goldAction = new GoldAction(-10);
        goldAction.execute(player);
        assertEquals(40, player.getGold());
    }
}


