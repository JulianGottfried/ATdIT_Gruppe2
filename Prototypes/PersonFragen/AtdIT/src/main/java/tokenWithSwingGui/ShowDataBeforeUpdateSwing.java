package tokenWithSwingGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ShowDataBeforeUpdateSwing extends JFrame {

	String showTokenId;
	String showFirstStep;
	String showSecondStep;
	String showThirdStep;

	Container c;

	JLabel headerTokenNr, headerfirstStatus, headersecondStatus, headerthirdStatus;

	JLabel TokenNr, firstStatus, secondStatus, thirdStatus, space;
	
	JButton closeButton;

	public ShowDataBeforeUpdateSwing(String showTokenId, String showFirstStep, String showSecondStep, String showThirdStep) {
		this.showTokenId = showTokenId;
		this.showFirstStep = showFirstStep;
		this.showSecondStep = showSecondStep;
		this.showThirdStep = showThirdStep;

		c = getContentPane();
		c.setLayout(new GridLayout(2, 4));

		headerTokenNr = new JLabel("Token Number");
		headerfirstStatus = new JLabel("Status first step");
		headersecondStatus = new JLabel("Status second step");
		headerthirdStatus = new JLabel("Status third step");
		space = new JLabel("");


		TokenNr = new JLabel(showTokenId);
		firstStatus = new JLabel(showFirstStep);
		secondStatus = new JLabel(showSecondStep);
		thirdStatus = new JLabel(showThirdStep);

		closeButton = new JButton("Close Window");

		c.add(headerTokenNr);
		c.add(headerfirstStatus);
		c.add(headersecondStatus);
		c.add(headerthirdStatus);
		c.add(space);
		
		c.add(TokenNr);
		c.add(firstStatus);
		c.add(secondStatus);
		c.add(thirdStatus);

		c.add(closeButton);

		BackToMenuListener BackToMenu = new BackToMenuListener();
		closeButton.addActionListener(BackToMenu);
	}

	class BackToMenuListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

	}
}