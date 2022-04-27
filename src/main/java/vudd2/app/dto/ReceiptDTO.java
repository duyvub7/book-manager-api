package vudd2.app.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ReceiptDTO {
	
	private int id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createDate;
	
	private int amount;
	
	private int price;

	public ReceiptDTO() {
		super();
	}

	public ReceiptDTO(LocalDate createDate, int amount, int price) {
		super();
		this.createDate = createDate;
		this.amount = amount;
		this.price = price;
	}

	public ReceiptDTO(int id, LocalDate createDate, int amount, int price) {
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
	
}
