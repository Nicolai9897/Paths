package no.ntnu.idatg2001.paths.base;

import no.ntnu.idatg2001.paths.Goals.*;
import java.util.List;

import no.ntnu.idatg2001.paths.Player.Player;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

public class Game {
  private final Player player;
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

  public Player getPlayer() {
    return player;
  }

  public Story getStory() {
    return story;
  }

  /**
   *
   * @return
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


}


