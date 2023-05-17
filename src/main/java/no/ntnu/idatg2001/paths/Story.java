package no.ntnu.idatg2001.paths;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;


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
   */
  public void addPassage(Passage passage) {
    passages.put(new Link(passage.getTitle(), passage.getTitle()), passage);
  }

  /**
   * Get passage passage.
   *
   * @param link the link
   * @return the passage
   */
  public Passage getPassage(Link link) {
    for (Map.Entry<Link, Passage> passage : passages.entrySet()) {
      if (passage.getKey().getReference().equalsIgnoreCase(link.getReference())) {
        return passage.getValue();
      }
    }
    return null;
  }

  /**
   * Get passages collection.
   *
   * @return the collection
   */
  public Collection<Passage> getPassages() {
    return new ArrayList<>(passages.values());
  }

  /**
   * Removes a given passage if there are no other passages linked to it.
   *
   * @param link the link to the passage to remove
   */
  public void removePassage(Link link) throws IllegalArgumentException {
    boolean hasLink = passages.values().stream()
        .anyMatch(passage -> passage.getLinks().contains(link));
    if (hasLink) {
      throw new IllegalArgumentException("Cannot remove passage with links");
    }
    passages.remove(link);
  }


  /**
   * Gets broken links.
   *
   * @return the list of broken links
   */
  public List<Link> getBrokenLinks() {
    return passages.values().stream()
        .flatMap(passage -> passage.getLinks().stream())
        .filter(link -> !passages.containsKey(link))
        .toList();
  }

}
