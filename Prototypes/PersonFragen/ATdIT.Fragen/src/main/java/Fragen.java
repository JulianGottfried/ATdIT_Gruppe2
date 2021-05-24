import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Fragen extends JFrame {

	JPanel p;
	JLabel label;
	JTextArea textArea;
	JButton button;
	String Frage;
	
	private static String[] AlleAntworten = new String[7];
	private static int counter = 0;

	public Fragen(String Frage) {

		this.Frage = Frage;
		
		JPanel p = new JPanel();
		
		p.setLayout(new GridLayout(3, 1));
		
		label = new JLabel(Frage);
		textArea = new JTextArea("");
		button = new JButton("Submit");

		p.add(label);
		p.add(textArea);
		p.add(button);

		this.add(p);
		
		SubmitButtonListener sbl = new SubmitButtonListener();
		button.addActionListener(sbl);
		
		//aL enter
	}

	class SubmitButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			String Antwort  = textArea.getText();
			AlleAntworten[counter] = Antwort;
			
			counter += 1;
			
			dispose();
		
			if(AlleAntworten[6] != null) {
				FragenUeberpruefen fragenUeberpruefen = new FragenUeberpruefen(AlleAntworten);
				fragenUeberpruefen.setTitle("Final check");
				fragenUeberpruefen.setSize(400, 400);
				fragenUeberpruefen.setVisible(true);
				fragenUeberpruefen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			
			Start start = new Start();
		}

	}

}
