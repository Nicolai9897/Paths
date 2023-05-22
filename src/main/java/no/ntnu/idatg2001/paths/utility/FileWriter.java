package no.ntnu.idatg2001.paths.utility;

import no.ntnu.idatg2001.paths.Actions.*;
import no.ntnu.idatg2001.paths.base.Link;
import no.ntnu.idatg2001.paths.base.Passage;
import no.ntnu.idatg2001.paths.base.Story;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileWriter {

    /**
     * Writes a story to a file.
     *
     * @param story
     * @param filename
     * @throws IOException
     */
    public static void writeStory(Story story, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new java.io.FileWriter(filename))) {
            writer.println(story.getTitle() + "\n");

            writePassage(story.getOpeningPassage(), writer);

            for (Passage passage : story.getPassages()) {
                if (!passage.getTitle().equals(story.getOpeningPassage().getTitle())) {
                    writePassage(passage, writer);
                }
            }
        }
    }


    /**
     * Get information about the passage fields, and then go into the link fields.
     *
     * @param passage the passage to write
     * @param writer  the writer to write to
     */
    private static void writePassage(Passage passage, PrintWriter writer) {
        writer.println(":: " + passage.getTitle());
        writer.println(passage.getContent());
        writeLink(passage, writer);
    }


    /**
     * Get information about the link fields, and then go into the action fields.
     *
     * @param passage the passage to write
     * @param writer  the writer to write to
     */
    private static void writeLink(Passage passage, PrintWriter writer) {
        for (Link link : passage.getLinks()) {
            writer.println("[" + link.getText() + "](" + link.getReference() + ")");
            List<Action> actions = link.getActions();
            for (Action action : actions) {
                try {
                    writeAction(action, writer);
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        }
        writer.println();
    }


    /**
     * Write the action to the file.
     *
     * @param action the actions to write
     * @param writer  the writer to write to
     * @throws NoSuchFieldException if the action field is not found
     */
    private static void writeAction(Action action, PrintWriter writer) throws NoSuchFieldException{

        String actionValue;

        switch (action.getClass().getSimpleName()) {
            case "HealthAction" -> {
                actionValue = String.valueOf(((HealthAction) action).getHealth());
                writer.println("{HEALTH}(" + actionValue + ")");
            }
            case "ScoreAction" -> {
                actionValue = String.valueOf(((ScoreAction) action).getPoints());
                writer.println("{SCORE}(" + actionValue + ")");
            }
            case "GoldAction" -> {
                actionValue = String.valueOf(((GoldAction) action).getGold());
                writer.println("{GOLD}(" + actionValue + ")");
            }
            case "InventoryAction" -> {
                actionValue = String.valueOf(((InventoryAction) action).getItem());
                writer.println("{INVENTORY}(" + actionValue + ")");
            }
            default -> throw new NoSuchFieldException("No such action");
        }

    }
}
