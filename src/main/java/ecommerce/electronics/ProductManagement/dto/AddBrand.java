package ecommerce.electronics.ProductManagement.dto;

public class AddBrand {

    private Long brandId;
    private String brandName;

    // Default Constructor
    public AddBrand() {
    }

    // Parameterized Constructor
    public AddBrand(Long brandId, String brandName) {
        this.brandId = brandId;
        this.brandName = brandName;
    }

    // Getter for brandId
    public Long getBrandId() {
        return brandId;
    }

    // Setter for brandId
    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    // Getter for brandName
    public String getBrandName() {
        return brandName;
    }

    // Setter for brandName
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
