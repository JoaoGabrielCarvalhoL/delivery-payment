package br.com.carv.deliverypayment.services;

import java.util.Optional;

import br.com.carv.deliverypayment.domain.Category;

public interface CategoryService {
	
	Optional<Category> findCategoryById(Long id);
	
	Category saveCategory(Category category);

}
