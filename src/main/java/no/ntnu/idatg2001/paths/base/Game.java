package no.ntnu.idatg2001.paths.base;

import no.ntnu.idatg2001.paths.goals.*;

import java.util.ArrayList;
import java.util.List;

import no.ntnu.idatg2001.paths.player.Player;

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

  public Game() {
    this(null, null, new ArrayList<>());
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

  public void setPlayer(Player player){
      this.player = player;
  }

  public void setStory(Story story) {
    this.story = story;
  }


}


