# Inventory Management System

## Overview

The **Inventory Management System** is a Java-based application designed to help businesses manage their inventory efficiently. It allows users to add, update, delete, and view items in the inventory. The application uses **JavaFX** for the user interface and **Data Structures** for managing the inventory data. Data is persisted using **files** to ensure it is retained even when the application is closed.

---

## Key Features

### 1. **Add New Items**
   - Users can add new items to the inventory by specifying the item name, quantity, price, and description.

### 2. **Update Inventory**
   - Users can update the details of an existing item, such as changing the quantity or price.

### 3. **Delete Items**
   - Items that are no longer needed can be deleted from the inventory.

### 4. **View Inventory**
   - Users can view the complete list of items in the inventory along with their details, including name, quantity, price, and total value.

### 5. **Data Persistence**
   - All inventory data is saved using **files** to ensure the information is persistent between application sessions.
   - The data is structured using **Data Structures** like Lists, Maps, and Sets, providing efficient and flexible storage and retrieval.

### 6. **Search Functionality**
   - Users can search for items in the inventory by their name or description.

---

## Technologies Used

- **Java**: Core programming language for the logic and backend of the application.
- **JavaFX**: Used to create the graphical user interface (GUI).
- **List**: Used for managing items in the inventory.
- **File I/O**: Used to read from and write to files to store the inventory data persistently.
---

## How to Use

### 1. **Run the Application**
   - After compiling the Java source code, run the main class to launch the JavaFX-based GUI.
   
### 2. **Adding Items**
   - In the main interface, click on the "Add Item" button.
   - Fill in the required fields (Item Name, Quantity, Price, and Description) and click "Save".

### 3. **Updating Items**
   - Select the item from the inventory list.
   - Modify the item details (such as quantity or price) and click "Update".

### 4. **Deleting Items**
   - Select an item from the inventory and click on the "Delete" button to remove it.

### 5. **View and Search Inventory**
   - View the complete list of items in the inventory.
   - Use the search bar to search for items by name or description.

### 6. **Data Persistence**
   - All the inventory data is stored in text files, ensuring data is saved and persists between sessions.
   - The system automatically loads the data from the file when the app is launched.

---

## Installation

1. **Clone the Repository**
   - Clone the repository to your local machine using the following command:
   ```bash
   git clone https://github.com/AhmadEwidat/MyFirstProj.git
