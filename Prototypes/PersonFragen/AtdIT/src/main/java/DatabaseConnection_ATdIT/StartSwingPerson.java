package DatabaseConnection_ATdIT;

import javax.swing.JFrame;


public class StartSwingPerson {
	public static void main(String[] args) {
		InsertNewPersonDataSwing insertToShowData = new InsertNewPersonDataSwing();
		insertToShowData.setTitle("Insert Person Data");
		insertToShowData.setSize(800, 800);
		insertToShowData.setVisible(true);
		insertToShowData.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
