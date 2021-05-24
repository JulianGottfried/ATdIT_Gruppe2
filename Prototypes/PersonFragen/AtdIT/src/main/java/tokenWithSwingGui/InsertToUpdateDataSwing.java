package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class InsertToUpdateDataSwing extends JFrame {

	Container c;
	JLabel insertTokenNr;
	JButton submitButton, backButton;
	JTextArea TokenNr;

	public InsertToUpdateDataSwing() {
		c = getContentPane();
		c.setLayout(new GridLayout(4, 1));

		insertTokenNr = new JLabel("Insert Token Nr. to update");

		TokenNr = new JTextArea("");

		submitButton = new JButton("Submit");
		backButton = new JButton("Back to menu");

		c.add(insertTokenNr);
		c.add(TokenNr);
		c.add(submitButton);
		c.add(backButton);

		InsertToUpdateDataSwingListener InsertToUpdateDataAction = new InsertToUpdateDataSwingListener();
		submitButton.addActionListener(InsertToUpdateDataAction);

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

	class InsertToUpdateDataSwingListener implements ActionListener {

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
					ShowDataBeforeUpdateSwing newToken = new ShowDataBeforeUpdateSwing(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4));
					newToken.setTitle("Show Token before Update");
					newToken.setSize(850, 100);
					newToken.setVisible(true);
					newToken.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				}
			} catch (SQLException e1) {
				System.out.println("Connection failed");
				e1.printStackTrace();
			}

			UpdateTokenSwing updateTokenWindow = new UpdateTokenSwing();
			updateTokenWindow.setTitle("Update Token");
			updateTokenWindow.setSize(400, 250);
			updateTokenWindow.setVisible(true);
			updateTokenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			dispose();

		}

	}

}