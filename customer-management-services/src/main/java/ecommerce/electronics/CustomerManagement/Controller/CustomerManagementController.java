package ecommerce.electronics.CustomerManagement.Controller;

import ecommerce.electronics.CustomerManagement.Database.customer_management;
import ecommerce.electronics.CustomerManagement.Service.DatabaseService;
import ecommerce.electronics.CustomerManagement.Service.MapDTOToDatabase;
import ecommerce.electronics.CustomerManagement.dto.AddCustomer;
import ecommerce.electronics.CustomerManagement.dto.CustomerManagementServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerManagementController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private MapDTOToDatabase mapDTOToDatabase;

    @PostMapping("/AddCustomer")
    public ResponseEntity<CustomerManagementServiceResponse> AddCustomer(@RequestBody AddCustomer addCustomer)
    {
        customer_management customer = mapDTOToDatabase.MapCustomerManagementDTOToDatabase(addCustomer);
        customer_management customerManagement = databaseService.AddCustomer(customer);
        CustomerManagementServiceResponse response = new CustomerManagementServiceResponse();
        response.setMessage("Customer added!");
        response.setCustomerID(customerManagement.getCustomerId());
        return ResponseEntity.ok(response);
    }
}
