package gui.ressources.i18n.deutsch;

import java.util.Arrays;

import com.vaadin.flow.component.datepicker.DatePicker.DatePickerI18n;

/**
 * I18N Deutsch
 * 
 * @author mmo
 */
public class DatePickerI18NDeutsch extends DatePickerI18n
{
	private static final long serialVersionUID = -7073350360429977133L;
	
	/**
	 * Konstruktor mit den deutschen Standardkonfigurationen
	 */
	public DatePickerI18NDeutsch()
	{
		setCancel("Abbrechen");
		setCalendar("Kalender");
		setClear("Löschen");
		setDateFormat("dd.MM.yyyy");
		setToday("Heute");
		setMonthNames(Arrays.asList("Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober", "November", "Dezember"));
		setWeek("Woche");
		setWeekdays(Arrays.asList("Montag", "Dienstag", "Mittwoch", "Donnerstag", "Freitag", "Samstag", "Sonntag"));
		setWeekdaysShort(Arrays.asList("Mo", "Di", "Mi", "Do", "Fr", "Sa", "So"));
	}
}
