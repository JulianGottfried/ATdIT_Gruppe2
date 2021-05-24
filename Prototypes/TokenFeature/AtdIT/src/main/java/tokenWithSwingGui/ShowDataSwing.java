package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import tokenWithSwingGui.InsertToShowDataSwing;
import tokenWithSwingGui.NewTokenSwing;
import tokenWithSwingGui.UpdateTokenSwing;
import tokenWithSwingGui.InsertToUpdateDataSwing.BackToMenuListener;

public class ShowDataSwing extends JFrame {

	String showTokenId;
	String showFirstStep;
	String showSecondStep;
	String showThirdStep;

	Container c;

	JLabel headerTokenNr, headerfirstStatus, headersecondStatus, headerthirdStatus;

	JLabel TokenNr, firstStatus, secondStatus, thirdStatus, space;

	JButton submitButton, backButton;

	public ShowDataSwing(String showTokenId, String showFirstStep, String showSecondStep, String showThirdStep) {
		this.showTokenId = showTokenId;
		this.showFirstStep = showFirstStep;
		this.showSecondStep = showSecondStep;
		this.showThirdStep = showThirdStep;

		c = getContentPane();
		c.setLayout(new GridLayout(2, 5));

		headerTokenNr = new JLabel("Token Number");
		headerfirstStatus = new JLabel("Status first step");
		headersecondStatus = new JLabel("Status second step");
		headerthirdStatus = new JLabel("Status third step");
		space = new JLabel("");


		TokenNr = new JLabel(showTokenId);
		firstStatus = new JLabel(showFirstStep);
		secondStatus = new JLabel(showSecondStep);
		thirdStatus = new JLabel(showThirdStep);

		backButton = new JButton("Back to menu");

		c.add(headerTokenNr);
		c.add(headerfirstStatus);
		c.add(headersecondStatus);
		c.add(headerthirdStatus);
		c.add(space);
		
		c.add(TokenNr);
		c.add(firstStatus);
		c.add(secondStatus);
		c.add(thirdStatus);

		c.add(backButton);

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
}
