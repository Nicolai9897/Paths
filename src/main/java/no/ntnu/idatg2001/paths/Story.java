package no.ntnu.idatg2001.paths;

import java.util.Collection;
import java.util.Map;

/**
 * The type Story.
 *
 * @author Nicolai Olsen & Anders Brunsberg Mariendal
 * @version 1.0-SNAPSHOT
 */
public class Story {

  private String title;
  private Map<Link, Passage> passages;
  private Passage opening;


  private Collection<Passage> passageCollection;


  /**
   * Instantiates a new Story.
   *
   * @param title          the title
   * @param openingPassage the opening passage
   */
  public Story(String title, Passage openingPassage) {
    this.title = title;
    this.opening = openingPassage;
  }

  /**
   * Gets title.
   *
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * Gets opening passage.
   *
   * @return the opening passage
   */
  public Passage getOpeningPassage() {
    return opening;
  }

  /**
   * Add passage passage.
   *
   * @param passage the passage
   * @return the passage
   */
  public Passage addPassage(Passage passage) {
    return passage;
  }

  /**
   * Get passage passage.
   *
   * @param link the link
   * @return the passage
   */
  public Passage getPassage(Link link) {
    return opening;
  }

  /**
   * Get passages collection.
   *
   * @return the collection
   */
  public Collection<Passage> getPassages() {
    return passageCollection;
  }

}
