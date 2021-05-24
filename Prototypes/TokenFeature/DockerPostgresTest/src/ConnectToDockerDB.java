import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectToDockerDB {
	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5555/postgres", "postgres",
				"postgres")) {

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

			temp.setString(1, tokenId);
			temp.setString(2, firstStep);
			temp.setString(3, secondStep);
			temp.setString(4, thirdStep);

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
}
