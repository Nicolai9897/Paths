package no.ntnu.idatg2001.paths;

import java.util.List;
import java.util.Objects;


/**
 * The type Passage.
 *
 * @author Nicolai Olsen & Anders Brunsberg Mariendal
 * @version 1.0-SNAPSHOT
 */
public class Passage {
  private String title;
  private String content;
  private List<Link> linkList;

  /**
   * Instantiates a new Passage.
   *
   * @param title   an explanation and an identification for the passage
   * @param content the content to show user. typically, a story, or some dialog
   */
  public Passage(String title, String content) {
    this.title = title;
    this.content = content;

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
   * Gets content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Add link boolean.
   *
   * @param newLink the link to add
   */
  public void addLink(Link newLink) {
    linkList.add(newLink);
  }

  /**
   * Gets link.
   *
   * @return the link
   */
  public List<Link> getLinks() {
    return linkList;
  }

  /**
   * Has link boolean.
   *
   * @return the boolean
   */
  public boolean hasLink() {
    return !linkList.isEmpty();
  }

  @Override
  public String toString() {
    return "Passage{" +
        "title='" + title + '\'' +
        ", content='" + content + '\'' +
        ", link=" + linkList +
        '}';
  }

  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Passage passage = (Passage) o;
    return title.equals(passage.title) && content.equals(passage.content) &&
        linkList.equals(passage.linkList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, content, linkList);
  }
}