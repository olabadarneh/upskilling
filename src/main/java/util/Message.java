package util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class Message {

	public static void addMessage(String severity, String summary, String detail) {

		FacesMessage.Severity messageSverity = null;

		switch (severity.toUpperCase()) {
		case "INFO":
			messageSverity = FacesMessage.SEVERITY_INFO;
			break;

		case "WARN":
			messageSverity = FacesMessage.SEVERITY_WARN;
			break;

		case "ERROR":
			messageSverity = FacesMessage.SEVERITY_ERROR;
			break;
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageSverity, summary, detail));

	}

	private static String getString(String key) {
		String lang = FacesContext.getCurrentInstance().getViewRoot().getLocale().toString();

		String baseName = (lang.equalsIgnoreCase("ar") ? "language.messages_ar" : "language.messages");

		ResourceBundle bundle = ResourceBundle.getBundle(baseName,

				FacesContext.getCurrentInstance().getViewRoot().getLocale());

		return bundle.getString(key);

	}

	public static void addMessageByKey(String severity, String summary, String Key) {
		addMessage(severity, summary, getString(Key));

	}
}
