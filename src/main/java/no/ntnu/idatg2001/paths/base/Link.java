package no.ntnu.idatg2001.paths.base;

import java.util.ArrayList;
import no.ntnu.idatg2001.paths.actions.Action;

import java.util.List;
import java.util.Objects;

/**
 * Link is a class to go from one passage to
 *
 * @author Nicolai Olsen & Anders Brunsberg Mariendal
 * @version 1.0-SNAPSHOT
 */
public class Link {

  private final String text;
  private final String reference;
  private List<Action> actions;

  /**
   * Instantiates a new Link to go from one passage to another.
   *
   * @param text      Descriptive text indicating an action or a choice. the visible part for the player
   * @param reference the reference to the passage to go to
   */
  public Link(String text, String reference) {
    this.text = text;
    this.reference = reference;
    this.actions = new ArrayList<>();
  }

  /**
   * Getter for the descriptive text.
   *
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * Getter for the title of the passage to reference.
   *
   * @return the reference
   */
  public String getReference() {
    return reference;
  }


  /**
   * Getter for the lists of objects the player can use.
   *
   * @return the action
   */
  public List<Action> getActions() {
    return actions;
  }

  /**
   * Add an object to the players inventory.
   *
   * @param actionList the actions to add
   */
  public void addAction(List<Action> actionList) {
    this.actions.addAll(actionList);
  }

  @Override
  public String toString() {
    return "Link{" +
        "text='" + text + '\'' +
        ", reference='" + reference + '\'' +
        ", action=" + actions +
        '}';
  }

  /**
   * Equals method for the Link class.
   *
   * @param o the object
   * @return true if the objects are equal, false if not
   */
  @Override
  public boolean equals(Object o) {
      if (this == o) {
          return true;
      }
      if (o == null || getClass() != o.getClass()) {
          return false;
      }
    Link link = (Link) o;
    return reference.equals(link.reference);
  }

  /**
   * Hashcode method for the Link class.
   *
   * @return the hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(reference);
  }
}
