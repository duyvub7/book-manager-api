package vudd2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vudd2.app.dto.CategoryDTO;
import vudd2.app.dto.SortDTO;
import vudd2.app.service.impl.CategoryServiceImpl;

/**
 * Controller of Category to communicate with UI
 *
 * @author VuDD2
 * FPT Software
 *
 */
@RestController
@CrossOrigin()
@RequestMapping(value = "/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryServiceImpl categoryServiceImpl;
	
	@GetMapping(value = "get-all")
	public ResponseEntity<?> getAllCategory() {
		return new ResponseEntity<>(categoryServiceImpl.findAllAvailable(), HttpStatus.OK);
	}
	
	@PostMapping(value = "get-all-sorting")
	public ResponseEntity<?> getAllCategoryAndSort(@RequestBody SortDTO sortDTO) {
		return new ResponseEntity<>(categoryServiceImpl.findAllAvailable(sortDTO), HttpStatus.OK);
	}
	
	@PostMapping(value = "search/{name}")
	public ResponseEntity<?> searchCategoryByName(@PathVariable("name") String name, @RequestBody SortDTO sortDTO) {
		return new ResponseEntity<>(categoryServiceImpl.searchByName(name, sortDTO), HttpStatus.OK);
	}
	
	@GetMapping(value = "get-category-info/{id}")
	public ResponseEntity<?> getCategoryInfo(@PathVariable("id") int id) {
		return new ResponseEntity<>(categoryServiceImpl.getById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "check-id-existed/{id}")
	public ResponseEntity<?> checkExistId(@PathVariable("id") int id) {
		return new ResponseEntity<>(categoryServiceImpl.checkExistById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "check-name-existed/{name}")
	public ResponseEntity<?> checkExistName(@PathVariable("name") String name) {
		return new ResponseEntity<>(categoryServiceImpl.checkExistByName(name), HttpStatus.OK);
	}
	
	@PostMapping(value = "create")
	public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryServiceImpl.addCategory(categoryDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PutMapping(value = "update")
	public ResponseEntity<?> updateCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryServiceImpl.updateCategory(categoryDTO);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PutMapping(value = "edit")
	public ResponseEntity<?> editCategory() {	
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable("id") int id) {
		categoryServiceImpl.deleteCategory(id);
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
