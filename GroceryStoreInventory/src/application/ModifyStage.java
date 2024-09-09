package application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//modify stage its a sub class of add stage and its to create the Stage of add button
public class ModifyStage extends AddStage {
	private ComboBox<String> comp ;
	private Button b;
	private Button b1 ;
	private HBox Hmod ;
	private ShowBrandEvent show ;
	private Stage errorStage;
	private VBox v;
	private Scene scene;
	private Button ok;
	private BorderPane bord;

	public ModifyStage() {
	
		show = new ShowBrandEvent();
		b = new Button("update");
		 b1 = new Button("search");
		//linked the two buttons with Action event
		b.setOnAction(show);
		b1.setOnAction(show);
		//set title of stage
		getPrimaryStage().setTitle("Update Item");
		//create comboBox and add items to comboBox and setStyle the coboBox  and set it on action
		comp = new ComboBox<>();
		comp.getItems().addAll("Brand", "No Brand");
		comp.setPrefWidth(148);
		comp.setEditable(true);
		comp.setOnAction(show);
		//create HBox and put it in the grade pane and set the brand textField and search button in the hBox
		Hmod = new HBox();
		getP().add(Hmod, 1, 1);
		Hmod.getChildren().addAll(getT4(), b1);
		//set the visible false for the search button and brand textField and set Editable for the price and quantity textFields is false 
		b1.setVisible(false);
		getT4().setVisible(false);
		getT2().setEditable(false);
		getT3().setEditable(false);
		getT5().setEditable(false);
		//remove save button and add modify button
		getH1().getChildren().remove(1);
		getH1().getChildren().remove(1);
		getH1().getChildren().add(comp);
		getH1().setSpacing(45);
		getH6().getChildren().remove(0);
		getH6().getChildren().add(0, b);
		getP().getChildren().remove(5);
		getT1().setPromptText("Type");
		getT1().setStyle("-fx-prompt-text-fill:green;");
		getT4().setPromptText("Brand");
		getT4().setStyle("-fx-prompt-text-fill:green;");
		
	}

	class ShowBrandEvent implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
    
			if (event.getSource() == comp) {
            //if we select the brand choice the search button and brand text Filed are showed up and if a choice is no brand the  text field are hide
				if (comp.getValue() == "Brand") {
					b1.setVisible(true);
					getT4().setVisible(true);
					if (!Hmod.getChildren().contains(getT4())) {
						Hmod.getChildren().add(0, getT4());
					}
                  
				} else if (comp.getValue() == "No Brand") {
					getT4().setVisible(false);
					Hmod.getChildren().remove(getT4());
					b1.setVisible(true);

				}

			}
			try {
				if (event.getSource() == b) {
					if (getT4().isVisible() == false) {

						getInventory().update(getT1().getText(),
								(Double.parseDouble(getT3().getText()) / getInventory().getPrice(getT1().getText()))
										- 1);

						getInventory().update(getT1().getText(),
								Integer.parseInt(getT2().getText()) - getInventory().getQuantity(getT1().getText()));
						getMassegeLabel().setText("its Done");

					} else if (getT4().isVisible()) {

						getInventory().update(getT4().getText(), getT1().getText(),
								(Double.parseDouble(getT3().getText())
										/ getInventory().getPrice(getT4().getText(), getT1().getText())) - 1);

						getInventory().update(getT4().getText(), getT1().getText(), Integer.parseInt(getT2().getText())
								- getInventory().getQuantity(getT4().getText(), getT1().getText()));

						getMassegeLabel().setText("its Done");

					}

				}

			} catch (NumberFormatException numberFormatException) {
				

			}
			//if the event its press to update button we call the update method in inventory class
			if (event.getSource() == b1) {
			//if not brand 
				if (getT4().isVisible() == false) {
					getInventory().update(getT1().getText(),0);
					getInventory().update(getT1().getText(),0);
                    //if the item its not exist we show the error stage
					if (getInventory().getMassegeLabel().getText().contains("cannot find")) {
						CannotFoundStage cannotFoundStage=new CannotFoundStage();
						

					}
					
					else {

						getMassegeLabel().setText(getInventory().getMassegeLabel().getText());
						if(getPrimaryStage().getTitle().equals("Update Item")) {
						getT2().setEditable(true);//set price text filed  editable
						getT3().setEditable(true);
						getT5().setEditable(true);}//set quantity text filed  editable
					}
                // if item is brand
				} else if (getT4().isVisible() == true) {
					
					getInventory().update(getT4().getText(),getT1().getText(),0);
					getInventory().update(getT4().getText(),getT1().getText(),0);
					
					if (getInventory().getMassegeLabel().getText().contains("cannot find")) {
						CannotFoundStage cannotFoundStage=new CannotFoundStage();
					} else {
						getMassegeLabel().setText(getInventory().getMassegeLabel().getText());
						if(getPrimaryStage().getTitle().equals("Update Item")) {
						getT2().setEditable(true);
						getT3().setEditable(true);
						getT5().setEditable(true);
						}
					}
				}
				//if the event its OK button in error stage
			} else if (event.getSource() == ok) {
				errorStage.close();
			}
		}

	}
	//cannot found class to create a stage of error (cannot found) 
	class CannotFoundStage   {
		
		public CannotFoundStage() {
			errorStage = new Stage();
			bord = new BorderPane();
			v = new VBox();
			ok = new Button("ok");
			ok.setOnAction(show);
			v.getChildren().addAll(getInventory().getMassegeLabel(), ok);
			bord.setCenter(v);
			v.setStyle("-fx-Alignment:CENTER");
			scene = new Scene(bord, 250, 100);
			errorStage.setScene(scene);
			errorStage.show();
		}
	}
}

