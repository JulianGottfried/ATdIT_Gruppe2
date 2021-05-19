package main.java.view.guiElements.JPanelElems;

import main.java.view.guiElements.AnswerInterface;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.util.Calendar;
import java.util.Date;

import main.java.controller.exceptions.FaltyAnswerException;
import main.java.controller.handler.ScreenHandler;

public class DateAnswer extends AbstractJPanel implements AnswerInterface {
	private JDatePickerImpl datePicker;
	
	public DateAnswer(ScreenHandler screenHandler) {
		super(screenHandler);
		
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		this.add(datePicker);
	}

	public String getAnswer() throws FaltyAnswerException {
		Date date = (Date) datePicker.getModel().getValue();
		try {
			return date.toString();
		} catch (NullPointerException npe) {
			throw new FaltyAnswerException("No date picked");
		}
	}
}
