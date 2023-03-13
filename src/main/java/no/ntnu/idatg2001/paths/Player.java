package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for representing the player
 * and attributes that will affect the game for the player.
 *
 * @author Nicolai Olsen & Anders Brunsberg Mariendal
 * @version 1.0-SNAPSHOT
 */
public class Player {
  private final String name;
  private int health;
  private int score;
  private int gold;
  private List<String> inventory;

  /**
   * Constructor for the player class.
   *
   * @param name the name
   */
  public Player(String name, int health, int score, int gold) {
    this.name = name;
    this.health = health;
    this.score = score;
    this.gold = gold;
    this.inventory = new ArrayList<>();
  }

  /**
   * Sets the health of the player.
   *
   * @param health the health
   */
  public void addHealth(int health) {
    this.health += health;
  }

  /**
   * Sets the score for the player.
   *
   * @param score the score
   */
  public void addScore(int score) {
    this.score += score;
  }

  /**
   * Sets the amount of gold that the player carries.
   *
   * @param gold the gold
   */
  public void addGold(int gold) {
    this.gold += gold;
  }

  /**
   * method for adding items to the players inventory.
   *
   * @param item the inventory
   */
  public void addToInventory(String item) {
    inventory.add(item);
  }

  /**
   * method for getting the name of the player.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * method for getting the health of the player.
   *
   * @return the health
   */
  public int getHealth() {
    return health;
  }

  /**
   * method for getting the players score.
   *
   * @return the score
   */
  public int getScore() {
    return score;
  }

  /**
   * method for getting the players gold.
   *
   * @return the gold
   */
  public int getGold() {
    return gold;
  }

  /**
   * method for getting the players inventory.
   *
   * @return the inventory
   */
  public List<String> getInventory() {
    return inventory;
  }
}
