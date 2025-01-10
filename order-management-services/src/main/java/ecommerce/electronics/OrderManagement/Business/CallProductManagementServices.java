package ecommerce.electronics.OrderManagement.Business;

import ecommerce.electronics.OrderManagement.ExceptionHandling.DatabaseException;
import ecommerce.electronics.OrderManagement.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CallProductManagementServices {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String ProductManagementURL;

    public Optional<Product> FetchProductByID(Long ID)
    {
        String logURL = ProductManagementURL + "/fetch/product/" + ID;
        System.out.println("-------------------------------------->"+logURL);
        Optional<Product> product = Optional.ofNullable(restTemplate.getForObject(ProductManagementURL + "/fetch/product/" + ID, Product.class));
        if(product.isPresent())
        {
           // System.out.println("Code to be added");
            return product;
        }
        else
        {
            throw new DatabaseException("Product not present in Database");
        }


    }
}
