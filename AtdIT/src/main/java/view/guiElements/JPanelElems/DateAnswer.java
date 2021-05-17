package main.java.view.guiElements.JPanelElems;

import main.java.view.guiElements.AnswerInterface;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import main.java.controller.handler.ScreenHandler;

public class DateAnswer extends AbstractJPanel implements AnswerInterface {

	public DateAnswer(ScreenHandler screenHandler) {
		super(screenHandler);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		this.add(datePicker);
	}
}
