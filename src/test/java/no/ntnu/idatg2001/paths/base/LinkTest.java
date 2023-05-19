package no.ntnu.idatg2001.paths.base;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatg2001.paths.Actions.Action;
import no.ntnu.idatg2001.paths.Actions.GoldAction;
import no.ntnu.idatg2001.paths.Actions.HealthAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for Link instance
 */
class LinkTest {

  Link link;

  /**
   * Create a new link
   */
  @BeforeEach
  public void createLink() {
    link = new Link("Go to forrest", "forrest");
  }

  /**
   * Test that the getText method returns the correct text
   */
  @Test
  void testGetText() {
    assertEquals("Go to forrest", link.getText());
  }

  /**
   * Test that the getReference method returns the correct reference
   */
  @Test
  void testGetReference() {
    assertEquals("forrest", link.getReference());
  }

  /**
   * Test that the getActions method returns the correct actions
   */
  @Test
  void testGetActions() {
    assertEquals(0, link.getActions().size());
  }

    /**
     * Test that the addAction method adds the correct amount of actions
     */
  @Test
  void testAddAction() {
    List<Action> actions = new ArrayList<>();
    actions.add(new GoldAction(10));
    actions.add(new HealthAction(-10));

    link.addAction(actions);
    assertEquals(2, link.getActions().size());
  }

    /**
     * Test that the addAction method adds the correct actions
     */
    @Test
    void testAddActionCorrect() {
        List<Action> actions = new ArrayList<>();
        Action goldAction = new GoldAction(10);
        Action healthAction = new HealthAction(-10);
        actions.add(goldAction);
        actions.add(healthAction);

        link.addAction(actions);
        assertTrue(link.getActions().contains(goldAction));
        assertTrue(link.getActions().contains(healthAction));
    }
}
