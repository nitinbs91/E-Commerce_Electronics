package ecommerce.electronics.ProductManagement.Controller;

import ecommerce.electronics.ProductManagement.Business.DTOToEntityMapper;
import ecommerce.electronics.ProductManagement.DataBase.Brand;
import ecommerce.electronics.ProductManagement.DataBase.Category;
import ecommerce.electronics.ProductManagement.DataBase.ProductModel;
import ecommerce.electronics.ProductManagement.DataBase.Subcategory;
import ecommerce.electronics.ProductManagement.Service.DatabaseService;
import ecommerce.electronics.ProductManagement.dto.AddBrand;
import ecommerce.electronics.ProductManagement.dto.AddCategory;
import ecommerce.electronics.ProductManagement.dto.AddProduct;
import ecommerce.electronics.ProductManagement.dto.AddSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class EcomElectronicsApplicationController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private DTOToEntityMapper dtoToEntityMapper;


    @GetMapping("/all")
    public List<ProductModel> ReturnAllProducts()
    {
        return databaseService.FetchAllProductModels();
    }

    @GetMapping("/fetch/product/{id}")
    public Optional<ProductModel> ReturnProductForID(@PathVariable("id")Long ID)
    {
        return databaseService.FetchProductModelByID(ID);
    }

    @GetMapping("/fetch/productforbrand/{id}")
    public List<String> ReturnProductForBrand(@PathVariable("id")Long ID)
    {
        Optional<Brand> brand = databaseService.FetchBrandByID(ID);
        return databaseService.FindProductNamesByBrand(brand);
    }

    @GetMapping("/fetch/productforcategory/{id}")
    public List<String> ReturnProductForCategory(@PathVariable("id")Long ID)
    {
        Optional<Category> category = databaseService.FetchCategoryByID(ID);
        return databaseService.FindProductNamesByCategory(category);
    }

    @GetMapping("/fetch/productforsubcategory/{id}")
    public List<String> ReturnProductForSubCategory(@PathVariable("id")Long ID)
    {
        Optional<Subcategory> subcategory = databaseService.FetchSubCategoryByID(ID);
        return databaseService.FindProductNamesBySubcategory(subcategory);
    }

    @PostMapping("/AddProduct")
    public ResponseEntity<ProductModel> AddNewProduct(@RequestBody AddProduct request)
    {
       //Integer productID = request.getProductId();
       String productName = request.getProductName();
       Long brandID = request.getBrand();
       Long categoryID = request.getCategory();
       Long subcategoryID = request.getSubcategory();
       BigDecimal price = request.getPrice();
       Integer stockQuantity = request.getStockQuantity();
       ProductModel productModel= databaseService.AddProduct(productName, brandID, categoryID, subcategoryID, price, stockQuantity);
       return ResponseEntity.ok().header("status", "Success").body(productModel);
    }
    @PostMapping("/AddBrand")
    public ResponseEntity<Brand> AddNewBrand(@RequestBody AddBrand request)
    {
        Brand brand = dtoToEntityMapper.MapBrandDTOToEntity(request);
        Brand brand1 = databaseService.AddBrand(brand);
        return ResponseEntity.ok().header("Status", "Success").body(brand1);
    }
    @PostMapping("/AddCategory")
    public ResponseEntity<Category> AddNewCategory(@RequestBody AddCategory request)
    {
        Category category = dtoToEntityMapper.MapCategoryDTOToEntity(request);
        Category category1 = databaseService.AddCategory(category);
        return ResponseEntity.ok().header("Status", "Success").body(category1);
    }

    @PostMapping("/AddSubCategory")
    public ResponseEntity<Subcategory> AddNewSubCategory(@RequestBody AddSubcategory request)
    {
       // System.out.println("+++++++++++++++++++++++++++++++++++++" + request);
        String SubCategoryName = request.getSubCategoryName();
        //Long SubCategoryID = request.getSubCategoryID();
        Long CategoryID = request.getCategoryID();
        //System.out.println("*************************************************"+ CategoryID);
        Subcategory subcategory = databaseService.AddSubcategory(SubCategoryName,CategoryID);
        return ResponseEntity.ok().header("Status", "Success").body(subcategory);
    }
}
