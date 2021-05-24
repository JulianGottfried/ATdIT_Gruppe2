package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

// Class to add a Token to the 'public.Token' Database


public class NewTokenSwing extends JFrame {

	Container c;
	JLabel headline, headline1, headline2, headline3;
	JComboBox status1, status2, status3;
	JButton submitButton, backButton;
	JTextArea tokenNr;

	public NewTokenSwing() {
		c = getContentPane();
		c.setLayout(new GridLayout(10, 1));
		String[] noten = new String[] { "Will be processed soon", "In process", "finished" };

		tokenNr = new JTextArea("");

		status1 = new JComboBox(noten);
		status2 = new JComboBox(noten);
		status3 = new JComboBox(noten);

		headline = new JLabel("Insert order number");
		headline1 = new JLabel("Status first step");
		headline2 = new JLabel("Status second step");
		headline3 = new JLabel("Status third step");

		submitButton = new JButton("Submit");
		backButton = new JButton("Back to menu");

		c.add(headline);
		c.add(tokenNr);
		c.add(headline1);
		c.add(status1);
		c.add(headline2);
		c.add(status2);
		c.add(headline3);
		c.add(status3);
		c.add(submitButton);
		c.add(backButton);

		SubmitButtonListener action = new SubmitButtonListener();
		submitButton.addActionListener(action);

		BackToMenuListener BackToMenu = new BackToMenuListener();
		backButton.addActionListener(BackToMenu);
	}

	class BackToMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			StartSwingToken start = new StartSwingToken();
			start.setTitle("New Token");
			start.setSize(400, 150);
			start.setVisible(true);
			start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			dispose();
		}

	}

	class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"PostgreSQL")) {

				System.out.println("Connected to PostgreSQL");
				PreparedStatement temp = con.prepareStatement("insert into public.token values(?,?,?,?)");

				String token = tokenNr.getText();
				String statusStep1 = (String) status1.getSelectedItem();
				String statusStep2 = (String) status2.getSelectedItem();
				String statusStep3 = (String) status3.getSelectedItem();

				Token Token1 = new Token(token, statusStep1, statusStep2, statusStep3);

				temp.setString(1, Token1.getTokenId());
				temp.setString(2, Token1.getFirstStep());
				temp.setString(3, Token1.getSecondStep());
				temp.setString(4, Token1.getThirdStep());

				temp.executeUpdate();

				Statement stmt = con.createStatement();
				String query = "select * from public.token";
				stmt.executeQuery(query);

				dispose();

				StartSwingToken start = new StartSwingToken();
				start.setTitle("New Token");
				start.setSize(400, 150);
				start.setVisible(true);
				start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			} catch (SQLException e1) {
				System.out.println("Connection failed");
				e1.printStackTrace();
				
			}
		}

	}

}