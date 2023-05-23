package no.ntnu.idatg2001.paths.ui.dialogs;

import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class HelpDialog extends Dialog<Void> {

    public HelpDialog(String infoText) {
        super();
        setTitle("About the application");
        setHeaderText("Information");
        Label infoLabel = new Label(infoText);
        infoLabel.setAlignment(Pos.CENTER);
        VBox infoBox = new VBox(infoLabel);
        infoBox.setAlignment(Pos.CENTER);
        getDialogPane().setContent(infoBox);
        getDialogPane().getButtonTypes().addAll(ButtonType.OK);
    }
}
