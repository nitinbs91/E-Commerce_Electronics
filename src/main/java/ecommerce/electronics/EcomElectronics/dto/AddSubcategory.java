package ecommerce.electronics.EcomElectronics.dto;

import ecommerce.electronics.EcomElectronics.DataBase.Category;

public class AddSubcategory {

    //private Long subCategoryID;
    private String subCategoryName;
    private Long categoryID;

    // Default constructor
    public AddSubcategory() {
    }

    // All-args constructor
    public AddSubcategory(Long subCategoryID, String subCategoryName, Long categoryID) {
       // this.subCategoryID = subCategoryID;
        this.subCategoryName = subCategoryName;
        this.categoryID = categoryID;
    }

    // Getter for subCategoryID
//    public Long getSubCategoryID() {
//        return subCategoryID;
//    }

//    // Setter for subCategoryID
//    public void setSubCategoryID(Long subCategoryID) {
//        this.subCategoryID = subCategoryID;
//    }

    // Getter for subCategoryName
    public String getSubCategoryName() {
        return subCategoryName;
    }

    // Setter for subCategoryName
    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    // Getter for categoryID
    public Long getCategoryID() {
        return categoryID;
    }

    // Setter for categoryID
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }
}
