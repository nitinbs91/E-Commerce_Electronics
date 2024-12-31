package ecommerce.electronics.EcomElectronics.Configuration;

import ecommerce.electronics.EcomElectronics.DataBase.ProductModel;
import ecommerce.electronics.EcomElectronics.DataBase.Subcategory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationClass {

    @Bean
    public Subcategory subcategorybean()
    {
        Subcategory subcategory = new Subcategory();
        return subcategory;
    }

    @Bean
    public ProductModel productmodelbean()
    {
        ProductModel productModel = new ProductModel();
        return productModel;
    }
}
