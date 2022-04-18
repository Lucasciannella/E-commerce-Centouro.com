package br.com.centouro.centouro.service;

import br.com.centouro.centouro.Entity.Products;
import br.com.centouro.centouro.dto.ProductsPostRequestBody;
import br.com.centouro.centouro.dto.ProductsPutRequestBody;
import br.com.centouro.centouro.exceptions.BadRequestException;
import br.com.centouro.centouro.mapper.ProductMapper;
import br.com.centouro.centouro.repository.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    //SOLID injectable on constructor
    private final ProductsRepository repository;


    public List<Products>ListALl(){
        return repository.findAll();
    }

    public Page<Products> ListallPageable(Pageable pageable){
        return repository.findAll(pageable);
    }

    @Transactional
    public Products save(ProductsPostRequestBody productsPostRequestBody) {
            return repository.save(ProductMapper.INSTANCE.toProduct(productsPostRequestBody));
    }

    public Products findByIdOrThrowBadRequestException(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new BadRequestException("Product Not Found"));

    }


    public void delete(Long id){
        repository.delete(findByIdOrThrowBadRequestException(id));

    }

    public void update(ProductsPutRequestBody productsPutRequestBody){
        Products savedProduct = findByIdOrThrowBadRequestException(productsPutRequestBody.getId());
        Products products = ProductMapper.INSTANCE.toProduct(productsPutRequestBody);
        products.setId(savedProduct.getId());
        repository.save(products);
    }



}
