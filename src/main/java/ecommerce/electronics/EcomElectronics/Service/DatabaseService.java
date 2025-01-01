package ecommerce.electronics.EcomElectronics.Service;

import ecommerce.electronics.EcomElectronics.DataBase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    @Autowired
    private Subcategory subcategory;

    @Autowired
    private ProductModel productModel;

//    @Autowired
//    private Category category;

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

    public ProductModel AddProduct(String productName, Long brandID, Long categoryID, Long subcategoryID, BigDecimal price, Integer stockQuantity)
    {
       // productModel.setProductId(productID);
        productModel.setProductName(productName);
        productModel.setPrice(price);
        productModel.setStockQuantity(stockQuantity);
        Optional<Brand> brand = FetchBrandByID(brandID);
        if(brand.isPresent())
        {
            Brand brand1 = brand.get();
            productModel.setBrand(brand1);
        }

        Optional<Category> category = FetchCategoryByID(categoryID);
        if(category.isPresent())
        {
            Category category1 = category.get();
            productModel.setCategory(category1);
        }

        Optional<Subcategory> subcategory = FetchSubCategoryByID(subcategoryID);
        if(subcategory.isPresent())
        {
            Subcategory subcategory1 = subcategory.get();
            productModel.setSubcategory(subcategory1);
        }
        ProductModel productModel1 = productModelRepository.save(productModel);
        return productModel1;
    }

    public Brand AddBrand(Brand brand)
    {

        return brandRepository.save(brand);
    }

    public Category AddCategory(Category category)
    {

        return categoryRepository.save(category);
    }

    public Subcategory AddSubcategory(String subCategoryName, Long categoryID)
    {

        subcategory.setSubcategoryName(subCategoryName);
        //subcategory.setSubcategoryId(subCategotyID);
        Optional<Category> category =  FetchCategoryByID(categoryID);
        if(category.isPresent())
        {
            Category category1 = category.get();
            subcategory.setCategory(category1);

        }
        return subcategoryRepository.save(subcategory);
    }

}
