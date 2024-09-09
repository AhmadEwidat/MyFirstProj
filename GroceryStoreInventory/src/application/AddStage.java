package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

//class to create the Stage of add button
public class AddStage {

	private VBox v1, v2;
	private HBox h1, h2, h3, h4, h5, h6, h7;
	private Button b1, b2;
	private RadioButton r1, r2;
	private ToggleGroup group;
	private ShowBrandEvent show;
	private Stage primaryStage;
	private TextField t1, t2, t3, t4, t5;
	private Label l1, l2, l3, l4, l5, l6, massegeLabel;
	private GridPane p;
	private Scene s2;
	private Inventory inventory = new Inventory("inventory");

	public HBox getH7() {
		return h7;
	}

	public void setH7(HBox h7) {
		this.h7 = h7;
	}

	public Label getL6() {
		return l6;
	}

	public void setL6(Label l6) {
		this.l6 = l6;
	}

	public TextField getT5() {
		return t5;
	}

	public void setT5(TextField t5) {
		this.t5 = t5;
	}

	// getters and setters methods of attribute
	public Label getMassegeLabel() {
		return massegeLabel;
	}

	public void setMassegeLabel(Label massegeLabel) {
		this.massegeLabel = massegeLabel;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public HBox getH3() {
		return h3;
	}

	public void setH3(HBox h3) {
		this.h3 = h3;
	}

	public HBox getH4() {
		return h4;
	}

	public void setH4(HBox h4) {
		this.h4 = h4;
	}

	public HBox getH5() {
		return h5;
	}

	public void setH5(HBox h5) {
		this.h5 = h5;
	}

	public HBox getH6() {
		return h6;
	}

	public void setH6(HBox h6) {
		this.h6 = h6;
	}

	public VBox getV1() {
		return v1;
	}

	public void setV1(VBox v1) {
		this.v1 = v1;
	}

	public VBox getV2() {
		return v2;
	}

	public void setV2(VBox v2) {
		this.v2 = v2;
	}

	public HBox getH1() {
		return h1;
	}

	public void setH1(HBox h1) {
		this.h1 = h1;
	}

	public HBox getH2() {
		return h2;
	}

	public void setH2(HBox h2) {
		this.h2 = h2;
	}

	public Button getB1() {
		return b1;
	}

	public void setB1(Button b1) {
		this.b1 = b1;
	}

	public Button getB2() {
		return b2;
	}

	public void setB2(Button b2) {
		this.b2 = b2;
	}

	public RadioButton getR1() {
		return r1;
	}

	public void setR1(RadioButton r1) {
		this.r1 = r1;
	}

	public RadioButton getR2() {
		return r2;
	}

	public void setR2(RadioButton r2) {
		this.r2 = r2;
	}

	public ToggleGroup getGroup() {
		return group;
	}

	public void setGroup(ToggleGroup group) {
		this.group = group;
	}

	public ShowBrandEvent getShow() {
		return show;
	}

	public void setShow(ShowBrandEvent show) {
		this.show = show;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public TextField getT1() {
		return t1;
	}

	public void setT1(TextField t1) {
		this.t1 = t1;
	}

	public TextField getT2() {
		return t2;
	}

	public void setT2(TextField t2) {
		this.t2 = t2;
	}

	public TextField getT3() {
		return t3;
	}

	public void setT3(TextField t3) {
		this.t3 = t3;
	}

	public TextField getT4() {
		return t4;
	}

	public void setT4(TextField t4) {
		this.t4 = t4;
	}

	public Label getL1() {
		return l1;
	}

	public void setL1(Label l1) {
		this.l1 = l1;
	}

	public Label getL2() {
		return l2;
	}

	public void setL2(Label l2) {
		this.l2 = l2;
	}

	public Label getL3() {
		return l3;
	}

	public void setL3(Label l3) {
		this.l3 = l3;
	}

	public Label getL4() {
		return l4;
	}

	public void setL4(Label l4) {
		this.l4 = l4;
	}

	public Label getL5() {
		return l5;
	}

	public void setL5(Label l5) {
		this.l5 = l5;
	}

	public GridPane getP() {
		return p;
	}

	public void setP(GridPane p) {
		this.p = p;
	}

	public Scene getS2() {
		return s2;
	}

	public void setS2(Scene s2) {
		this.s2 = s2;
	}

	public AddStage() {

		primaryStage = new Stage(); // create a Stage
		massegeLabel = new Label(""); // create massage label and set Style it
		massegeLabel.setStyle("-fx-text-fill:Red;-fx-font-size:15;");
		show = new ShowBrandEvent();// create event show event
		// create 3 button (save,show,cancel) and set them on action
		b1 = new Button("save");
		b1.setOnAction(show);
		b2 = new Button("cancel");
		b2.setOnAction(show);
		// create a textFileds to enter (type,price,quantity,and brand)
		t1 = new TextField();
		t1.setPrefWidth(150);
		t2 = new TextField();
		t2.setPrefWidth(150);
		t3 = new TextField();
		t3.setPrefWidth(150);
		t4 = new TextField();
		t4.setPrefWidth(150);
		t5 = new TextField();
		t5.setPrefWidth(150);
		// create labels for radio button and text fields
		l1 = new Label("Brand");
		l1.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l2 = new Label("Type");
		l2.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l3 = new Label("Quantity");
		l3.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l4 = new Label("Price");
		l4.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l5 = new Label("Brand Name");
		l5.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		l6 = new Label("Expirtion date");
		l6.setStyle("-fx-Text-Fill:Black;-fx-font-size:12;-fx-font-weight:BOLD;");
		// create radio buttons and set them on action
		r1 = new RadioButton("Yes");
		r2 = new RadioButton("No");
		group = new ToggleGroup();
		r1.setToggleGroup(group);
		r2.setToggleGroup(group);
		r1.setOnAction(show);
		r2.setOnAction(show);
		// create a layouts and organized them
		h1 = new HBox(50);
		h1.getChildren().addAll(l1, r1, r2);
		h2 = new HBox(53);
		h2.getChildren().addAll(l2, t1);
		h3 = new HBox(33);
		h3.getChildren().addAll(l3, t2);
		h4 = new HBox(55);
		h4.getChildren().addAll(l4, t3);
		h5 = new HBox(10);
		h5.getChildren().addAll(l5, t4);
		h6 = new HBox(10);
		h6.getChildren().addAll(b1, b2);
		h6.setStyle("-fx-Alignment:BOTTOM_RIGHT");
		h7 = new HBox(3);
		h7.getChildren().addAll(l6, t5);
		p = new GridPane();
		p.add(h1, 0, 0);
		p.add(h2, 0, 1);
		p.add(h3, 0, 2);
		p.add(h4, 0, 3);
		p.add(h7, 0, 4);
		p.add(h5, 0, 5);
		p.add(h6, 0, 6);

		p.add(massegeLabel, 0, 7);
		p.setVgap(10);
		p.setHgap(10);
		p.setPadding(new Insets(10, 10, 10, 10));
		h5.setVisible(false);
		s2 = new Scene(p, 500, 300);
		p.setStyle("-fx-background-color:GAINSBORO");
		primaryStage.setScene(s2);
		primaryStage.setTitle("Add New Item");
		primaryStage.show();

	}

	class ShowBrandEvent implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			// events after we choice yes
			if (event.getSource() == r1) {
				h5.setVisible(true);
			}
			// events after we choice yes
			else if (event.getSource() == r2) {
				h5.setVisible(false);
			}
			try {
				// events after we press add
				if (event.getSource() == b1) {
					// call the tow new item method
					if (!h5.isVisible()) {
						inventory.newItem(t1.getText(), Integer.parseInt(t2.getText()),
								Double.parseDouble(t3.getText()), t5.getText());
					} else if (h5.isVisible()) {
						inventory.newItem(t4.getText(), t1.getText(), Integer.parseInt(t2.getText()),
								Double.parseDouble(t3.getText()), t5.getText());
					}

					massegeLabel.setText(getInventory().getMassegeLabel().getText());
				}

			}

			catch (NumberFormatException e) {
				massegeLabel.setText(e.getMessage());
			}
			// events after we press cancel
			if (event.getSource() == b2) {
				primaryStage.close();
			}

		}

	}

}
