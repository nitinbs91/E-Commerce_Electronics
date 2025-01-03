package ecommerce.electronics.ProductManagement.Configuration;

import ecommerce.electronics.ProductManagement.DataBase.ProductModel;
import ecommerce.electronics.ProductManagement.DataBase.Subcategory;
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
