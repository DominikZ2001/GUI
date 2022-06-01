package java.gui.entities;

public class Schueler extends Person {
	
	private boolean anwesened = false;
	
	private String klasse;

	public boolean isAnwesened() {
		return anwesened;
	}

	public void setAnwesened(boolean anwesened) {
		this.anwesened = anwesened;
	}

	public String getKlasse() {
		return klasse;
	}

	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}
	
	
}
