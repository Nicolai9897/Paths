package no.ntnu.idatg2001.paths.Goals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import no.ntnu.idatg2001.paths.Player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for ScoreGoal instance
 */
public class ScoreGoalTest {

        ScoreGoal scoreGoal;
        Player player;

        /**
         * Create a ScoreGoal instance
         */
        @BeforeEach
        public void createScoreGoal(){
            scoreGoal = new ScoreGoal(100);
            player = new Player("Markus", 100, 20, 50);
        }

        /**
         * Test that the ScoreGoal instance returns true when the player has a scored
         * the required amount of points
         */
        @Test
        void testIsFullfilled(){
          assertFalse(scoreGoal.isFullfilled(player));
            player.addScore(100);
          assertTrue(scoreGoal.isFullfilled(player));
        }
}
