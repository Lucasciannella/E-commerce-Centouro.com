package br.com.centouro.centouro.controller;


import br.com.centouro.centouro.Entity.Products;
import br.com.centouro.centouro.dto.ProductsPostRequestBody;
import br.com.centouro.centouro.dto.ProductsPutRequestBody;
import br.com.centouro.centouro.service.ProductsService;
import br.com.centouro.centouro.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/products")
@Log4j2
@RequiredArgsConstructor
public class ProductsController {

    private final DateUtil dateUtil;

    private final ProductsService productsService;


    @GetMapping
    public ResponseEntity<Page<Products>> ListAllPageable(Pageable pageable) {
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(productsService.ListallPageable(pageable));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Products>> listAll(){
        log.info(dateUtil.formatLocalDateTimetoDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(productsService.ListALl());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Products> findById(@PathVariable Long id){
        return ResponseEntity.ok(productsService.findByIdOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Products> save(@RequestBody ProductsPostRequestBody productsPostRequestBody){
        return  new ResponseEntity<>(productsService.save(productsPostRequestBody),HttpStatus.CREATED );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Products> delete(@PathVariable Long id){
        productsService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PutMapping
    public ResponseEntity<Products> update(@RequestBody ProductsPutRequestBody productsPutRequestBody ){
        productsService.update(productsPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
