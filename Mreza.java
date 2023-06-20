package igrica;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.util.ArrayList;
import java.util.HashSet;

public class Mreza extends Panel {
	
	private Polje[][] polja;
	protected ArrayList<Polje> izabranaPolja = new ArrayList<>();
	protected int x = 4;
	protected int y = 5;
	private Igra igra;
	protected HashSet izabraniBrojevi;
	
	public Mreza(int x, int y, Igra i) {
		
		polja = new Polje[x][y];
		this.x = x;
		this.y = y;
		igra = i;
		
		this.setBackground(Color.BLACK);
		this.setLayout(new GridLayout(x, y, 3, 3));
		int br = 0;
		for (int v = 0; v < x; v++) {
			for (int k = 0; k < y; k++) {
				polja[v][k] = new Polje(this, br++);
				add(polja[v][k]);
			}
		}
		
	}

	public ArrayList<Polje> getIzabranaPolja() {
		return izabranaPolja;
	}
	
	void updateKvota() {
		igra.updateKvota();
	}
	
	void updateDobitak() {
		igra.updateDobitak();
	}
	
	

}
