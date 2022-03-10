package com.company;

public class Item {
  private String category;
  private String description;
  private boolean availability;

  public Item(String category, String description) {
    this.category = category;
    this.description = description;
    this.availability = true;
  }

  public Item(String category, String description, boolean availibilty) {
    this.category = category;
    this.description = description;
    this.availability = availibilty;
  }

  @Override
  public String toString() {
    return "Item:\n" +
        "| Beskrivelse = " + description + '\n' +
        "| Kategori = " + category + '\n' +
        "| Genstanden er ledig = " + availability;
  }

  public void setCategory(String newCategory){
    this.category = newCategory;
  }

  public void setDescription(String newDescription){
    this.description = newDescription;
  }

  public boolean checkAvailability(){
    return availability;
  }

  public boolean setAvailability(){
    if(availability) {
      this.availability = false;
      return this.availability;
    } else{
      availability = true;
      return this.availability;
    }
  }


  public String getCategory() {
    return this.category;
  }

  public String getDescription(){
    return this.description;
  }
}

