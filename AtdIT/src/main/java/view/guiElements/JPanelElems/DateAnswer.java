package main.java.view.guiElements.JPanelElems;

import main.java.view.guiElements.AnswerInterface;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.text.SimpleDateFormat;
import java.util.Date;

import main.java.controller.exceptions.FaultyAnswerException;
import main.java.controller.exceptions.InterruptDrawException;
import main.java.controller.handler.ScreenHandler;
import main.java.controller.handler.I18nHandler;

public class DateAnswer extends AbstractJPanel implements AnswerInterface {
	private JDatePickerImpl datePicker;
	private I18nHandler i18n;
	
	public DateAnswer(ScreenHandler screenHandler) {
		super(screenHandler);
		this.setI18n(screenHandler);
		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		datePicker = new JDatePickerImpl(datePanel);
		this.add(datePicker);
	}
	
	public void setI18n(ScreenHandler screenHandler) {
		try {
			this.i18n = new I18nHandler(this.getClass().getSimpleName(), screenHandler.getLanguage(), screenHandler);
		} catch (InterruptDrawException e) {
            screenHandler.changeCurrentView(screenHandler.getPreviousView());
		}
	}

	public String getAnswer() throws FaultyAnswerException {
		Date date = (Date) datePicker.getModel().getValue();
		try {
			return new SimpleDateFormat("dd-MM-yyyy").format(date);
		} catch (NullPointerException npe) {
			throw new FaultyAnswerException(i18n.getString("errorMessage"));
		}
	}
}
