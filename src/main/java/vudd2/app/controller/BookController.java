package vudd2.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vudd2.app.dto.BookDTO;
import vudd2.app.dto.SortDTO;
import vudd2.app.service.impl.BookServiceImpl;

/**
 * Controller of Book to communicate with UI
 *
 * @author VuDD2
 * FPT Software
 *
 */
@RestController
@CrossOrigin()
@RequestMapping(value = "/api/book")
public class BookController {
	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	@GetMapping(value = "get-all")
	public ResponseEntity<?> getAllBook() {
		return new ResponseEntity<>(bookServiceImpl.findAllAvailable(new SortDTO("id", true)), HttpStatus.OK);
	}
	
	@PostMapping(value = "get-all-sorting")
	public ResponseEntity<?> getAllBookAndSort(@RequestBody SortDTO sortDTO) {
		return new ResponseEntity<>(bookServiceImpl.findAllAvailable(sortDTO), HttpStatus.OK);
	}
	
	@PostMapping(value = "get-all-by-category/{id}")
	public ResponseEntity<?> getAllBookByCategory(@PathVariable("id") int id, @RequestBody SortDTO sortDTO) {
		return new ResponseEntity<>(bookServiceImpl.findAllAvailableByCategory(id, sortDTO), HttpStatus.OK);
	}
	
	@PostMapping(value = "search/{name}")
	public ResponseEntity<?> searchBookByName(@PathVariable("name") String name, @RequestBody SortDTO sortDTO) {
		return new ResponseEntity<>(bookServiceImpl.searchByName(name, sortDTO), HttpStatus.OK);
	}
	
	@GetMapping(value = "get-book-info/{id}")
	public ResponseEntity<?> getBookInfo(@PathVariable("id") int id) {
		return new ResponseEntity<>(bookServiceImpl.getByID(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "check-id-existed/{id}")
	public ResponseEntity<?> checkExistId(@PathVariable("id") int id) {
		return new ResponseEntity<>(bookServiceImpl.checkExistById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "check-existed-in-category/{id}")
	public ResponseEntity<?> checkExistInCategory(@PathVariable("id") int id) {
		return new ResponseEntity<>(bookServiceImpl.checkExistByCategoryId(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "check-name-existed/{name}")
	public ResponseEntity<?> checkExistName(@PathVariable("name") String name) {
		return new ResponseEntity<>(bookServiceImpl.checkExistByName(name), HttpStatus.OK);
	}
	
	@PostMapping(value = "create")
	public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO) {
		return new ResponseEntity<>(bookServiceImpl.addBook(bookDTO), HttpStatus.OK);
	}
	
	@PutMapping(value = "update")
	public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO) {
		return new ResponseEntity<>(bookServiceImpl.updateBook(bookDTO), HttpStatus.OK);
	}
	
	@PutMapping(value = "delete")
	public ResponseEntity<?> deleteBook(@RequestBody int id) {
		return new ResponseEntity<>(bookServiceImpl.deleteBook(id), HttpStatus.OK);
	}
}
