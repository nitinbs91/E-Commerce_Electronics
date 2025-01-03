package ecommerce.electronics.ProductManagement.dto;

import java.math.BigDecimal;

public class AddProduct {

   // private Integer productId;
    private String productName;
    private Long brand;
    private Long category;
    private Long subcategory;
    private BigDecimal price;
    private Integer stockQuantity;

    // Default constructor
    public AddProduct() {
    }

    // All-args constructor
    public AddProduct(Integer productId, String productName, Long brand, Long category, Long subcategory, BigDecimal price, Integer stockQuantity) {
       // this.productId = productId;
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.subcategory = subcategory;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // Getter for productId
//    public Integer getProductId() {
//        return productId;
//    }
//
//    // Setter for productId
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }

    // Getter for productName
    public String getProductName() {
        return productName;
    }

    // Setter for productName
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter for brand
    public Long getBrand() {
        return brand;
    }

    // Setter for brand
    public void setBrand(Long brand) {
        this.brand = brand;
    }

    // Getter for category
    public Long getCategory() {
        return category;
    }

    // Setter for category
    public void setCategory(Long category) {
        this.category = category;
    }

    // Getter for subcategory
    public Long getSubcategory() {
        return subcategory;
    }

    // Setter for subcategory
    public void setSubcategory(Long subcategory) {
        this.subcategory = subcategory;
    }

    // Getter for price
    public BigDecimal getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    // Getter for stockQuantity
    public Integer getStockQuantity() {
        return stockQuantity;
    }

    // Setter for stockQuantity
    public void setStockQuantity(Integer stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
