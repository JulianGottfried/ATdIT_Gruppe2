package DatabaseConnection_ATdIT;

import java.sql.*;
import java.util.Scanner;

import tokenWithSwingGui.Token;

public class DatabaseConnectionToken implements DatabaseTokenInterface {

	@Override
	public void insertNewData() {
		// TODO Auto-generated method stub

		// Build database connection
		// Insert Data to database "Person"

		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"PostgreSQL")) {

			System.out.println("Connected to PostgreSQL");
			PreparedStatement temp = con.prepareStatement("insert into public.token values(?,?,?,?)");

			System.out.println("Auftragsnummer");
			Scanner scan = new Scanner(System.in);
			String tokenId = scan.next();

			System.out.println("first Step");
			String firstStep = scan.next();

			System.out.println("second Step");
			String secondStep = scan.next();

			System.out.println("third Step");
			String thirdStep = scan.next();

			Token token1 = new Token(tokenId, firstStep, secondStep, thirdStep);

			temp.setString(1, token1.getTokenId());
			temp.setString(2, token1.getFirstStep());
			temp.setString(3, token1.getSecondStep());
			temp.setString(4, token1.getThirdStep());

			temp.executeUpdate();

			Statement stmt = con.createStatement();
			String query = "select * from public.token";
			ResultSet rs = stmt.executeQuery(query);
			System.out.printf("%-30.30s %-30.30s %-30.30s" + " %-30.30s%n", "TokenId", "firstStep", "secondStep",
					"thirdStep");

			// print database in console

			while (rs.next()) {
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(String tokenId) {
		// TODO Auto-generated method stub

		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"PostgreSQL")) {
			
			Statement stmt = con.createStatement();
			String search = "select * from public.token where token.tokenid = " + "'" + tokenId + "'";
//			System.out.println(search);
			String query = search;
			ResultSet rs = stmt.executeQuery(query);
			System.out.printf("%-30.30s %-30.30s %-30.30s" + " %-30.30s%n", "TokenId", "firstStep", "secondStep",
					"thirdStep");

			while (rs.next()) {
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			}


			Scanner scan = new Scanner(System.in);
			System.out.println("new status first Step");
			String firstStep = scan.next();

			System.out.println("new status second Step");
			String secondStep = scan.next();

			System.out.println("new status third Step");
			String thirdStep = scan.next();

			Statement stmt1 = con.createStatement();
			String updateFirst = "update public.token set firstStep = '" + firstStep + "', secondStep = '" + secondStep + "', thirdStep = '" + thirdStep + "' where tokenId = '" + tokenId
					+ "'";

//			System.out.println(updateFirst);
	
			
		ResultSet rs1 = stmt1.executeQuery(updateFirst);
			
			System.out.printf("%-30.30s %-30.30s %-30.30s" + " %-30.30s%n", "TokenId", "firstStep", "secondStep",
					"thirdStep");


		} catch (SQLException e) {
			System.out.println("Connection failed");
		}
		
		searchToken(tokenId);
	}

	@Override
	public void searchToken(String tokenId) {
		// TODO Auto-generated method stub
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
				"PostgreSQL")) {

			Statement stmt = con.createStatement();
			String search = "select * from public.token where token.tokenid = " + "'" + tokenId + "'";
//			System.out.println(search);
			String query = search;
			ResultSet rs = stmt.executeQuery(query);
			System.out.printf("%-30.30s %-30.30s %-30.30s" + " %-30.30s%n", "TokenId", "firstStep", "secondStep",
					"thirdStep");

			while (rs.next()) {
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s%n", rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
	}
}