package application;

import java.util.ArrayList;

import javafx.scene.control.Label;

public class Inventory {
	// Arraylist its save an Item or Brand
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private String category;
	private Label massegeLabel=new Label();
	
	private String report=new String("");

	
	


	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public Label getMassegeLabel() {
		return massegeLabel;
	}

	public void setMassegeLabel(Label massegeLabel) {
		this.massegeLabel = massegeLabel;
	}

	public Inventory(String category) {

		this.category = category;
	}

	// if we need to add a new Item or new Brand to the ArrayList we use this
	// methods
	public void newItem(String type, int quantity, double price,String expiration) {

		if (findItem(type, true) == -1) {

			inventory.add(new Item(type).setQuantity(quantity).setPrice(price).setExpiration(expiration));
			 massegeLabel.setText( type + " - in stock :" + getQuantity(type)
				+ " ,price : $" +getPrice(type)+"\n");

		}
	}
	public void newItem(String brand, String type, int quantity, Double price,String expiration) {
		if (findItem(type, true, brand) == -1) {

			inventory.add(new Brand(brand, type).setQuantity(quantity).setPrice(price).setExpiration(expiration));
			 massegeLabel.setText((brand+ " " + type + " - in stock :" + getQuantity(type)
				+ " ,price : $" +getPrice(type))+"\n");
		}
	}

	public void DeleteItem(String brand, String type) {
		if (findItem(type, false, brand) != -1) {

			inventory.remove(findItem(type, false, brand));
			massegeLabel.setText("the item: "+brand+" "+type+" its deleted");
		}
	}

	public void DeleteItem(String type) {

		if (findItem(type, false) != -1) {

			inventory.remove(findItem(type, false));
			massegeLabel.setText("the item: "+type+" its deleted");

		}

	}

	

	// if its needed to give the quantity of the Item or the brand that is already
	// exists in the ArrayList
	public void setQuantity(String type, int quantity) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).setQuantity(quantity);
		}
	}

	public void setQuantity(String brand, String type, int quantity) {
		if (findItem(type, false, brand) != -1) {
			inventory.get(findItem(type, false, brand)).setQuantity(quantity);

		}
	}

	// if its needed to give the price of the Item or the brand that is already
	// exists in the ArrayList
	public void setPrice(String type, double price) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).setPrice(price);

		}
	}

	public void setPrice(String brand, String type, double price) {
		if (findItem(type, false, brand) != -1) {
			inventory.get(findItem(type, false, brand)).setPrice(price);

		}
	}

//gets method thats used to show the price or the quantity of the Brand or Item
	public int getQuantity(String type) {
		if (findItem(type, false) != -1) {
			return inventory.get(findItem(type, false)).getQuantity();

		} else

			return -1;
	}

	public int getQuantity(String brand, String type) {
		if (findItem(type, false, brand) != -1) {
			return inventory.get(findItem(type, false, brand)).getQuantity();

		} else
			return 0;
	}
	public String getexpiration( String type) {
		if (findItem(type, false) != -1) {
			return inventory.get(findItem(type, false)).getExpiration();

		} else
			return null;
	}
	public String getexpiration(String brand, String type) {
		if (findItem(type, false, brand) != -1) {
			return inventory.get(findItem(type, false, brand)).getExpiration();

		} else
			return null;
	}

	public double getPrice(String type) {
		if (findItem(type, false) != -1) {
			return inventory.get(findItem(type, false)).getPrice();

		} else
			return Double.NaN;
	}

	public double getPrice(String brand, String type) {
		if (findItem(type, false, brand) != -1) {
			return inventory.get(findItem(type, false, brand)).getPrice();

		} else
			return Double.NaN;

	}
	public void update(String type, String ex) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).update(ex);
			
		}
	}
	public void update(String Brand ,String type, String ex) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).update(ex);
			
		}
	}


//updates method to change the price or the quantity to the Item or Brand thats already exists
	public void update(String type, int qtyIncrease) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).update(qtyIncrease);
			
		}
	}

	public void update(String brand, String type, int qtyIncrease) {
		if (findItem(type, false, brand) != -1) {
			inventory.get(findItem(type, false, brand)).update(qtyIncrease);
			
		}
	}

	public void update(String type, double adjustmentFactor) {
		if (findItem(type, false) != -1) {
			inventory.get(findItem(type, false)).update(adjustmentFactor);
			
		}
	}

	public void update(String brand, String type, double adjustmentFactor) {
		if (findItem(type, false, brand) != -1) {
			inventory.get(findItem(type, false, brand)).update(adjustmentFactor);
			
		}

	}

//findItem methods thats find if the Item or the Brand are exists or not
	private int findItem(String type, boolean warningIfFound) {
		int itemsFound = 0;
		int index = -1;

		for (int i = 0; i < inventory.size(); i++) {

			if (type.equals(inventory.get(i).getType())) {
				index = i;
				itemsFound++;
			}

		}
		if (itemsFound == 0 && warningIfFound == false) {
			massegeLabel.setText("cannot find " + type);

		}

		else if (itemsFound == 1 && warningIfFound == true) {
			massegeLabel.setText("already exists");
			return index;
		}
		
		else if (itemsFound > 1) {
			massegeLabel.setText("found more than one brand");
			return index;
		}
		else if (itemsFound == 1 && warningIfFound == false) {
			massegeLabel.setText((inventory.get(index).getType() + " - in stock :" + inventory.get(index).getQuantity() + " ,price : $" + inventory.get(index).getPrice()+ " ,exprition : " + inventory.get(index).getExpiration())+"\n");
			return index;
			
		}
		
		return -1;

	}

	private int findItem(String type, boolean warningIfFound, String brand) {
		int itemsFound = 0;
		int index = -1;

		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (type.equals(item.getType()) && item instanceof Brand && brand.equals(((Brand) item).getBrand())) {
				index = i;
				itemsFound++;
			}
		}

		if (itemsFound == 0 && warningIfFound == false) {
			
			massegeLabel.setText("cannot find " + brand + " " + type);

		}

		else if (itemsFound != 0 && warningIfFound == true) {
	       massegeLabel.setText("already exists");
	       return index;
		}
	
		else if (itemsFound == 1&& warningIfFound == false) {
			 massegeLabel.setText((((Brand)inventory.get(index)).getBrand() + " " + inventory.get(index).getType() + " - in stock :" + inventory.get(index).getQuantity()
			+ " ,price : $" + inventory.get(index).getPrice()+" ,exprition : " + inventory.get(index).getExpiration())+"\n");
			return index;
		}
		
		return -1;
	}
	

//StockReport method its print the ArrayList of Items and Brands and its prices and quantities
	public void  stockReport() {
		report="";
		double totalValue = 0;
		for (int i = 0; i < inventory.size(); i++) {
			Item item = inventory.get(i);
			if (item instanceof Brand) {
				totalValue += item.getPrice() * item.getQuantity();
				Brand b = (Brand) item;

				report+=(b.getBrand() + " " + item.getType() + " - in stock :" + item.getQuantity()
						+ " ,price : $" + item.getPrice()+" expiration date : "+item.getExpiration())+"\n";
			}

			else {
				
						report+=(item.getType() + " - in stock :" + item.getQuantity() + " ,price : $" + item.getPrice()+" expiration date : "+item.getExpiration())+"\n";

				totalValue += item.getPrice() * item.getQuantity();
			}

		}
		report+=("Total value : " + totalValue);
		
	}
	

}
