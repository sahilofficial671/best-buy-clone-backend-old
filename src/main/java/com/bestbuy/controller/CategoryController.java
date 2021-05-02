package com.bestbuy.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestbuy.model.Category;
import com.bestbuy.service.CategoryService;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/categories")
	public ResponseEntity<List<Category>> getCategories(){
		List<Category> categorys = categoryService.getCategories();
		return new ResponseEntity<List<Category>>(categorys, HttpStatus.OK);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<Category> getCategory(@PathVariable("id") Integer id){
		Category category = categoryService.getCategory(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PostMapping("/category/submit")
	public ResponseEntity<String> addCategory(@Valid @RequestBody Category category){
		if(categoryService.add(category)) {
			return new ResponseEntity<String>("Category Added.", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@PutMapping("/category/update")
	public ResponseEntity<String> updateCategory(@Valid @RequestBody Category category){
		if(! categoryService.exists(category.getId())) {
			return new ResponseEntity<String>("Category not found.", HttpStatus.NOT_FOUND);
		}
		
		if(categoryService.update(category)) {
			return new ResponseEntity<String>("Category Updated.", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
	
	@DeleteMapping("/category/delete/{id}")
	public ResponseEntity<String> updateCategory(@PathVariable("id") Integer id){
		if(! categoryService.exists(id)) {
			return new ResponseEntity<String>("Category not found.", HttpStatus.NOT_FOUND);
		}
		
		Category category = categoryService.getCategory(id);
		if(category.getProducts().size() > 0) {
			return new ResponseEntity<String>("Category is assigned to products.", HttpStatus.BAD_REQUEST);
		}
		
		if(categoryService.delete(id)) {
			return new ResponseEntity<String>("Category Deleted.", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Something went wrong!", HttpStatus.NOT_IMPLEMENTED);
	}
}
