package ecommerce.electronics.EcomElectronics.Controller;

import ecommerce.electronics.EcomElectronics.DataBase.ProductModel;
import ecommerce.electronics.EcomElectronics.Service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EcomElectronicsApplicationController {

    @Autowired
    private DatabaseService databaseService;

    @GetMapping("/all")
    public List<ProductModel> ReturnAllProducts()
    {
        return databaseService.FetchAllProductModels();
    }
}
