package com.company;

import java.util.Scanner;

public class TestSharedRessources {

  public void startMenu(){
  }

  public void showCatalog(){
  }

  public void showAvailable(){

  }

  public void addItem(){

  }

  public void borrowItem(){

  }

  public void returnItem(){

  }


  public static void main(String[] args) {

    Catalogue catalogue = new Catalogue(10);

    Item item1 = new Item("Sport", "Skateboard");
    catalogue.addItem(item1);
    Item item2 = new Item("Sport", "Mountainbike");
    catalogue.addItem(item2);
    Item item3 = new Item("Tøj", "Smoking");
    catalogue.addItem(item3);
    Item item4 = new Item("Tøj", "Pailletkjole");
    catalogue.addItem(item4);
    Item item5 = new Item("Værktøj", "Boremaskine");
    catalogue.addItem(item5);
    Item item6 = new Item("Værktøj", "Hammer");
    catalogue.addItem(item6);
    Item item7 = new Item("Sport", "Skøjter");
    catalogue.addItem(item7);
    Item item8 = new Item("Sport", "Skridtbeskytter");
    catalogue.addItem(item8);
    Item item9 = new Item("Tøj", "Charmeklud");
    catalogue.addItem(item9);
    Item item10 = new Item("Sport", "Dobbeltbladet økse");
    catalogue.addItem(item10);

    ///////////////////////////////////////////////

    // Exercise Part 2: Make program with user input instead of hardcoded values
    // Make program able to show menu and handles user choices in loop
    // Ask user what user wants to do
    System.out.println("Hvad kunne du tænke dig?");
    System.out.println("1. Se hele kataloget");
    System.out.println("2. Se hvad der er ledigt");
    System.out.println("3. Opret ting til udlån");
    System.out.println("4. Lån ting");
    System.out.println("5. Aflever ting");

    // Read user choice
    Scanner scanner = new Scanner(System.in);
    int choice = scanner.nextInt();

    // Decide what to do based on user choice
    if (choice == 1) { // get all items in cataloque
      Item[] allItems = catalogue.getFullList();
      for (Item allItem : allItems) {
        System.out.println(allItem);
      }
    } else if (choice == 2) { // get available items in cataloque
      Item[] availableItems = catalogue.getAvailableItems();
      for (Item availableItem : availableItems) {
        System.out.println(availableItem);
      }
    } else if (choice == 3) { // Add new Item to catalogue
      System.out.println("Indtast kategori for ny genstand:");
      String newCategory = scanner.next();
      System.out.println("Indtast beskrivelse af ny genstand:");
      String newDescription = scanner.next();
      catalogue.addItem(new Item(newCategory, newDescription));
    } else if (choice == 4) { // make item unavailable
      System.out.println("Indtast beskrivelse af genstand du ønsker at låne:");
      String borrowItem = scanner.next();
      Item found = catalogue.findItem(borrowItem);
      catalogue.borrowItem(found);
    } else if (choice == 5) { // make item available again
      System.out.println("Indtast beskrivelse af genstand du ønsker at returnere:");
      String returnItem = scanner.next();
      Item found = catalogue.findItem(returnItem);
      catalogue.returnItem(found);
    } else { // invalid choice
      System.out.println("Du foretog et ugyldigt valg.");
    }
  }
}
