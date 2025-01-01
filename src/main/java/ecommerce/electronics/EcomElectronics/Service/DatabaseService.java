package ecommerce.electronics.EcomElectronics.Service;

import ecommerce.electronics.EcomElectronics.DataBase.*;
import ecommerce.electronics.EcomElectronics.Exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
        try {
            return brandRepository.findAll();
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Optional<Brand> FetchBrandByID(Long brand_id)
    {
        try {
            return brandRepository.findById(brand_id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<Category> FetchAllCategories()
    {
        try {
            return categoryRepository.findAll();
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Optional<Category> FetchCategoryByID(Long category_id)
    {
        try {
            return categoryRepository.findById(category_id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<Subcategory> FetchAllSubCategories()
    {
        try {
            return subcategoryRepository.findAll();
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Optional<Subcategory> FetchSubCategoryByID(Long subcategory_id)
    {
        try {
            return subcategoryRepository.findById(subcategory_id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<ProductModel> FetchAllProductModels()
    {
        try {
            return productModelRepository.findAll();
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Optional<ProductModel> FetchProductModelByID(Long product_id)
    {
        try {
            return productModelRepository.findById(product_id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }
    public List<String> FindProductNamesByBrand(Optional<Brand> brand)
    {
        try {
            return productModelRepository.findProductNamesByBrand(brand);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<String> FindProductNamesByCategory(Optional<Category> category)
    {
        try {
            return productModelRepository.findProductNamesByCategory(category);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public List<String> FindProductNamesBySubcategory(Optional<Subcategory> subcategory)
    {

        try {
            return productModelRepository.findProductNamesBySubcategory(subcategory);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
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
        else
        {
            throw new DatabaseException("Invalid Brand ID");
        }

        Optional<Category> category = FetchCategoryByID(categoryID);
        if(category.isPresent())
        {
            Category category1 = category.get();
            productModel.setCategory(category1);
        }

        else
        {
            throw new DatabaseException("Invalid Category ID");
        }

        Optional<Subcategory> subcategory = FetchSubCategoryByID(subcategoryID);
        if(subcategory.isPresent())
        {
            Subcategory subcategory1 = subcategory.get();
            productModel.setSubcategory(subcategory1);
        }
        else
        {
            throw new DatabaseException("Invalid Subcategory ID");
        }
        try {
            ProductModel productModel1 = productModelRepository.save(productModel);
            return productModel1;
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Brand AddBrand(Brand brand)
    {

        try {
            return brandRepository.save(brand);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

    public Category AddCategory(Category category)
    {

        try {
            return categoryRepository.save(category);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
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
        else
        {
            throw new DatabaseException("Invalid Category ID");
        }
        try {
            return subcategoryRepository.save(subcategory);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage(), e);
        }
    }

}
