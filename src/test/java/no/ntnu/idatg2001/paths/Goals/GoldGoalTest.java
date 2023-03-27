package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoldGoalTest {

    GoldGoal goldGoal;
    Player player;

    @BeforeEach
    public void createGoldGoal(){
        goldGoal = new GoldGoal(100);
        player = new Player("Markus", 100, 20, 50);
    }

    @Test
    void testIsFullfilled(){
        assertEquals(false, goldGoal.isFullfilled(player));
        player.addGold(100);
        assertEquals(true, goldGoal.isFullfilled(player));
    }


}
