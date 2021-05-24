package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartSwingToken extends JFrame {

	Container c;
	JButton newToken, updateToken, showToken;

	public StartSwingToken() {

		c = getContentPane();
		c.setLayout(new GridLayout(3, 1));
		newToken = new JButton("insert new Token");
		updateToken = new JButton("update Token");
		showToken = new JButton("show Token");

		c.add(newToken);
		c.add(updateToken);
		c.add(showToken);

		NewTokenButtonListener newTokenAction = new NewTokenButtonListener();
		newToken.addActionListener(newTokenAction);

		UpdateTokenButtonListener updateTokenAction = new UpdateTokenButtonListener();
		updateToken.addActionListener(updateTokenAction);

		ShowTokenButtonListener showTokenAction = new ShowTokenButtonListener();
		showToken.addActionListener(showTokenAction);

	}

	class ShowTokenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e1) {
			// TODO Auto-generated method stub

			// Aufruf Swing Fenster fürs Eingeben von Token Nr --> Daten anzeigen
			InsertToShowDataSwing insertToShowData = new InsertToShowDataSwing();
			insertToShowData.setTitle("Show Token");
			insertToShowData.setSize(400, 150);
			insertToShowData.setVisible(true);
			insertToShowData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			dispose();
		}

	}

	class UpdateTokenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e2) {
			// TODO Auto-generated method stub

			// Aufruf Swing Fenster fürs Erstellen eines neuen Token
			InsertToUpdateDataSwing updateTokenWindow = new InsertToUpdateDataSwing();
			updateTokenWindow.setTitle("Update Token");
			updateTokenWindow.setSize(400, 150);
			updateTokenWindow.setVisible(true);
			updateTokenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			dispose();
		}

	}

	class NewTokenButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e3) {
			// TODO Auto-generated method stub

			// Aufruf Swing Fenster fürs Erstellen eines neuen Token
			NewTokenSwing tokenWindow = new NewTokenSwing();
			tokenWindow.setTitle("New Token");
			tokenWindow.setSize(400, 250);
			tokenWindow.setVisible(true);
			tokenWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			dispose();
		}
	}

	public static void main(String[] args) {

		// Erstellen des Swing Auswahl-Menüs
		StartSwingToken start = new StartSwingToken();
		start.setTitle("Token Menu");
		start.setSize(400, 150);
		start.setVisible(true);
		start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
