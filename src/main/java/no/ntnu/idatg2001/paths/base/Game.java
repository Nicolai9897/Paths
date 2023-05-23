package no.ntnu.idatg2001.paths.base;

import no.ntnu.idatg2001.paths.goals.*;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.idatg2001.paths.player.Player;

/**
 * Game class is a facade that handles the different objects that encapsulates a game.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
public class Game {
  private Player player;
  private Story story;
  private List<Goal> goals;

  /**
   * Constructor for the game facade, made to limit the amount of coupling between the classes
   * when creating a game.
   * @param player
   * @param story
   * @param goals
   */
  public Game(Player player, Story story, List<Goal> goals) {
    this.player = player;
    this.story = story;
    this.goals = goals;
  }

  /**
   * Constructor for Game facade that without passed arguments.
   */
  public Game() {
    this(null, null, new ArrayList<>());
  }

  /**
   * Getter for the player in the game.
   * @return The player
   */
  public Player getPlayer() {
    return player;
  }

  /**
   * Getter for the story in the game.
   * @return The story
   */
  public Story getStory() {
    return story;
  }

  /**
   *Getter for the goals in the game.
   * @return List of goals
   */
  public List<Goal> getGoals() {
    return goals;
  }

  /**
   * begin method returns the opening passage of the story.
   * @return passage
   */
  public Passage begin() {
    return story.getOpeningPassage();
  }

  /**
   * returns the passage that matches the applicable link sent to the method
   */
  public Passage go(Link link) {
    return story.getPassage(link);
  }

  /**
   * Sets the player of the game.
   * @param player The new Player object for the game.
   */
  public void setPlayer(Player player){
      this.player = player;
  }

  /**
   * Sets the story of the game.
   * @param story The new Story object for the game.
   */
  public void setStory(Story story) {
    this.story = story;
  }


}


