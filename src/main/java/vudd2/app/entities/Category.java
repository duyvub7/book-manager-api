package vudd2.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

/**
 * Class mapping to table Category in database
 *
 * @author VuDD2
 * FPT Software
 *
 */
@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", columnDefinition = "nvarchar(50)")
	@NotBlank
	@Length(max = 50)
	private String name;
	
	@Column(name = "description", columnDefinition = "nvarchar(1000)")
	@Length(max = 1000)
	private String description;
	
	@Column(name = "delete_flag", columnDefinition = "bit default 0")
	private boolean deleteFlag;

	public Category() {
		super();
	}
	
	public Category(int id, @NotBlank @Length(max = 50) String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category(int id, @NotBlank @Length(max = 50) String name, @Length(max = 1000) String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public Category(@NotBlank @Length(max = 50) String name, @Length(max = 1000) String description) {
		super();
		this.name = name;
		this.description = description;
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

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
}
