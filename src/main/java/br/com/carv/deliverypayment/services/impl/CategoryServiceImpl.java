package br.com.carv.deliverypayment.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.carv.deliverypayment.domain.Category;
import br.com.carv.deliverypayment.repositories.CategoryRepository;
import br.com.carv.deliverypayment.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Optional<Category> findCategoryById(Long id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		return category;
		
	}

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

}
