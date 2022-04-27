package vudd2.app.convert;

import java.util.ArrayList;
import java.util.List;

import vudd2.app.dto.BookDTO;
import vudd2.app.entities.Book;

public class BookConvert {
	
	public static Book ConvertDTOToEntity(BookDTO bookDTO) {
		if(bookDTO == null) {
			return null;
		}
		Book book = new Book(bookDTO.getId(), bookDTO.getName().trim(), bookDTO.getDescription().trim(), bookDTO.getQuantity(), 
				bookDTO.getPrice(), bookDTO.getPublisher().trim(), bookDTO.getPublishYear(), 
				bookDTO.getAuthor().trim(), false, CategoryConvert.ConvertDTOToEntity(bookDTO.getCategoryDTO()));
		return book;
	}
	
	public static Book ConvertDTOToEntityWithoutId(BookDTO bookDTO) {
		if(bookDTO == null) {
			return null;
		}
		Book book = new Book(bookDTO.getName().trim(), bookDTO.getDescription().trim(), bookDTO.getQuantity(), 
				bookDTO.getPrice(), bookDTO.getPublisher().trim(), bookDTO.getPublishYear(), 
				bookDTO.getAuthor().trim(), false, CategoryConvert.ConvertDTOToEntity(bookDTO.getCategoryDTO()));
		return book;
	}
	
	public static BookDTO ConvertEntityToDTO(Book book) {
		if(book == null) {
			return null;
		}
		BookDTO bookDTO = new BookDTO(book.getId(), book.getName(), book.getDescription(), book.getQuantity(), 
				book.getPrice(), book.getPublisher(), book.getPublishYear(), book.getAuthor(), 
				book.getCategory().getId(), book.getCategory().getName(), CategoryConvert.ConvertEntityToDTO(book.getCategory()));
		return bookDTO;
	}
	
	public static List<Book> ConvertListDTOToListEntity(List<BookDTO> listBookDTO) {
		List<Book> listBook = new ArrayList<>();
		if(listBookDTO != null && listBookDTO.size() > 0) {
			for(BookDTO bookDTO : listBookDTO) {
				listBook.add(ConvertDTOToEntity(bookDTO));
			}
		}
		return listBook;
	}
	
	public static List<BookDTO> ConvertListEntityToListDTO(List<Book> listBook) {
		List<BookDTO> listBookDTO = new ArrayList<>();
		if(listBook != null && listBook.size() > 0) {
			for(Book book : listBook) {
				listBookDTO.add(ConvertEntityToDTO(book));
			}
		}
		return listBookDTO;
	}
}
