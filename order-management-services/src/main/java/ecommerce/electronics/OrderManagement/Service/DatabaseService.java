package ecommerce.electronics.OrderManagement.Service;

import ecommerce.electronics.OrderManagement.Database.order_management;
import ecommerce.electronics.OrderManagement.Database.order_managementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    private order_managementRepository orderManagementRepository;

    public List<order_management> FetchOrders()
    {
        return orderManagementRepository.findAll();
    }

    public Optional<order_management> FetchOrderByID(Long id)
    {
        return orderManagementRepository.findById(id);
    }

    public order_management InsertOrder(order_management order_management)
    {
        order_management order_management1 = new order_management();
        return orderManagementRepository.save(order_management);
    }
}
