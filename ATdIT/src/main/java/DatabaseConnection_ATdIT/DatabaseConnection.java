package DatabaseConnection_ATdIT;

import java.sql.*;
import java.util.Scanner;

import Personen.ATdIT.Person;

public class DatabaseConnection {
	
	public static void main(String[] args) {
		
		try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
				"postgres","PostgreSQL" )){
			
			System.out.println("Connected to PostgreSQL");
			
			PreparedStatement temp = con.prepareStatement("insert into public.person values(?,?,?,?,?,?)");
			
			System.out.println("Vorname");
			Scanner scan = new Scanner(System.in);
			String Vorname = scan.next();
			
			System.out.println("Nachname");
			String Nachname = scan.next();
			
			System.out.println("Geburtsdatum");
			String Geburtsdatum = scan.next();
			
			System.out.println("PLZ");
			String PLZ = scan.next();
			
			System.out.println("Wohnort");
			String Wohnort = scan.next();
			
			System.out.println("Straße und Hausnummer");
			String StraßeUndHausnummer = scan.next();
			
			Person person1 = new Person(Vorname, Nachname, Geburtsdatum, PLZ, Wohnort, StraßeUndHausnummer);
			
			temp.setString(1, person1.getVorName());
			temp.setString(2, person1.getNachName());
			temp.setString(3, person1.getGeburtsDatum());
			temp.setString(4, person1.getPLZ());
			temp.setString(5, person1.getWohnort());
			temp.setString(6, person1.getStraßeUndHausnummer());
			
			temp.executeUpdate();
			
			Statement stmt = con.createStatement();
			String query = "select * from public.person";
			ResultSet rs = stmt.executeQuery(query);
			System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", "Vorname",
					"Nachname","Geburtsdatum","PLZ","Wohnort","Straße und Hausnummer");
			
			while(rs.next()) {
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n", rs.getString(1),
						rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
							}
			
		} catch(SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
}
