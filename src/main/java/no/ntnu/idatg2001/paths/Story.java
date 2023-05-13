package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Story.
 *
 * @author Nicolai Olsen & Anders Brunsberg Mariendal
 * @version 1.0-SNAPSHOT
 */
public class Story {

  private String title;
  private HashMap<Link, Passage> passages;
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
    this.passages = new HashMap<>();
    this.passageCollection = passages.values();
    addPassage(openingPassage);
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
Up   */
  public void addPassage(Passage passage) {
    Link link = new Link(passage.getTitle(), passage.getContent());
    passages.put(link, passage);
    passage.addLink(link);
  }

  /**
   * Get passage passage.
   *
   * @param link the link
   * @return the passage
   */
  public Passage getPassage(Link link) {
    return passages.get(link);
  }
/*
    for (Passage passage : passages.values()) {
      if (passage.getLinks().contains(link)) {
        return passage;
      }
    }
    return null;
  }*/

  /**
   * Get passages collection.
   *
   * @return the collection
   */
  public Collection<Passage> getPassages() {
    return new ArrayList<>(passages.values());
  }


  /**
   * Removes a given passages, if there are no other passages linked to it.
   *
   * @param link to the passage to remove
   */
  public void removePassage(Link link) {
    if (passages.containsKey(link)) {
      boolean canRemove = passages.values().stream()
          .noneMatch(passage -> passage.getLinks().contains(link));
      if (canRemove) {
        passages.remove(link);
      } else {
        throw new IllegalArgumentException("Cannot remove passage with links");
      }
    }
  }

  /**
   * Gets broken links.
   *
   * @return the list of broken links
   */
  public List<Link> getBrokenLinks() {
    return passages.keySet().stream()
        .filter(link -> !passages.containsKey(link))
        .toList();
  }
}
