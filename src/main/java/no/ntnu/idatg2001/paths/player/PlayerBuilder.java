package no.ntnu.idatg2001.paths.player;

/**
 * PlayeBuilder class provides a builder for the Player object.
 * Utilizes the builder design pattern, allowing for a flexible creation of the Player object.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class PlayerBuilder {
  private String name;
  private int health;
  private int score;
  private int gold;

    /**
     * Instantiates a new Player builder.
     *
     */
  public PlayerBuilder() {

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
