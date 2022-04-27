package vudd2.app.service;

import java.util.List;

import vudd2.app.dto.BookDTO;
import vudd2.app.dto.SortDTO;

/**
 * Interface define methods of table Book
 *
 * @author VuDD2
 * FPT Software
 *
 */
public abstract class BookService {
	public abstract List<BookDTO> findAll();
	public abstract List<BookDTO> findAllAvailable();
	public abstract List<BookDTO> findAllAvailable(SortDTO sortDTO);
	public abstract List<BookDTO> findAllAvailableByCategory(int categoryId, SortDTO sortDTO);
	public abstract List<BookDTO> searchByName(String name);
	public abstract List<BookDTO> searchByName(String name, SortDTO sortDTO);
	public abstract BookDTO getByID(int id);
	public abstract boolean checkExistById(int bookId);
	public abstract boolean checkExistByCategoryId(int categoryId);
	public abstract boolean checkExistByName(String bookName);
	public abstract boolean addBook(BookDTO bookDTO);
	public abstract boolean updateBook(BookDTO bookDTO);
	public abstract boolean deleteBook(int bookId);
	
}
