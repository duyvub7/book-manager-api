package vudd2.app.dto;

/**
 * Class used to transfer data communicate with UI
 *
 * @author VuDD2
 * FPT Software
 *
 */
public class BookDTO {
	
	private int id;
	private String name;
	private String description;
	private int quantity;
	private int price;
	private String publisher;
	private int publishYear;
	private String author;
	private CategoryDTO categoryDTO;
	private int categoryId;
	private String categoryName;
	
	public BookDTO() {
		super();
	}
	
	public BookDTO(int id, String name, String description, int quantity, int price, String publisher,
			int publishYear, String author, int categoryId, String categoryName, CategoryDTO categoryDTO) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.author = author;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDTO = categoryDTO;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPublishYear() {
		return publishYear;
	}
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public CategoryDTO getCategoryDTO() {
		return categoryDTO;
	}

	public void setCategoryDTO(CategoryDTO categoryDTO) {
		this.categoryDTO = categoryDTO;
	}
	
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
