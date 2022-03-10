package com.company;

public class Catalogue {
  private Item[] catalogue;
  private int count;

  public Catalogue(int size) {
    this.catalogue = new Item[size];
  }

  public void addItem(Item item) {
    catalogue[count] = item;
    setCount();
  }

  public Item[] getFullList() {
    return catalogue;
  }

  public Item[] getAvailableItems() {
    int counter = 0;
    for (Item item : catalogue) {
      if (item != null && item.checkAvailability()) {
        counter++;
      }
    }
    Item[] availableItems = new Item[counter];
    int counter2 = 0;
    for (Item item : catalogue) {
      if (item != null) {
        if (item.checkAvailability()) {
          availableItems[counter2] = item;
          counter2++;
        }
      }
    }
    return availableItems;
  }

  public void borrowItem(Item item) {
    item.setAvailability();
  }

  public void returnItem(Item item) {
    item.setAvailability();
  }

  public Item findItem(String description) {
    for (Item item : catalogue) {
      if (item.getDescription().equalsIgnoreCase(description)) {
        return item;
      }
    }
    return null;
  }

  public void setCount() {
    count++;
  }
}
