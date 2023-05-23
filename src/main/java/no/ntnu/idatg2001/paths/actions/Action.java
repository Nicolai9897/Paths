package no.ntnu.idatg2001.paths.actions;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * The interface Action. Handles all the actions that can affect a players
 * state
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 */
public interface Action {

  /**
   * Execute the wanted action on the player to alter their state.
   *
   * @param player the player
   */
  public void execute(Player player);


}
