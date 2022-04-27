package vudd2.app.dto;

/**
 * Class used to transfer data communicate with UI
 *
 * @author VuDD2
 * FPT Software
 *
 */
public class CategoryDTO {
	
	private int id;
	private String name;
	private String description;
	private long amount;
	
	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(int id) {
		super();
		this.id = id;
	}
	
	public CategoryDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CategoryDTO(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public CategoryDTO(int id, String name, String description, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.amount = amount;
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
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	
}
