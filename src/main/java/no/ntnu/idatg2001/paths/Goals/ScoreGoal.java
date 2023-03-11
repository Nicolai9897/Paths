package no.ntnu.idatg2001.paths.Goals;

import no.ntnu.idatg2001.paths.Player;

public class ScoreGoal implements Goal {

  private int minimumPoints;

  public int scoreGoal(int minimumPoints) {
    return minimumPoints;
  }

  @Override
  public boolean isFullfilled(Player player) {
    return false;
  }
}
