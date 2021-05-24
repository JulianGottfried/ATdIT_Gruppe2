import javax.swing.JFrame;

public class Start {

	private static int frageNr = 0;

	public static void main(String[] args) {
		
		frageNr = 0;
		Start start = new Start();
	}

	public Start() {
		if (frageNr == 0) {

			Fragen start1 = new Fragen("Wie lautet ihr Vorname?: ");
			start1.setTitle("Vorname");
			start1.setSize(400, 400);
			start1.setVisible(true);
			start1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 1) {

			Fragen start2 = new Fragen("Wie lautet ihr Nachname?: ");
			start2.setTitle("Nachname");
			start2.setSize(400, 400);
			start2.setVisible(true);
			start2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 2) {

			Fragen start3 = new Fragen("Wie lautet ihr Geburtsdatum?: ");
			start3.setTitle("Geburtsdatum");
			start3.setSize(400, 400);
			start3.setVisible(true);
			start3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 3) {

			Fragen start4 = new Fragen("Wie lautet ihre PLZ?: ");
			start4.setTitle("PLZ");
			start4.setSize(400, 400);
			start4.setVisible(true);
			start4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 4) {

			Fragen start5 = new Fragen("Wie lautet ihr Wohnort?: ");
			start5.setTitle("Wohnort");
			start5.setSize(400, 400);
			start5.setVisible(true);
			start5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 5) {

			Fragen start6 = new Fragen("Wie lautet ihre Strasse?: ");
			start6.setTitle("Strasse");
			start6.setSize(400, 400);
			start6.setVisible(true);
			start6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;

		} else if (frageNr == 6) {

			Fragen start7 = new Fragen("Wie lautet ihre Hausnummer?: ");
			start7.setTitle("Hausnummer");
			start7.setSize(400, 400);
			start7.setVisible(true);
			start7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frageNr++;
		}
	}
}
