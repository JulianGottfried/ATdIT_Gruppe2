package main.java.persistence.databaseTables;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tokens")
public class Tokens extends AbstractEntry {
	@Id
	private int	Token;
	private int	CategoryID;
	private int	ProcessID;
	
	public Tokens() {
	}
	
	public Tokens(int token, int categoryID, int processID) {
		Token = token;
		CategoryID = categoryID;
		ProcessID = processID;
	}
	
	public int getToken() {
		return Token;
	}
	
	public void setToken(int token) {
		Token = token;
	}
	
	public int getCategoryID() {
		return CategoryID;
	}
	
	public void setCategoryID(int categoryID) {
		CategoryID = categoryID;
	}
	
	public int getProcessID() {
		return ProcessID;
	}
	
	public void setProcessID(int processID) {
		ProcessID = processID;
	}
}
