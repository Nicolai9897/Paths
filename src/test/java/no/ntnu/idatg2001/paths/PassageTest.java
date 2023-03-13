package no.ntnu.idatg2001.paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassageTest {
  Passage passage;

  @BeforeEach
  public void createPassage() {
    passage = new Passage("cool passage", "this is a cool passage");
  }

  @Test
  void PassageTest() {
    assertEquals("cool passage", passage.getTitle());
  }
}
