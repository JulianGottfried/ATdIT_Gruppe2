package main.java.persistence.databaseTables;

public interface AbstractEntry {
	// This class's only purpose is to act as parent for all table classes.
	// With this the DatabaseManager can be protected from classes that aren't
	// supposed to be stored in the DB.
}
