package no.ntnu.idatg2001.paths;

import java.util.List;
import java.util.Objects;

/**
 * Link is a class to go from one passage to
 * @author Nicolai Olsen
 * @version 1.0-SNAPSHOT
 */
public class Link {

    private String text;
    private String reference;
    private List<Action> action;

    /**
     * Instantiates a new Link to go from one passage to another.
     *
     * @param text      the text
     * @param reference the reference
     */
    public Link(String text, String reference) {
        this.text = text;
        this.reference = reference;
    }

    /**
     * Getter for the descriptive text.
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * Getter for the title of the passage to reference.
     * @return the reference
     */
    public String getReference() {
        return reference;
    }


    /**
     * Getter for the lists of objects the player can use.
     * @return the action
     */
    public List<Action> getAction() {
        return action;
    }

    /**
     * Add an object to the players inventory.
     * @param action the action
     */
    public void addAction(List<Action> action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Link{" +
                "text='" + text + '\'' +
                ", reference='" + reference + '\'' +
                ", action=" + action +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return text.equals(link.text) && reference.equals(link.reference) && action.equals(link.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, reference, action);
    }
}
