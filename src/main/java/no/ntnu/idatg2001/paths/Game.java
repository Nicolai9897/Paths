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
        return Story.getOpeningPassage();
    }

    public Passage Go(Link link) {
        if (passage.getLink().contains(link.getReference())) {
            ;
        }
    }
}

