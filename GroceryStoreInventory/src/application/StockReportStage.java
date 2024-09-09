package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//class to create the Stage of stockReport button
public class StockReportStage  {
	private Stage stage;
	private Scene scene;
	private Text text;
	private CheckBox check1, check2;
	private HBox hBox, hBox2;
	private VBox vBox;
	private TextField textfeField;
	private TextArea textArea;
	private Pane pane;
	private Button button;
	private PrintEvent printEvent;
	private Inventory inventory = new Inventory("ahmad");
	private Label errorMassege;
	private PrintWriter exportPrintWriter=null;
	private HBox hBox3;

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public StockReportStage() {
		//create a stage and its attribute
		stage = new Stage();
		text = new Text();
		text.setText("The following options can be used to print a report");
		//HBox to put the tow checkBoxes
		hBox = new HBox(20);
		//HBox to put the text in Stage
		hBox2 = new HBox();
		//HBox to put the textFiled
		hBox3=new HBox();
		textfeField = new TextField();
		textfeField.setPrefWidth(150);
		hBox3.getChildren().add(textfeField);
		//create a button and cheekBoxes and set them on action
		check2 = new CheckBox("TextArea");
		check1 = new CheckBox("Export a copy to a file");
		button = new Button("export");
		printEvent = new PrintEvent();
		check1.setOnAction(printEvent);
		check2.setOnAction(printEvent);
		button.setOnAction(printEvent);
		hBox.getChildren().addAll(check1, check2);
		hBox2.getChildren().add(text);
		text.setStyle("-fx-font-size:20;-fx-font-Weight:Bold");
		hBox2.setLayoutX(20);
		hBox2.setLayoutY(20);
		pane = new Pane();
		pane.getChildren().add(hBox2);
		hBox.setLayoutX(10);
		hBox.setLayoutY(50);
		errorMassege = new Label("");
		//VBox to put the nodes vertically
		vBox = new VBox(5);
		vBox.getChildren().addAll(hBox, hBox3, button, errorMassege);
		pane.getChildren().add(vBox);
		vBox.setLayoutY(50);
		vBox.setLayoutX(10);
		//text area to print the output
		textArea = new TextArea();
		pane.getChildren().add(textArea);
		textArea.setLayoutX(200);
		textArea.setLayoutY(200);
		textfeField.setVisible(false);
		textArea.setVisible(false);
		button.setVisible(false);
		scene = new Scene(pane, 700, 420);
		stage.setScene(scene);
		stage.show();
	}

	class PrintEvent implements EventHandler<ActionEvent>  {

		@Override
		public void handle(ActionEvent event) {
			//handle the tow check boxes to control of print ways
			if (event.getSource() == check1) {
				if (check1.isSelected()) {

					textfeField.setVisible(true);
					button.setVisible(true);
					
					
					
				} else if (!check1.isSelected()) {

					textfeField.setVisible(false);
					button.setVisible(false);
				}
			} else if (event.getSource() == check2) {
				if (check2.isSelected()) {
					textArea.setVisible(true);
					inventory.stockReport();
					textArea.setText(inventory.getReport());

				}
				if (!check2.isSelected()) {
					textArea.setVisible(false);
				}

			} 
			//export to file choice
			if (check1.isSelected()) {

				textfeField.setVisible(true);
				button.setVisible(true);
			if (event.getSource() == button) {
				inventory.stockReport();
				File file=new File(textfeField.getText());
				if(file.exists()) {
				try {
					errorMassege.setText("its Done");
					exportPrintWriter = new PrintWriter(file);	
					exportPrintWriter.print(inventory.getReport());
					exportPrintWriter.close();
				} catch (FileNotFoundException e) {
					errorMassege.setText(e.getMessage());
				}

			}
				else
					errorMassege.setText("this file are not exist");
			
			}}
		}

	}

}
