package no.ntnu.idatg2001.paths.Actions;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldActionTest {
    GoldAction goldAction;
    Player player;

    @BeforeEach
    public void createGoldAction(){

        player = new Player("Markus", 100, 20, 50);
    }

    @Test
    void testExecute(){
        goldAction = new GoldAction(100);
        goldAction.execute(player);
        assertEquals(150, player.getGold());
    }

    @Test
    void testExecuteNegative(){
        goldAction = new GoldAction(-10);
        goldAction.execute(player);
        assertEquals(40, player.getGold());
    }
}


