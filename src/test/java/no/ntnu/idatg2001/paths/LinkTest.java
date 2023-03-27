package no.ntnu.idatg2001.paths;

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
    //test reference gettere
    assertEquals("forrest", link.getReference());
    }


}
