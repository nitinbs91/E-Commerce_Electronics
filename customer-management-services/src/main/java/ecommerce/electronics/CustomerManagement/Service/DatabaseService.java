package ecommerce.electronics.CustomerManagement.Service;

import ecommerce.electronics.CustomerManagement.Database.customer_management;
import ecommerce.electronics.CustomerManagement.Database.customer_managementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService
{
    @Autowired
    private customer_managementRepository customerManagementRepository;

    public Optional<customer_management> FetchCustomerByID(Integer customerID)
    {
        return customerManagementRepository.findById(customerID);
    }

    public List<customer_management> FetchAllCustomers()
    {
        return customerManagementRepository.findAll();
    }

    public customer_management AddCustomer(customer_management customerManagement)
    {
        return customerManagementRepository.save(customerManagement);
    }

}
