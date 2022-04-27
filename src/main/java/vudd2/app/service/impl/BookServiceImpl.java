package vudd2.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import vudd2.app.common.StringUtil;
import vudd2.app.convert.BookConvert;
import vudd2.app.convert.CategoryConvert;
import vudd2.app.dto.BookDTO;
import vudd2.app.dto.SortDTO;
import vudd2.app.entities.Book;
import vudd2.app.repository.BookRepository;
import vudd2.app.repository.CategoryRepository;
import vudd2.app.service.BookService;
import vudd2.app.util.Validator;

/**
 * Interface contain methods of table Book
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Service
public class BookServiceImpl extends BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<BookDTO> findAll() {
		return BookConvert.ConvertListEntityToListDTO(bookRepository.findAll());
	}

	@Override
	public List<BookDTO> findAllAvailable() {
		return BookConvert.ConvertListEntityToListDTO(bookRepository.findAllByDeleteFlagFalse());
	}
	
	@Override
	public List<BookDTO> findAllAvailable(SortDTO sortDTO) {
		Sort sort = null;
		if(sortDTO.isSortDesc()) {
			sort = Sort.by(Sort.Direction.DESC, sortDTO.getColumnName());
		}else {
			sort = Sort.by(Sort.Direction.ASC, sortDTO.getColumnName());
		}
		return BookConvert.ConvertListEntityToListDTO(bookRepository.findAllByDeleteFlagFalse(sort));
	}
	
	@Override
	public List<BookDTO> findAllAvailableByCategory(int categoryId, SortDTO sortDTO) {
		Sort sort = null;
		if(sortDTO.isSortDesc()) {
			sort = Sort.by(Sort.Direction.DESC, sortDTO.getColumnName());
		}else {
			sort = Sort.by(Sort.Direction.ASC, sortDTO.getColumnName());
		}
		return BookConvert.ConvertListEntityToListDTO(bookRepository.findAllByCategoryIdAndDeleteFlagFalse(categoryId, sort));
	}
	
	@Override
	public boolean checkExistById(int id) {
		return bookRepository.existsByIdAndDeleteFlagFalse(id);
	}
	
	@Override
	public boolean checkExistByCategoryId(int categoryId) {
		return bookRepository.existsByCategoryIdAndDeleteFlagFalse(categoryId);
	}

	@Override
	public boolean checkExistByName(String bookName) {
		return bookRepository.existsByNameAndDeleteFlagFalseIgnoreCase(bookName.trim());
	}
	
	@Override
	public BookDTO getByID(int id) {
		return BookConvert.ConvertEntityToDTO(bookRepository.findByIdAndDeleteFlagFalse(id));
	}
	
	@Override
	public List<BookDTO> searchByName(String name) {
		List<BookDTO> listBookDTO = BookConvert.ConvertListEntityToListDTO(bookRepository.findAllByDeleteFlagFalse());
		List<BookDTO> result = new ArrayList<>();
		for(BookDTO bookDTO : listBookDTO) {
			if( StringUtil.FixString(bookDTO.getName()).toLowerCase().contains( 
					StringUtil.FixString(name.trim()).toLowerCase() ) ) {
				result.add(bookDTO);
			}
		}
		return result;
	}
	
	@Override
	public List<BookDTO> searchByName(String name, SortDTO sortDTO) {
		Sort sort = null;
		if(sortDTO.isSortDesc()) {
			sort = Sort.by(Sort.Direction.DESC, sortDTO.getColumnName());
		}else {
			sort = Sort.by(Sort.Direction.ASC, sortDTO.getColumnName());
		}
		List<BookDTO> listBookDTO  = BookConvert.ConvertListEntityToListDTO(bookRepository.findAllByDeleteFlagFalse(sort));
		List<BookDTO> result = new ArrayList<>();
		for(BookDTO bookDTO : listBookDTO) {
			if( StringUtil.FixString(bookDTO.getName()).toLowerCase().contains( 
					StringUtil.FixString(name.trim()).toLowerCase() ) ) {
				result.add(bookDTO);
			}
		}
		return result;
	}

	@Override
	public boolean addBook(BookDTO bookDTO) {
		if(bookDTO == null || !Validator.BookValidate(bookDTO)) {
			return false;
		}
		bookDTO.setCategoryDTO(CategoryConvert.ConvertEntityToDTO(
				categoryRepository.findByIdAndDeleteFlagFalse(bookDTO.getCategoryId())));
		Book book = BookConvert.ConvertDTOToEntityWithoutId(bookDTO);
		bookRepository.save(book);
		return true;
	}

	@Override
	public boolean updateBook(BookDTO bookDTO) {
		if(bookDTO == null || !Validator.BookValidate(bookDTO)) {
			return false;
		}
		bookDTO.setCategoryDTO(CategoryConvert.ConvertEntityToDTO(
				categoryRepository.findByIdAndDeleteFlagFalse(bookDTO.getCategoryId())));
		bookRepository.save(BookConvert.ConvertDTOToEntity(bookDTO));
		return true;
	}

	@Override
	public boolean deleteBook(int bookId) {
		Book book = bookRepository.findByIdAndDeleteFlagFalse(bookId);
		if(book != null) {
			book.setDeleteFlag(true);
			bookRepository.save(book);
			return true;
		}
		return false;
	}

}
