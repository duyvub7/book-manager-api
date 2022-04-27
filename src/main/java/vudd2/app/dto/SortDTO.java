package vudd2.app.dto;

public class SortDTO {
	
	private String columnName;
	private boolean sortDesc;
	
	public SortDTO() {
		super();
	}

	public SortDTO(String columnName, boolean sortDesc) {
		super();
		this.columnName = columnName;
		this.sortDesc = sortDesc;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean isSortDesc() {
		return sortDesc;
	}

	public void setSortDesc(boolean sortDesc) {
		this.sortDesc = sortDesc;
	}
	
}
