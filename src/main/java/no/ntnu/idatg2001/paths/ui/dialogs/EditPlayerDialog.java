package no.ntnu.idatg2001.paths.ui.dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import no.ntnu.idatg2001.paths.player.Player;
import no.ntnu.idatg2001.paths.player.PlayerBuilder;
import no.ntnu.idatg2001.paths.ui.controllers.EditPlayerController;
import java.util.Objects;
import java.util.Optional;

public class EditPlayerDialog extends Dialog<ButtonType> {

  private final EditPlayerController controller;

  private final GridPane grid = new GridPane();
  private final Label nameLabel = new Label("Name");
  private final TextField nameField = new TextField();
  private final Label healthLabel = new Label("Health");
  private final TextField healthField = new TextField();
  private final Label goldLabel = new Label("Gold");
  private final TextField goldField = new TextField();


  public EditPlayerDialog(EditPlayerController controller) {
    super();
    this.controller = controller;
  }

  public Optional<Player> showDialog() {
    Dialog<Player> dialog = new Dialog<>();
    dialog.setTitle("New Player");
    dialog.setHeaderText("Enter player details");

    grid.add(nameLabel, 1, 1);
    grid.add(nameField, 1, 2);
    grid.add(healthLabel, 1, 3);
    grid.add(healthField, 1, 4);
    grid.add(goldLabel, 1, 5);
    grid.add(goldField, 1, 6);
    dialog.getDialogPane().setContent(grid);

    ButtonType buttonTypeOk = new ButtonType("Edit", ButtonBar.ButtonData.OK_DONE);
    ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
    dialog.getDialogPane().getButtonTypes().addAll(buttonTypeOk,buttonTypeCancel);

    dialog.setResultConverter(b -> {
      if (b == buttonTypeOk) {
        String healthText = healthField.getText();
        String goldText = goldField.getText();
        if (Objects.equals(healthText, "") || !healthText.matches("\\d+") || !goldText.matches("\\d+")) {
          Alert alert = new Alert(Alert.AlertType.ERROR, "You must enter a name, and health and gold must be numeric!", ButtonType.OK);
          alert.showAndWait();
          return null;
        }

        int health = Integer.parseInt(healthText);
        int gold = Integer.parseInt(goldText);

        PlayerBuilder builder = new PlayerBuilder()
                .withName(nameField.getText())
                .withHealth(health)
                .withGold(gold);

        return builder.build();
      }
      return null;
    });

    Optional<Player> result = dialog.showAndWait();
    result.ifPresent(player -> controller.receivePlayerDetails(result.get()));

    return result;
  }

}
