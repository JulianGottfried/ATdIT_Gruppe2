package DatabaseConnection_ATdIT;

import java.sql.*;
import java.util.Scanner;

import Personen.ATdIT.Person;

public class DatabaseConnectionPerson {

	public static void main(String[] args) {

		// Build database connection
		// Insert Data to database "Person"

		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"PostgreSQL")) {

			System.out.println("Connected to PostgreSQL");
			PreparedStatement temp = con.prepareStatement("insert into public.person values(?,?,?,?,?,?,?,?)");

			System.out.println("Personen ID");
			Scanner scan = new Scanner(System.in);
			String PersonenID = scan.next();

			System.out.println("Vorname");
			String Vorname = scan.next();

			System.out.println("Nachname");
			String Nachname = scan.next();

			System.out.println("Geburtsdatum");
			String Geburtsdatum = scan.next();

			System.out.println("PLZ");
			String PLZ = scan.next();

			System.out.println("Wohnort");
			String Wohnort = scan.next();

			System.out.println("Straße");
			String Straße = scan.next();

			System.out.println("Hausnummer");
			String HausNr = scan.next();

			
			Person person1 = new Person(PersonenID, Vorname, Nachname, Geburtsdatum, PLZ, Wohnort, Straße, HausNr);

			temp.setString(1, person1.getVorName());
			temp.setString(2, person1.getNachName());
			temp.setString(3, person1.getGeburtsDatum());
			temp.setString(4, person1.getPLZ());
			temp.setString(5, person1.getWohnort());
			temp.setString(6, person1.getStraße());
			temp.setString(7, person1.getHausNr());
			temp.setString(8, person1.getPersonenID());

			temp.executeUpdate();

			Statement stmt = con.createStatement();
			String query = "select * from public.person";
			ResultSet rs = stmt.executeQuery(query);
			System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s" + " %-30.30s%n", "Vorname",
					"Nachname", "Geburtsdatum", "PLZ", "Wohnort", "Straße", "Hausnummer", "PersonenID");

			// print database in console

			while (rs.next()) {
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", rs.getString(1),
						rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),
						rs.getString(7),rs.getString(8) );
			}

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
}