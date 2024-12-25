package ecommerce.electronics.EcomElectronics.Service;

import ecommerce.electronics.EcomElectronics.DataBase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductModelRepository productModelRepository;

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public List<Brand> FetchAllBrands()
    {
        return brandRepository.findAll();
    }

    public Optional<Brand> FetchBrandByID(Long brand_id)
    {
        return brandRepository.findById(brand_id);
    }

    public List<Category> FetchAllCategories()
    {
        return categoryRepository.findAll();
    }

    public Optional<Category> FetchCategoryByID(Long category_id)
    {
        return categoryRepository.findById(category_id);
    }

    public List<Subcategory> FetchAllSubCategories()
    {
        return subcategoryRepository.findAll();
    }

    public Optional<Subcategory> FetchSubCategoryByID(Long subcategory_id)
    {
        return subcategoryRepository.findById(subcategory_id);
    }

    public List<ProductModel> FetchAllProductModels()
    {
        return productModelRepository.findAll();
    }

    public Optional<ProductModel> FetchProductModelByID(Long product_id)
    {
        return productModelRepository.findById(product_id);
    }
    public List<String> FindProductNamesByBrand(Optional<Brand> brand)
    {
        return productModelRepository.findProductNamesByBrand(brand);
    }

    public List<String> FindProductNamesByCategory(Optional<Category> category)
    {
        return productModelRepository.findProductNamesByCategory(category);
    }

    public List<String> FindProductNamesBySubcategory(Optional<Subcategory> subcategory)
    {
        return productModelRepository.findProductNamesBySubcategory(subcategory);
    }
}
