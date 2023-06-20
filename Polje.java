package igrica;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Polje extends Canvas {
	
	private Mreza mreza;
	private int broj;
	private Label label;
	private boolean IZABRANO = false;
	private boolean SLOBODNO = true;
	
	public Polje(Mreza mreza, int broj) {
		this.mreza = mreza;
		this.broj = broj;
		
		label.setText(String.valueOf(broj));
		label.setSize(25, 25);
		label.setLocation(this.getX(), this.getY());
		
		this.setBackground(Color.ORANGE);
		this.setSize(75, 75);
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				repaint();
			}
		});
		
		this.setVisible(true);
	}
	
	public boolean getStatus() {
		if (IZABRANO) return IZABRANO;
		else return SLOBODNO;
	}
	
	public void updateStatus() {
		if (IZABRANO) {
			mreza.izabranaPolja.remove(this);
			mreza.izabraniBrojevi.remove(this.broj);
		}
		if (SLOBODNO) {
			mreza.izabranaPolja.add(this);
			mreza.izabraniBrojevi.add(this.broj); //da li je ovo ok?
		}
		IZABRANO = !IZABRANO;
		SLOBODNO = !SLOBODNO;
	}
	
	public void paint() {
		if (SLOBODNO) {
			Graphics g = this.getGraphics();
			g.setColor(Color.BLUE);
			
			g.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
			//ispisi broj belom bojom
			this.updateStatus();
			this.updateKvotaIDobitak();
		}
	}
	
	public void updateKvotaIDobitak() {
		mreza.updateKvota();
		mreza.updateDobitak();
	}

}
