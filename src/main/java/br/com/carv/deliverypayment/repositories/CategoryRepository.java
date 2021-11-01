package br.com.carv.deliverypayment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carv.deliverypayment.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
