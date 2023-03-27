package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HealthGoalTest {

        HealthGoal healthGoal;
        Player player;

        @BeforeEach
        public void createHealthGoal(){
            healthGoal = new HealthGoal(0);
            player = new Player("Markus", 100, 20, 50);
        }

        @Test
        void testIsFullfilled(){
            assertEquals(false, healthGoal.isFullfilled(player));
            player.addHealth(-100);
            assertEquals(true, healthGoal.isFullfilled(player));
        }
  
}
