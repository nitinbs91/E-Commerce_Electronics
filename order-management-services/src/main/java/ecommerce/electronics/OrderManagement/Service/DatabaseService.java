package ecommerce.electronics.OrderManagement.Service;

import ecommerce.electronics.OrderManagement.Database.order_management;
import ecommerce.electronics.OrderManagement.Database.order_managementRepository;
import ecommerce.electronics.OrderManagement.ExceptionHandling.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DatabaseService {

    @Autowired
    private order_managementRepository orderManagementRepository;

    public List<order_management> FetchOrders()
    {
        try {
            return orderManagementRepository.findAll();
        }
        catch(DataAccessException ex)
        {
            throw new DatabaseException("DB Exception", ex);
        }
    }

    public Optional<order_management> FetchOrderByID(Long id)
    {
        try {
            return orderManagementRepository.findById(id);
        }  catch(DataAccessException ex)
        {
            throw new DatabaseException("DB Exception", ex);
        }
    }

    public order_management InsertOrder(order_management order_management)
    {
        try {
            order_management order_management1 = new order_management();
            return orderManagementRepository.save(order_management);
        }  catch(DataAccessException ex)
        {
            throw new DatabaseException("DB Exception", ex);
        }
    }
}
