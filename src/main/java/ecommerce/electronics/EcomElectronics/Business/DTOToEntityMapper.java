package ecommerce.electronics.EcomElectronics.Business;

import ecommerce.electronics.EcomElectronics.DataBase.Brand;
import ecommerce.electronics.EcomElectronics.DataBase.Category;
import ecommerce.electronics.EcomElectronics.DataBase.ProductModel;
import ecommerce.electronics.EcomElectronics.DataBase.Subcategory;
import ecommerce.electronics.EcomElectronics.dto.AddBrand;
import ecommerce.electronics.EcomElectronics.dto.AddCategory;
import ecommerce.electronics.EcomElectronics.dto.AddProduct;
import ecommerce.electronics.EcomElectronics.dto.AddSubcategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
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
