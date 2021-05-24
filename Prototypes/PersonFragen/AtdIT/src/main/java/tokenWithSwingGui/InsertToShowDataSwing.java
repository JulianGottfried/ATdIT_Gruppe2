package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class InsertToShowDataSwing extends JFrame {

	Container c;
	JLabel insertTokenNr;
	JButton submitButton, backButton;
	JTextArea TokenNr;

	public InsertToShowDataSwing() {
		c = getContentPane();
		c.setLayout(new GridLayout(4, 1));

		insertTokenNr = new JLabel("Insert Token Nr.");

		TokenNr = new JTextArea("");

		submitButton = new JButton("Submit");
		backButton = new JButton("Back to menu");

		c.add(insertTokenNr);
		c.add(TokenNr);
		c.add(submitButton);
		c.add(backButton);

		InsertToShowDataSwingListener InsertToShowDataAction = new InsertToShowDataSwingListener();
		submitButton.addActionListener(InsertToShowDataAction);

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

	class InsertToShowDataSwingListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String tokenNr = TokenNr.getText();

			try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
					"PostgreSQL")) {

				Statement stmt = con.createStatement();
				String search = "select * from public.token where token.tokenid = " + "'" + tokenNr + "'";
				String query = search;
				ResultSet rs = stmt.executeQuery(query);

				while (rs.next()) {
					ShowDataSwing newToken = new ShowDataSwing(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4));
					newToken.setTitle("Show Token");
					newToken.setSize(850, 100);
					newToken.setVisible(true);
					newToken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			} catch (SQLException e1) {
				System.out.println("Connection failed");
				e1.printStackTrace();
			}

			dispose();

		}

	}
}