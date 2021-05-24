import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FragenUeberpruefen extends JFrame {

	String[] AlleAntworten = new String[20];
	JPanel p;
	JLabel VorName, NachName, GeburtsDatum, PLZ, Wohnort, Strasse, HausNr;
	JTextArea VorNameText, NachNameText, GeburtsDatumText, PLZText, WohnortText, StrasseText, HausNrText;
	JButton SubmitButton;

	private static int personenID = 0;
	
	public FragenUeberpruefen(String[] AlleAntworten) {
		
		this.AlleAntworten = AlleAntworten;

		JPanel p = new JPanel();

		p.setLayout(new GridLayout(8, 2));

		VorName = new JLabel("Vorname: ");
		NachName = new JLabel("Nachname: ");
		GeburtsDatum = new JLabel("Geburtsdatum: ");
		PLZ = new JLabel("PLZ: ");
		Wohnort = new JLabel("Wohnort: ");
		Strasse = new JLabel("Strasse: ");
		HausNr = new JLabel("Hausnummer: ");

		VorNameText = new JTextArea(AlleAntworten[0]);
		NachNameText = new JTextArea(AlleAntworten[1]);
		GeburtsDatumText = new JTextArea(AlleAntworten[2]);
		PLZText = new JTextArea(AlleAntworten[3]);
		WohnortText = new JTextArea(AlleAntworten[4]);
		StrasseText = new JTextArea(AlleAntworten[5]);
		HausNrText = new JTextArea(AlleAntworten[6]);

		SubmitButton = new JButton("Submit");

		p.add(VorName);
		p.add(VorNameText);
		p.add(NachName);
		p.add(NachNameText);
		p.add(GeburtsDatum);
		p.add(GeburtsDatumText);
		p.add(PLZ);
		p.add(PLZText);
		p.add(Wohnort);
		p.add(WohnortText);
		p.add(Strasse);
		p.add(StrasseText);
		p.add(Strasse);
		p.add(StrasseText);
		p.add(HausNr);
		p.add(HausNrText);
		p.add(SubmitButton);

		this.add(p);

		SubmitButtonListener sbl = new SubmitButtonListener();
		SubmitButton.addActionListener(sbl);
	}

	class SubmitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			personenID += 1;
			
			String vorname = VorNameText.getText();
			String nachname = NachNameText.getText();
			String geburtsdatum = GeburtsDatumText.getText();
			String plz = PLZText.getText();
			String wohnort = WohnortText.getText();
			String Strasse = StrasseText.getText();
			String hausnr = HausNrText.getText();
			
			
			// TODO für Marvin: id bei jedem Aufruf hochzählen (variable extern speichern)
			String id = "07";
			
			Person person = new Person(vorname, nachname, geburtsdatum, plz, wohnort, Strasse, hausnr, id);

			EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConnectToDB");
			EntityManager entitymanager = emfactory.createEntityManager();
			entitymanager.getTransaction().begin();

			entitymanager.persist(person);
			entitymanager.getTransaction().commit();
			
			entitymanager.find(Person.class, id);

			entitymanager.close();
			emfactory.close();

			dispose();
		
		
		}
	}

}
