package ecommerce.electronics.EcomElectronics.Controller;

import ecommerce.electronics.EcomElectronics.Business.DTOToEntityMapper;
import ecommerce.electronics.EcomElectronics.DataBase.Brand;
import ecommerce.electronics.EcomElectronics.DataBase.Category;
import ecommerce.electronics.EcomElectronics.DataBase.ProductModel;
import ecommerce.electronics.EcomElectronics.DataBase.Subcategory;
import ecommerce.electronics.EcomElectronics.Service.DatabaseService;
import ecommerce.electronics.EcomElectronics.dto.AddBrand;
import ecommerce.electronics.EcomElectronics.dto.AddCategory;
import ecommerce.electronics.EcomElectronics.dto.AddProduct;
import ecommerce.electronics.EcomElectronics.dto.AddSubcategory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void AddNewProduct(@RequestBody AddProduct request)
    {
       //Integer productID = request.getProductId();
       String productName = request.getProductName();
       Long brandID = request.getBrand();
       Long categoryID = request.getCategory();
       Long subcategoryID = request.getSubcategory();
       BigDecimal price = request.getPrice();
       Integer stockQuantity = request.getStockQuantity();
       databaseService.AddProduct(productName, brandID, categoryID, subcategoryID, price, stockQuantity);

    }
    @PostMapping("/AddBrand")
    public void AddNewBrand(@RequestBody AddBrand request)
    {
        Brand brand = dtoToEntityMapper.MapBrandDTOToEntity(request);
        databaseService.AddBrand(brand);
    }
    @PostMapping("/AddCategory")
    public void AddNewCategory(@RequestBody AddCategory request)
    {
        Category category = dtoToEntityMapper.MapCategoryDTOToEntity(request);
        databaseService.AddCategory(category);
    }

    @PostMapping("/AddSubCategory")
    public void AddNewSubCategory(@RequestBody AddSubcategory request)
    {
        System.out.println("+++++++++++++++++++++++++++++++++++++" + request);
        String SubCategoryName = request.getSubCategoryName();
        //Long SubCategoryID = request.getSubCategoryID();
        Long CategoryID = request.getCategoryID();
        System.out.println("*************************************************"+ CategoryID);
        databaseService.AddSubcategory(SubCategoryName,CategoryID);
    }
}
