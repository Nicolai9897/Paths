package no.ntnu.idatg2001.paths.utility;

import no.ntnu.idatg2001.paths.Link;
import no.ntnu.idatg2001.paths.Passage;
import no.ntnu.idatg2001.paths.Story;

import java.io.IOException;

public class FileHandlerTest {
  public static void main(String[] args) {
    String filename = "C:\\Users\\nicol\\OneDrive\\NTNU_BIDATA\\Semester_4\\IDATG2001\\paths\\src\\test\\resources\\FileHandlerTestDocument.txt"; // Angi banen til den faktiske filen her

    try {
      Story story = FileHandler.readStory(filename);
      System.out.println("Story title: " + story.getTitle());
      System.out.println("Number of passages: " + story.getPassages().size());

      // Skriv ut tittel og innhold for hver passasje
      for (Passage passage : story.getPassages()) {
        System.out.println("\nPassage title: " + passage.getTitle());
        System.out.println("Passage content: " + passage.getContent());

        System.out.println("Links in passage: " + passage.getLinks().size() + "\n");
        // Skriv ut tittel og målpassasje for hver link i passasjen
        for (Link link : passage.getLinks()) {
          System.out.println("Link title: " + link.getReference());
          System.out.println("Link target passage: " + story.getPassage(link));
       // }
      }
        System.out.println("--------------------");
      }
      //System.out.println("all the passages: " + story.getPassages());
    } catch (IOException e) {
      System.out.println("An error occurred while reading the story: " + e.getMessage());
    }
  }
}