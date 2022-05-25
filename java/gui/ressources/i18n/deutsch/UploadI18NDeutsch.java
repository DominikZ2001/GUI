package gui.ressources.i18n.deutsch;

import java.util.Arrays;

import com.vaadin.flow.component.upload.UploadI18N;

/**
 * I18N Deutsch
 * 
 * @author mmo
 */
public class UploadI18NDeutsch extends UploadI18N
{
	private static final long serialVersionUID = -633310266179140075L;
	
	/**
	 * Konstruktor mit den deutschen Standardkonfigurationen
	 */
	public UploadI18NDeutsch()
	{
		setDropFiles(new DropFiles()
				.setOne("Datei hier ablegen")
				.setMany("Dateien hier ablegen"));
		setAddFiles(new AddFiles()
				.setOne("Datei hinzufügen...")
				.setMany("Dateien hinzufügen..."));
		setError(new Error()
				.setTooManyFiles("Zu viele Dateien.")
				.setFileIsTooBig("Die Datei ist zu groß.")
				.setIncorrectFileType("Ungültiger Dateityp."));
		setUploading(new Uploading()
				.setStatus(new Uploading.Status()
						.setConnecting("Verbinden...")
						.setStalled("In Verzögerung")
						.setProcessing("Verarbeiten...")
						.setHeld("Temporär deaktiviert"))
				.setRemainingTime(new Uploading.RemainingTime()
						.setPrefix("Verbleibende Zeit: ")
						.setUnknown("Verbleibende Zeit unbekannt."))
				.setError(new Uploading.Error()
						.setServerUnavailable("Server nicht erreichbar")
						.setUnexpectedServerError("Es ist ein unbekannter Fehler aufgetreten")
						.setForbidden("Upload verboten")));
		setUnits(new Units()
				.setSize(Arrays.asList("B", "kB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB")));
	}
}
