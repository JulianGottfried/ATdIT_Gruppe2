package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Categories")
public class Categories extends AbstractEntry {
	@Id
	private int 	CategoryID;
	private String 	TableName;
	 
	public Categories() {
	}

	public Categories(int categoryID, String tableName) {
		CategoryID = categoryID;
		TableName = tableName;
	} 
	 
	public int getCategoryID() {
		return CategoryID;
	}
	
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	
	public String getTableName() {
		return TableName;
	}
	
	public void setTableName(String tableName) {
		TableName = tableName;
	}
}
