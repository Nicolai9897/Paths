package no.ntnu.idatg2001.paths.utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import no.ntnu.idatg2001.paths.Link;
import no.ntnu.idatg2001.paths.Passage;
import no.ntnu.idatg2001.paths.Story;

public class FileHandler {


    /**
     * Reads a story from a file and returns a story object.
     *
     * @param filename of the file to read from
     * @return The final story object
     * @throws IOException if the file is not found
     */
    public static Story readStory(String filename) throws IOException {
        Story story = null;
        String title;
        Passage newPassage;

        try (Scanner scanner = new Scanner(new File(filename))) {
            title = scanner.nextLine().trim();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // Check for passage start
                if (line.startsWith("::")) {
                    String passageTitle = line.substring(2).trim();
                    StringBuilder contentBuilder = new StringBuilder();
                    List<Link> links = new ArrayList<>();

                    // Read the passage content
                    while (scanner.hasNextLine() && !(line = scanner.nextLine().trim()).isEmpty()) {
                        if (line.startsWith("[")) {
                            // If link is found, add it to the list of links
                            String linkTitle = line.substring(1, line.indexOf("]"));
                            String linkPassage = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
                            links.add(new Link(linkTitle, linkPassage));
                        } else {
                            // if line is not a link, add the line to the content
                            contentBuilder.append(line);
                        }
                    }
                    // Create the new passage object and add the links
                    newPassage = new Passage(passageTitle, contentBuilder.toString());
                    for (Link link : links) {
                        newPassage.addLink(link);
                    }
                    // Add the passage to the story
                    if (story != null) {
                        story.addPassage(newPassage);
                    } else {
                        story = new Story(title, newPassage);
                    }
                }
            }
        }
        return story;
    }

    /**
     * Writes a story to a file.
     *
     * @param story
     * @param filename
     * @throws IOException
     */
    public static void writeStory(Story story, String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println(story.getTitle() + "\n");
            writer.println(story.getOpeningPassage().getTitle());
            writer.println(story.getOpeningPassage().getContent());

            for (Link link : story.getOpeningPassage().getLinks()) {
                writer.println("[" + link.getText() + "](" + link.getReference() + ")");
            }
            writer.println();

            for (Passage passage : story.getPassages()) {
                writer.println(":: " + passage.getTitle());
                writer.println(passage.getContent());

                for (Link link : passage.getLinks()) {
                    writer.println("[" + link.getText() + "](" + link.getReference() + ")");
                }
                writer.println();
            }
        }
    }
}

