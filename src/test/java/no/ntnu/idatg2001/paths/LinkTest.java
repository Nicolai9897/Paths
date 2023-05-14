package no.ntnu.idatg2001.paths;

import java.util.ArrayList;
import java.util.List;
import no.ntnu.idatg2001.paths.Actions.Action;
import no.ntnu.idatg2001.paths.Actions.GoldAction;
import no.ntnu.idatg2001.paths.Actions.HealthAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkTest {

  Link link;

  @BeforeEach
  public void createLink() {
    link = new Link("Go to forrest", "forrest");
  }

  @Test
  void testLinkGetters() {
    //test text getter
    assertEquals("Go to forrest", link.getText());
    //test reference getters
    assertEquals("forrest", link.getReference());
    //test action getter
    assertEquals(0, link.getActions().size());
    }

  @Test
  void testAddAction() {
    List<Action> actions = new ArrayList<>();
    actions.add(new GoldAction(10));
    actions.add(new HealthAction(-10));

    link.addAction(actions);
    assertEquals(2, link.getActions().size());
  }
}
