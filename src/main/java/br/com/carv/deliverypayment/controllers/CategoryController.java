package br.com.carv.deliverypayment.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carv.deliverypayment.domain.Category;
import br.com.carv.deliverypayment.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	@RequestMapping(method = RequestMethod.GET, value = "/findCategoryById/{id}" )
	public ResponseEntity<?> findCategoryById(@PathVariable("id") Long id) {
		Optional<Category> category = categoryService.findCategoryById(id); 
		
		if (category.isPresent()) {
			return ResponseEntity.ok().body(category.get());
		} else {
			return ResponseEntity.badRequest().body(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveCategory")
	public ResponseEntity<?> saveCategory(@RequestBody Category category) {
		
		Category categoryToBeSaved = categoryService.saveCategory(category); 
		return new ResponseEntity<Category>(categoryToBeSaved, HttpStatus.CREATED);
		
		
		
	}
	
	
	

}
