package ecommerce.electronics.EcomElectronics.DataBase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findProductsByCategory(Category category);
    List<ProductModel> findProductsByBrand(Brand brand);
    List<ProductModel> findProductsBySubcategory(Subcategory subcategory);
    @Query("SELECT p.productName FROM ProductModel p WHERE p.brand = :brand")
    List<String> findProductNamesByBrand(@Param("brand") Optional<Brand> brand);
    @Query("SELECT p.productName FROM ProductModel p WHERE p.category = :category")
    List<String> findProductNamesByCategory(@Param("category") Optional<Category> category);
    @Query("SELECT p.productName FROM ProductModel p WHERE p.subcategory = :subcategory")
    List<String> findProductNamesBySubcategory(@Param("subcategory") Optional<Subcategory> subcategory);

}
