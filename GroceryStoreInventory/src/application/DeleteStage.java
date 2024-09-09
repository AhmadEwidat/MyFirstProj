package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DeleteStage extends ModifyStage {
	private Button b;
	private DeleteEvent deleteEvent;

	public DeleteStage() {
		// create a delete button and set it on action and then add it to hBox h6
		b = new Button("Delete");
		deleteEvent = new DeleteEvent();
		b.setOnAction(deleteEvent);
		getH6().getChildren().remove(0);
		getH6().getChildren().add(0, b);
	    getPrimaryStage().setTitle("Delete Item");

	}

	class DeleteEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			try {
				// call the DeleteItem method after the delete button is pressed
				if (getT4().isVisible() == true) {

					getInventory().DeleteItem(getT4().getText(), getT1().getText());
					getMassegeLabel().setText(getInventory().getMassegeLabel().getText());
				} else if (getT4().isVisible() == false) {
					getInventory().DeleteItem(getT1().getText());
					getMassegeLabel().setText(getInventory().getMassegeLabel().getText());
				}

			} catch (NumberFormatException numberFormatException) {
				getMassegeLabel().setText(numberFormatException.getMessage());

			}

		}
	}
}
