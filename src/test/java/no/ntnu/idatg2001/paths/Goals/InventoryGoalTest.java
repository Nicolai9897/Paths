package no.ntnu.idatg2001.paths.Goals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryGoalTest {
  private List<String> mandatoryItems;
  private InventoryGoal inventoryGoal;
  private List<String> playerInventory;

  @BeforeEach
  void createInventories() {
    inventoryGoal = new InventoryGoal(mandatoryItems);
    mandatoryItems = new ArrayList<>();
    playerInventory = new ArrayList<>();
    mandatoryItems.add(0, "Elder wand");
    mandatoryItems.add(1, "Twisted Bow");
    mandatoryItems.add(2, "Excalibur");
    mandatoryItems.add(3, "Merlin's beard");
    mandatoryItems.add(4, "Ancestral hat");
    mandatoryItems.add(5, "Primordial boots");

    playerInventory.add(3, "Elder wand");
    playerInventory.add(5, "Twisted Bow");
    playerInventory.add(2, "Excalibur");
    playerInventory.add(0, "Merlin's beard");
    playerInventory.add(4, "Mystic hat");
    playerInventory.add(1, "Dragon boots");
  }
}
