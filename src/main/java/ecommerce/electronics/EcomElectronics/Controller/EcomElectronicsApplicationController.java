package ecommerce.electronics.EcomElectronics.Controller;

import ecommerce.electronics.EcomElectronics.DataBase.Brand;
import ecommerce.electronics.EcomElectronics.DataBase.Category;
import ecommerce.electronics.EcomElectronics.DataBase.ProductModel;
import ecommerce.electronics.EcomElectronics.DataBase.Subcategory;
import ecommerce.electronics.EcomElectronics.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EcomElectronicsApplicationController {

    @Autowired
    private DatabaseService databaseService;

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
}
