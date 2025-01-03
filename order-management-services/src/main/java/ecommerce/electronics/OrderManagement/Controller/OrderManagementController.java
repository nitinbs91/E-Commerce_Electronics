package ecommerce.electronics.OrderManagement.Controller;

import ecommerce.electronics.OrderManagement.Business.DtoToDatabseMapper;
import ecommerce.electronics.OrderManagement.Database.order_management;
import ecommerce.electronics.OrderManagement.Service.DatabaseService;
import ecommerce.electronics.OrderManagement.dto.AddOrder;
import ecommerce.electronics.OrderManagement.dto.OrderManagementServiceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderManagementController {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    DtoToDatabseMapper dtoToDatabseMapper;

    @GetMapping("/FetchAllOrders")
    public List<order_management> FetchAllOrders()
    {
        return databaseService.FetchOrders();
    }

    @GetMapping("/FetchOrderByID/{ID}")
    public Optional<order_management> FetchOrdersByID(@PathVariable Long ID)
    {
        return databaseService.FetchOrderByID(ID);
    }

    @PostMapping("/AddOrder")
    public ResponseEntity<OrderManagementServiceResponse> AddOrder(@RequestBody AddOrder addOrder)
    {
        order_management order_management = dtoToDatabseMapper.MapOrderManagementDTOToDatabase(addOrder);
        order_management order_management1 = databaseService.InsertOrder(order_management);
        OrderManagementServiceResponse response = new OrderManagementServiceResponse();
        response.setorderID(order_management1.getOrderId());
        return ResponseEntity.ok().body(response);

    }
}
