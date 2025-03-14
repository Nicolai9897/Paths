package no.ntnu.idatg2001.paths.goals;

import java.util.HashSet;
import java.util.stream.Stream;
import no.ntnu.idatg2001.paths.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * The InventoryGoal class implements the Goal interface. Checks if the player
 * * possesses all the desired items.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class InventoryGoal implements Goal {

  private final List<String> mandatoryItems;

  /**
   * InventoryGoal defines a list of items that the player is expected to possess.
   *
   * @param mandatoryItems the mandatory items defines the expected items for the player to possess
   */
  public InventoryGoal(List<String> mandatoryItems) {
    this.mandatoryItems = new ArrayList<>(mandatoryItems);

  }

  /**
   * isFullfilled method checks if the player has gotten hold of one of the items that constitute
   * the inventory goal
   * @param player the player
   * @return true if the player has gotten hold of a winning item, false if not.
   */
  @Override
  public boolean isFulfilled(Player player) {
    return Stream.of(player)
        .map(Player::getInventory)
        .anyMatch(inventory -> new HashSet<>(inventory)
            .stream() .anyMatch(mandatoryItems::contains));
  }
}
