package br.com.carv.deliverypayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carv.deliverypayment.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
