package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class UpdateTokenSwing extends JFrame {

	Container c;
	JLabel headline, headline1, headline2, headline3;
	JComboBox status1, status2, status3;
	JButton submitButton;
	JTextArea tokenNr;

	public UpdateTokenSwing() {
		c = getContentPane();
		c.setLayout(new GridLayout(9, 1));
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

		c.add(headline);
		c.add(tokenNr);
		c.add(headline1);
		c.add(status1);
		c.add(headline2);
		c.add(status2);
		c.add(headline3);
		c.add(status3);
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

				String token = tokenNr.getText();
				String statusStep1 = (String) status1.getSelectedItem();
				String statusStep2 = (String) status2.getSelectedItem();
				String statusStep3 = (String) status3.getSelectedItem();

				System.out.println(statusStep1 + statusStep1 + statusStep1);
				
				dispose();
				
				StartSwingToken start = new StartSwingToken();
				start.setTitle("New Token");
				start.setSize(400, 150);
				start.setVisible(true);
				start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				Token Token1 = new Token(token, statusStep1, statusStep2, statusStep3);

				Statement stmt1 = con.createStatement();
				String updateToken = "update public.token set firstStep = '" + Token1.getFirstStep()
						+ "', secondStep = '" + Token1.getSecondStep() + "', thirdStep = '" + Token1.getThirdStep()
						+ "' where tokenId = '" + Token1.getTokenId() + "'";

				ResultSet rs1 = stmt1.executeQuery(updateToken);
				
			} catch (SQLException e1) {
				System.out.println("Connection failed");
				e1.printStackTrace();
			}
		}

	}

}