package ecommerce.electronics.OrderManagement.Business;

import ecommerce.electronics.OrderManagement.ExceptionHandling.DatabaseException;
import ecommerce.electronics.OrderManagement.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class CallProductManagementServices {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${product.service.url}")
    private String ProductManagementURL;

    public Product FetchProductByID(Long ID)
    {
       // String logURL = ProductManagementURL + "/fetch/product/" + ID;
        //System.out.println("-------------------------------------->"+logURL);
        try{
//
                Optional<Product> product = Optional.ofNullable(restTemplate.getForObject(ProductManagementURL + "/fetch/product/" + ID, Product.class));
                return product.orElseThrow(() ->new DatabaseException("Product ID invalid"));
           }
        catch(RestClientException e)
        {
            throw new RestClientException("External service error");
        }
//

    }

    public void updateProductStock(Integer stock, Long productID)
    {
        System.out.println("--****>" + ProductManagementURL + "/UpdateProductStock/?productID=" + productID + "&" + "stock=" + stock);
        restTemplate.postForObject(ProductManagementURL + "/UpdateProductStock?productID=" + productID + "&" + "stock=" + stock,null, void.class );
    }
}
