package ecommerce.electronics.EcomElectronics.dto;

public class AddCategory {

    private String categoryName;

    public AddCategory() {
    }

    public AddCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
