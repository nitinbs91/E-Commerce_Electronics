package ecommerce.electronics.EcomElectronics.DataBase;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findProductsByCategory(Category category);
    List<ProductModel> findProductsByBrand(Brand brand);
    List<ProductModel> findProductsBySubcategory(Subcategory subcategory);
}
