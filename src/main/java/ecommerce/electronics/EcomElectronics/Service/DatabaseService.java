package ecommerce.electronics.EcomElectronics.Service;

import ecommerce.electronics.EcomElectronics.DataBase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Category> FetchAllCategories()
    {
        return categoryRepository.findAll();
    }

    public List<Subcategory> FetchAllSubCategories()
    {
        return subcategoryRepository.findAll();
    }

    public List<ProductModel> FetchAllProductModels()
    {
        return productModelRepository.findAll();
    }
}
