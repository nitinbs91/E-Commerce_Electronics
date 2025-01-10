package ecommerce.electronics.OrderManagement.dto;

public class Product {

    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
    private Category category;
    private Subcategory subcategory;
    private Brand brand;

    // Default constructor
    public Product() {}

    // Parameterized constructor
    public Product(Long id, String name, Double price, Integer quantity,
                   Category category, Subcategory subcategory, Brand brand) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.subcategory = subcategory;
        this.brand = brand;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    // Nested Category class
    public static class Category {
        private Long categoryId;
        private String categoryName;

        // Default constructor
        public Category() {}

        // Parameterized constructor
        public Category(Long categoryId, String categoryName) {
            this.categoryId = categoryId;
            this.categoryName = categoryName;
        }

        // Getters and Setters
        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }
    }

    // Nested Subcategory class
    public static class Subcategory {
        private Long subcategoryId;
        private String subcategoryName;
        private Category category;

        // Default constructor
        public Subcategory() {}

        // Parameterized constructor
        public Subcategory(Long subcategoryId, String subcategoryName, Category category) {
            this.subcategoryId = subcategoryId;
            this.subcategoryName = subcategoryName;
            this.category = category;
        }

        // Getters and Setters
        public Long getSubcategoryId() {
            return subcategoryId;
        }

        public void setSubcategoryId(Long subcategoryId) {
            this.subcategoryId = subcategoryId;
        }

        public String getSubcategoryName() {
            return subcategoryName;
        }

        public void setSubcategoryName(String subcategoryName) {
            this.subcategoryName = subcategoryName;
        }

        public Category getCategory() {
            return category;
        }

        public void setCategory(Category category) {
            this.category = category;
        }
    }

    // Nested Brand class
    public static class Brand {
        private Long brandId;
        private String brandName;

        // Default constructor
        public Brand() {}

        // Parameterized constructor
        public Brand(Long brandId, String brandName) {
            this.brandId = brandId;
            this.brandName = brandName;
        }

        // Getters and Setters
        public Long getBrandId() {
            return brandId;
        }

        public void setBrandId(Long brandId) {
            this.brandId = brandId;
        }

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }
    }
}

