package com.company;

import java.util.Scanner;

public class Main {
  private Catalogue catalogue = new Catalogue(10);
  private Scanner scanner = new Scanner(System.in);

  public void startMenu() {
    System.out.println("Hvad kunne du tænke dig?");
    System.out.println("1. Se hele kataloget");
    System.out.println("2. Se hvad der er ledigt");
    System.out.println("3. Opret ting til udlån");
    System.out.println("4. Lån ting");
    System.out.println("5. Aflever ting");

    int choice = scanner.nextInt();
    switch (choice) {
      case 1 -> showCatalog();
      case 2 -> showAvailable();
      case 3 -> addItem();
      case 4 -> borrowItem();
      case 5 -> returnItem();
      default -> {
        System.out.println("Du foretog et ugyldigt valg.\nMenu genstartes.");
        startMenu();
      }
    }
  }

  public void showCatalog() {
    Item[] allItems = catalogue.getFullList();
    for (Item allItem : allItems) {
      if (allItem != null) {
        System.out.println(allItem);
      }
    }
    restart();
  }

  public void showAvailable() {
    Item[] availableItems = catalogue.getAvailableItems();
    for (Item availableItem : availableItems) {
      System.out.println(availableItem);
    }
    restart();
  }

  public void addItem() {
    System.out.println("Indtast kategori for ny genstand:");
    String newCategory = scanner.next();
    System.out.println("Indtast beskrivelse af ny genstand:");
    String newDescription = scanner.next();
    catalogue.addItem(new Item(newCategory, newDescription));

    addMoreItems();
  }

  public void addMoreItems() {
    System.out.println("Ønsker du at tilføje flere genstande?");
    System.out.println("""
        1. Ja
        2. Nej
        """);
    int choiceAdd = scanner.nextInt();
    switch (choiceAdd) {
      case 1 -> addItem();
      case 2 -> restart();
      default -> {
        System.out.println("Ugyldigt valg. Prøv igen.");
        addMoreItems();
      }
    }
  }

  public void borrowItem() {
    System.out.println("Indtast beskrivelse af genstand du ønsker at låne:");
    String borrowItem = scanner.next();
    Item found = catalogue.findItem(borrowItem);
    catalogue.borrowItem(found);
    restart();
  }

  public void returnItem() {
    System.out.println("Indtast beskrivelse af genstand du ønsker at returnere:");
    String returnItem = scanner.next();
    Item found = catalogue.findItem(returnItem);
    catalogue.returnItem(found);
    restart();
  }

  public void restart() {
    System.out.println("\nProgrammet har nu udført ønsket handling. Hvad vil du nu?");
    System.out.println("""
        1. Gå til hovedmenu.
        2. Afslut program.
        """);
    int choiceEnd = scanner.nextInt();

    switch (choiceEnd) {
      case 1 -> startMenu();
      case 2 -> System.out.println("Programmet afsluttes nu. Fortsat god dag.");
      default -> {
        System.out.println("Ugyldigt valg. Prøv igen.");
        restart();
      }
    }
  }


  public static void main(String[] args) {
    Main prg = new Main();
    prg.startMenu();
  }
}
