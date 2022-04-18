package br.com.centouro.centouro.mapper;

import br.com.centouro.centouro.Entity.Products;
import br.com.centouro.centouro.dto.ProductsPostRequestBody;
import br.com.centouro.centouro.dto.ProductsPutRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class ProductMapper {
    public static final ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    public abstract Products toProduct(ProductsPostRequestBody productsPostRequestBody);
    public abstract Products toProduct(ProductsPutRequestBody productsPutRequestBody);



}
