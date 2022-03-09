package com.company;

public class Item {
  private String category;
  private String description;
  private boolean availible;

  public Item(String category, String description) {
    this.category = category;
    this.description = description;
    this.availible = true;
  }

  public boolean udlånStatus(){
    if (availible == true) {
      return true;
    }
    else {
      return false;
    }
  }
  public void setCategory(String newCategory){
    this.category = newCategory;
  }

  public void setDescription(String newDescription){
    this.description = newDescription;
  }


  public String getCategory() {
    return category;
  }

  public String getDescription(){
    return description;
  }
}

