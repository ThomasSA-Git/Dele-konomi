package com.company;

import java.util.Arrays;

public class Catalogue {
  private Item[] catalogue;
  private int count;

  public Catalogue(int i) {
    this.catalogue = new Item[i];
  }

  public void addItem(Item item) {
    catalogue[count] = item;
    setCount();
  }

  public String getCatalogue() {
    return Arrays.toString(catalogue);
  }

  public void borrowItem() {

  }

  public void returnItem() {

  }

  public String getByDescription(String description) {
    for (int i = 0; i < count; i++) {
      for (int j = 0; i < catalogue[i].length; j++)
        if (catalogue[i][j] == description) {
          return "Genstanden er nummer " + (i + 1) + "på listen";
        }
    }
    return "Fejl";
  }

  public void setCount() {
    count++;

  }
}
