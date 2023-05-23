package no.ntnu.idatg2001.paths.goals;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * The interface Goal. Makes it possible to check whether the player
 * has achieved the given goals.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public interface Goal {

  /**
   * isFullfilled method checks if the player has achieved a given goal.
   *
   * @param player the player
   * @return the boolean false/true based on whether the player has achieved
   * a goal or not.
   */
  boolean isFulfilled(Player player);
}
