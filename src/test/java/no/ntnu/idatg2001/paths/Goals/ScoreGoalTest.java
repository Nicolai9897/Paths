package no.ntnu.idatg2001.paths.Goals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import no.ntnu.idatg2001.paths.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreGoalTest {

        ScoreGoal scoreGoal;
        Player player;

        @BeforeEach
        public void createScoreGoal(){
            scoreGoal = new ScoreGoal(100);
            player = new Player("Markus", 100, 20, 50);
        }

        @Test
        void testIsFullfilled(){
            assertEquals(false, scoreGoal.isFullfilled(player));
            player.addScore(100);
            assertEquals(true, scoreGoal.isFullfilled(player));
        }
}
