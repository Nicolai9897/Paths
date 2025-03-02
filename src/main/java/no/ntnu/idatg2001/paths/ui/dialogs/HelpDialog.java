package no.ntnu.idatg2001.paths.ui.dialogs;

import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Class for the help dialog.
 *
 * @author Candidate nr. 10029 & Candidate nr. 10023
 * @version 1.0-SNAPSHOT
 */
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
