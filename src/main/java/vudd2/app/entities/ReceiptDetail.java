package vudd2.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

/**
 * Class mapping to table ReceiptDetail in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Entity
public class ReceiptDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Min(value = 0)
	private int quantity;
	
	@Min(value = 0)
	private int price;
	
	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "receipt_id")
	private Receipt receipt;

	public ReceiptDetail() {
		super();
	}

	public ReceiptDetail(@Min(0) int quantity, @Min(0) int price, Book book, Receipt receipt) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.book = book;
		this.receipt = receipt;
	}

	public ReceiptDetail(int id, @Min(0) int quantity, @Min(0) int price, Book book, Receipt receipt) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.book = book;
		this.receipt = receipt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	
}
