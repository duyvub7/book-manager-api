package vudd2.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Class mapping to table Receipt in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Entity
public class Receipt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "createDate", columnDefinition = "date")
	private LocalDate createDate;
	
	@Min(value = 0)
	private int amount;
	
	@Min(value = 0)
	private int price;
	
	@NotBlank
	@Length(max = 100)
	@Column(name = "customer", columnDefinition = "nvarchar(100)")
	private String customer;
	
	public Receipt() {
		super();
	}

	public Receipt(LocalDate createDate, @Min(0) int amount, @Min(0) int price) {
		super();
		this.createDate = createDate;
		this.amount = amount;
		this.price = price;
	}

	public Receipt(LocalDate createDate, @Min(0) int amount, @Min(0) int price, String customer) {
		super();
		this.createDate = createDate;
		this.amount = amount;
		this.price = price;
		this.customer = customer;
	}

	public Receipt(int id, LocalDate createDate, @Min(0) int amount, @Min(0) int price) {
		super();
		this.id = id;
		this.createDate = createDate;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}
	
}
