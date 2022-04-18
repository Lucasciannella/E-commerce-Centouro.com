package br.com.centouro.centouro.repository;

import br.com.centouro.centouro.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductsRepository  extends JpaRepository<Products,Long> {



}
