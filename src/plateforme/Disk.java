package plateforme;


public class Disk {
	private final int size = 100*1024*1024; // GB convertit en KB
	private int tailleOccupe;
	private int tailleDispo;
	
	
	public int getTailleOccupe() {
		return tailleOccupe;
	}
	public void setTailleOccupe(int tailleOccupe) {
		this.tailleOccupe = tailleOccupe;
	}
	public int getTailleDispo() {
		return tailleDispo;
	}
	public void setTailleDispo(int tailleDispo) {
		this.tailleDispo = tailleDispo;
	}
	public int getSize() {
		return size;
	}

	
	
}
