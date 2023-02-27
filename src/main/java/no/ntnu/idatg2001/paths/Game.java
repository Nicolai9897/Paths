package no.ntnu.idatg2001.paths;

import no.ntnu.idatg2001.paths.Goals.Goal;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.Passage;
import no.ntnu.idatg2001.paths.Story;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private Story story;
    private ArrayList<Goal> goals;

    private Passage passage;

    private Link link;

    public Game(Player player, Story story, List<Goal> goals) {

    }

    public Player getPlayer() {
        return player;
    }

    public Story getStory() {
        return story;
    }

    public List<Goal> getGoals() {
        return goals;
    }

    public Passage begin() {
        return story.getOpeningPassage();
    }

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

