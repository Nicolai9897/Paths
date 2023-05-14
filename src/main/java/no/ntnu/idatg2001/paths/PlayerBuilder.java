package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import java.util.List;

public class PlayerBuilder {
  private String name;
  private int health;
  private int score;
  private int gold;

    /**
     * Instantiates a new Player builder.
     */
  public PlayerBuilder() {

    /* Example on how to use the builder:
     *
     *
    Player player = new PlayerBuilder()
        .withName("John")
        .withHealth(100)
        .withScore(500)
        .withGold(50)
        .addToInventory("Sword")
        .addToInventory("Shield");
     */



    // Set default values
    this.name = "";
    this.health = 0;
    this.score = 0;
    this.gold = 0;
  }

  /**
   * Give name to the character.
   * @param name the name of the character
   * @return the player builder
   */
  public PlayerBuilder withName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set the players starting health.
   * @param health the starting health of the player
   * @return the player builder
   */
  public PlayerBuilder withHealth(int health) {
    this.health = health;
    return this;
  }

  /**
   * Set the players starting score.
   * @param score the starting score of the player
   * @return the player builder
   */
  public PlayerBuilder withScore(int score) {
    this.score = score;
    return this;
  }


  /**
   * Set the players starting gold amount.
   * @param gold the starting gold amount of the player
   * @return the player builder
   */
  public PlayerBuilder withGold(int gold) {
    this.gold = gold;
    return this;
  }


  /**
   * Build the player.
   * @return the player
   */
  public Player build() {
    return new Player(name, health, score, gold);
  }
}
