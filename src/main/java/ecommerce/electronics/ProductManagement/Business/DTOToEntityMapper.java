package ecommerce.electronics.ProductManagement.Business;

import ecommerce.electronics.ProductManagement.DataBase.Brand;
import ecommerce.electronics.ProductManagement.DataBase.Category;
import ecommerce.electronics.ProductManagement.dto.AddBrand;
import ecommerce.electronics.ProductManagement.dto.AddCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface DTOToEntityMapper {

    DTOToEntityMapper INSTANCE = Mappers.getMapper(DTOToEntityMapper.class);

   // ProductModel MapProductDTOToEntity(AddProduct product);

    //@Mapping(target = "brandName", source = "BrandName")
    Brand MapBrandDTOToEntity(AddBrand brand);

    Category MapCategoryDTOToEntity(AddCategory category);

   // Subcategory MapSubcategoryDTOToEntity(AddSubcategory subcategory);


}
