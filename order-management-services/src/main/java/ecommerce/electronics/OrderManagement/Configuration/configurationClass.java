package ecommerce.electronics.OrderManagement.Configuration;

import ecommerce.electronics.OrderManagement.dto.AddOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class configurationClass {

    @Bean
    public AddOrder addOrderBean()
    {
        AddOrder addOrder = new AddOrder();
        return addOrder;
    }
}
