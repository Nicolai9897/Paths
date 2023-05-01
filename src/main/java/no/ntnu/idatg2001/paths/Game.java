package no.ntnu.idatg2001.paths;

import no.ntnu.idatg2001.paths.Goals.*;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.Passage;
import no.ntnu.idatg2001.paths.Story;

import java.util.ArrayList;
import java.util.List;

public class Game {
  private Player player;
  private Story story;
  private List<Goal> goals;

  private Passage passage;

  private Link link;

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
   * Go method checks if the link is valid and returns the passage the link leads to.
   * @param link
   * @return passage
   */
  public Passage Go(Link link) {

    List<Link> links = passage.getLinks();
    for (Link linkToCheck : links) {
      if (linkToCheck.equals(link)) {
        return story.getPassage(link);
      }
    }
    return null;
  }
}

