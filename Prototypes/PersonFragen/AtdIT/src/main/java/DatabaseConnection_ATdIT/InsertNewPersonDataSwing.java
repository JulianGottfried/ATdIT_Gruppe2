package DatabaseConnection_ATdIT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Personen.ATdIT.Person;

import java.sql.*;

public class InsertNewPersonDataSwing extends JFrame {

	Container c;
	JLabel VorNameText, NachNameText, PLZText, StraßeText, HausNrText, GeburtsDatumText, PersonenIDText, WohnortText;
	JComboBox day, month, year;
	JTextArea VorName, NachName, PLZ, Straße, HausNr, WohnOrt, PersonenID;
	JButton submitButton;

	public InsertNewPersonDataSwing() {
		c = getContentPane();
		c.setLayout(new GridLayout(6, 3));
		String[] Day = new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30",
				"31" };
		String[] Month = new String[] { "Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August",
				"September", "Oktober", "November", "Dezember" };
		String[] Year = new String[] { "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012",
				"2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999",
				"1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986",
				"1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973",
				"1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960",
				"1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947",
				"1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934",
				"1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921",
				"1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908",
				"1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900"};

		JTextArea PersonenID = new JTextArea("PersonenID");
		JTextArea WohnOrt = new JTextArea("");
		JTextArea VorName = new JTextArea("");
		JTextArea NachName = new JTextArea("");
		JTextArea PLZ = new JTextArea("");
		JTextArea Straße = new JTextArea("");
		JTextArea HausNr = new JTextArea("");

		day = new JComboBox(Day);
		month = new JComboBox(Month);
		year = new JComboBox(Year);

		PersonenIDText = new JLabel("PersonenID");
		VorNameText = new JLabel("Vorname");
		NachNameText = new JLabel("Nachname");
		GeburtsDatumText = new JLabel("Geburtsdatum");
		PLZText = new JLabel("PLZ");
		WohnortText = new JLabel("Wohnort");
		StraßeText = new JLabel("Straßenname");
		HausNrText = new JLabel("Hausnummer");

		submitButton = new JButton("Submit");

		c.add(PersonenIDText);
		c.add(PersonenID);
		c.add(VorNameText);
		c.add(VorName);
		c.add(NachNameText);
		c.add(NachName);
		c.add(GeburtsDatumText);
		c.add(day);
		c.add(month);
		c.add(year);
		c.add(PLZText);
		c.add(PLZ);
		c.add(WohnortText);
		c.add(WohnOrt);
		c.add(StraßeText);
		c.add(Straße);
		c.add(HausNrText);
		c.add(HausNr);

		c.add(submitButton);

		SubmitButtonListener action = new SubmitButtonListener();
		submitButton.addActionListener(action);
	}

	class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"PostgreSQL")) {

				System.out.println("Connected to PostgreSQL");
				PreparedStatement temp = con.prepareStatement("insert into public.token values(?,?,?,?)");

				String Tag = (String) day.getSelectedItem();
				String Monat = (String) month.getSelectedItem();
				String Jahr = (String) year.getSelectedItem();

				String GeburtsDatum = Tag + "." + Monat + "." + Jahr;

				String PersonID = PersonenID.getText();
				String Vorname = VorName.getText();
				String Nachname = NachName.getText();
				String Postleitzahl = PLZ.getText();
				String Strasse = Straße.getText();
				String Hausnummer = HausNr.getText();
				String Wohnort = WohnOrt.getText();

				Person newPerson = new Person(PersonID, Vorname, Nachname, GeburtsDatum, Postleitzahl, Wohnort, Strasse,
						Hausnummer);

				temp.setString(1, newPerson.getVorName());
				temp.setString(2, newPerson.getNachName());
				temp.setString(3, newPerson.getGeburtsDatum());
				temp.setString(4, newPerson.getPLZ());
				temp.setString(5, newPerson.getWohnort());
				temp.setString(6, newPerson.getStraße());
				temp.setString(7, newPerson.getHausNr());
				temp.setString(8, newPerson.getPersonenID());

				temp.executeUpdate();

				Statement stmt = con.createStatement();
				String query = "select * from public.person";
				ResultSet rs = stmt.executeQuery(query);
				System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s" + " %-30.30s%n",
						"Vorname", "Nachname", "Geburtsdatum", "PLZ", "Wohnort", "Straße", "Hausnummer", "PersonenID");

				// print database in console

				while (rs.next()) {
					System.out.printf("%-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s %-30.30s%n",
							rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
							rs.getString(6), rs.getString(7), rs.getString(8));
				}

			} catch (SQLException e1) {
				System.out.println("Connection failed");
				e1.printStackTrace();
			}
		}
	}
}