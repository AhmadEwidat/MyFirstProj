package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Phase2 extends Application {
	private Button add;
	private Button modify;
	private Button delete;
	private Button stockReport;
	private StackPane s1;
	private Image image;
	private ImageView IV;
	private HBox hbox, hbox2;
	private BorderPane bord;
	private Scene scene;
	private Label label;
	private Inventory inventory = new Inventory("ahmad");
	private AddEvent d;
	private Button fileChooser ;

	@Override
	public void start(Stage primaryStage) throws IOException  {
		//file chooser allows you to fill in inventory from a file
		try {
		FileChooser fileChooser = new FileChooser();
		File selector = fileChooser.showOpenDialog(primaryStage);
		if (selector != null) {
			BufferedReader scan = new BufferedReader(new FileReader(selector));
			String line;
			while ((line = scan.readLine()) != null) {
			String []list=line.split(",");
			
				if(list.length ==4) {
					
					inventory.newItem(list[0], Integer.parseInt(list[1]),Double.parseDouble(list[2]),list[3]);
				
				}
				else if(list.length==5) {
					
					inventory.newItem(list[0],list[1], Integer.parseInt(list[2]),Double.parseDouble(list[3]),list[4]);
				}
			
				
			}
		}}
		catch (NumberFormatException e) {
			
		}
		//I created the five main buttons (add,modify,Delete,stock report).and linked them to Action Event
		add = new Button("Add");
		d = new AddEvent();
		add.setOnAction(d);
		modify = new Button("Modify");
		modify.setOnAction(d);
		delete = new Button("Delete");
		delete.setOnAction(d);
		stockReport = new Button("Stock Report");
		stockReport.setOnAction(d);
		s1 = new StackPane(); //stack pane to put the image in it
		image = new Image("image1.jpg");//image to save the image location
		IV = new ImageView(image); //put image to image view
		//I set the angle,height and width of the image and then I put the image in Stack pane(s1)
		IV.setRotate(37);
		IV.setFitWidth(260);
		IV.setFitHeight(200);
		s1.getChildren().add(IV);
		//I created the HBox and made the h gap equals 10 and then placed the buttons on it
		hbox = new HBox(10);
		hbox.getChildren().addAll(add, modify, delete, stockReport);
		hbox.setStyle("-fx-Alignment:center;");//setStyle method to make a style of HBox
		//create the border pane and set it style by setStyle method and set a Stack Pane and HBox on it
		bord = new BorderPane();
		bord.setStyle("-fx-background-color:GAINSBORO");
		bord.setCenter(s1);
		bord.setBottom(hbox);
		//create label and set Style of label then put it on HBox and put HBox in border pane 
		label = new Label("Inventory Mangment System :Comp2311 Project,Phase 2");
    	label.setStyle("-fx-Text-Fill:SLATEGRAY;-fx-font-size:18;-fx-font-weight:BOLD;-fx-font-Style:ITALIC;");
		hbox2 = new HBox();
		hbox2.getChildren().add(label);
		bord.setTop(hbox2);
		
		hbox2.setStyle("-fx-Alignment:center;");
		scene = new Scene(bord, 600, 380);//set border pane in scene  and scene in stage and show stage
		primaryStage.setResizable(false);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Inventory Mangment System");


		primaryStage.show();

	}

	class AddEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			//event to show the add stage
			if (event.getSource() == add) {
				AddStage addStage = new AddStage();
				addStage.setInventory(inventory);}
				//event to show the modify stage
			 else if (event.getSource() == modify) {

				ModifyStage modifyStage = new ModifyStage();
				modifyStage.setInventory(inventory);

			} 
			//event to show the delete stage
			else if (event.getSource() == delete) {

				DeleteStage deleteStage = new DeleteStage();
				deleteStage.setInventory(inventory);

			} 
			//event to show the stockReport stage
			else if (event.getSource() == stockReport) {

				StockReportStage stockReportStage = new StockReportStage();
				stockReportStage.setInventory(inventory);

			}
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
