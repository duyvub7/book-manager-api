package vudd2.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


/**
 * Class mapping to table Book in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Length(max = 100)
	@Column(name = "name", columnDefinition = "nvarchar(100)")
	private String name;
	
	@Length(max = 1000)
	@Column(name = "description", columnDefinition = "nvarchar(1000)")
	private String description;
	
	@Min(value = 0)
	private int quantity;
	
	@Min(value = 0)
	private int price;
	
	@Column(name = "publisher", columnDefinition = "nvarchar(100)")
	@NotBlank
	@Length(max = 100)
	private String publisher;
	
	@Column(name = "publish_year", columnDefinition = "int")
	private int publishYear;
	
	@NotBlank
	@Length(max = 100)
	@Column(name = "author", columnDefinition = "nvarchar(100)")
	private String author;
	
	@Column(name = "delete_flag", columnDefinition = "bit default 0")
	private boolean deleteFlag;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	public Book() {
		super();
	}
	
	public Book(@NotBlank @Length(max = 100) String name, @Length(max = 1000) String description,
			@NotBlank @Min(0) int quantity, @NotBlank @Min(0) int price, @Max(200) String publisher, int publishYear,
			@NotBlank String author, boolean deleteFlag, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.author = author;
		this.deleteFlag = deleteFlag;
		this.category = category;
	}
	
	public Book(int id, @NotBlank @Length(max = 100) String name, @Length(max = 1000) String description,
			@NotBlank @Min(0) int quantity, @NotBlank @Min(0) int price, @Max(200) String publisher, int publishYear,
			@NotBlank String author, boolean deleteFlag, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.author = author;
		this.deleteFlag = deleteFlag;
		this.category = category;
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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
