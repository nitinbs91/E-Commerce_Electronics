package ecommerce.electronics.EcomElectronics.DataBase;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategory")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    @Column(name = "subcategory_name", nullable = false)
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

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

