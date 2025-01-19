package ecommerce.electronics.CustomerManagement.Service;

import ecommerce.electronics.CustomerManagement.Database.customer_management;
import ecommerce.electronics.CustomerManagement.dto.AddCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MapDTOToDatabase {
    MapDTOToDatabase INSTANCE = Mappers.getMapper(MapDTOToDatabase.class);
    customer_management MapCustomerManagementDTOToDatabase(AddCustomer addCustomer);
}
