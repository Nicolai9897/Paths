package no.ntnu.idatg2001.paths.ui.dialogs;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import no.ntnu.idatg2001.paths.Player;
import no.ntnu.idatg2001.paths.PlayerBuilder;
import java.util.Optional;

public class EditPlayerDialog extends Dialog<ButtonType> {

  private GridPane grid = new GridPane();
  private Label nameLabel = new Label("Name");
  private TextField nameField = new TextField();
  private Label healthLabel = new Label("Health");
  private TextField healthField = new TextField();
  private Label goldLabel = new Label("Gold");
  private TextField goldField = new TextField();


  public EditPlayerDialog() {
    super();
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
        PlayerBuilder builder = new PlayerBuilder()
                .withName(nameField.getText())
                .withHealth(Integer.parseInt(healthField.getText()))
                .withGold(Integer.parseInt(goldField.getText()));

        return builder.build();
      }
      return null;
    });

    Optional<Player> result = dialog.showAndWait();
    return result;
  }

}
