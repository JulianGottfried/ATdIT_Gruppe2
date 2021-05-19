package main.java.view.guiElements.JPanelElems;

import main.java.view.guiElements.AnswerInterface;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import main.java.controller.exceptions.FaultyAnswerException;
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

	public String getAnswer() throws FaultyAnswerException {
		Date date = (Date) datePicker.getModel().getValue();
		try {
			return new SimpleDateFormat("dd-MM-yyyy").format(date);
		} catch (NullPointerException npe) {
			throw new FaultyAnswerException("No date picked");
		}
	}
}
