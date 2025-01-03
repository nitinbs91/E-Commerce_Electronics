package ecommerce.electronics.OrderManagement.Business;

import ecommerce.electronics.OrderManagement.Database.order_management;
import ecommerce.electronics.OrderManagement.dto.AddOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DtoToDatabseMapper {

    DtoToDatabseMapper INSTANCE = Mappers.getMapper(DtoToDatabseMapper.class);

    order_management MapOrderManagementDTOToDatabase(AddOrder addOrder);
}
