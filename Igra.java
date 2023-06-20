package igrica;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Igra extends Frame {
	
	private Mreza mreza;
	
	private Panel centerPanel;
	private Panel rightPanel;
	private Panel statusBar;
	
	private Label labelBalans = new Label();
	private Label labelUlog = new Label();
	private Label labelKvota = new Label();
	private Label labelDobitak = new Label();
	
	private int balans = 0;
	private int kvota = 5;
	private int dobitak = 500;
	private TextField tfUlog;
	private int ulog;
	
	private Generator generisanBroj;
	private Label labelGenerisanBroj;
	
	private Button igraj;
	
	public Igra() {
		
		
		setBounds(700, 200, 500, 300);
		setResizable(false); //treba true
		
		setTitle("Igra");
		
		mreza = new Mreza(4, 5, this);
		add(mreza, BorderLayout.CENTER);
		
		populateWindow();
		pack();
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		
		setVisible(true);
		
	}
	
	private void populateWindow() {
		
		tfUlog = new TextField(String.valueOf(ulog));
		
		labelBalans = new Label("" + 0);
		labelUlog = new Label("Ulog: ");

		labelKvota = new Label("Kvota: " + kvota);
		labelDobitak = new Label("Dobitak: " + dobitak);
		igraj = new Button("Igraj");
		

		rightPanel = new Panel();
		rightPanel.setLayout(new GridLayout(5, 1));
		rightPanel.add(new Label("Balans: "));
		rightPanel.add(labelBalans);
		
		rightPanel.add(new Label("Ulog: "));
		rightPanel.add(tfUlog);
	
		rightPanel.add(new Label("Kvota: "));
		rightPanel.add(labelKvota);
		
		rightPanel.add(new Label("Dobitak: "));
		rightPanel.add(labelDobitak);
		
		rightPanel.add(igraj);
		rightPanel.setBackground(Color.GRAY);
		
		statusBar.setBackground(Color.DARK_GRAY);
		
		igraj.addActionListener((ae) -> {
			zapocniIgru();
		});
		
		centerPanel = new Panel();
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		centerPanel.add(mreza);
		
		add(centerPanel, BorderLayout.CENTER);
		add(rightPanel, BorderLayout.EAST);
		add(statusBar, BorderLayout.SOUTH);
		
	}

	private void zapocniIgru() {
		
		generisanBroj = new Generator(0, mreza.x*mreza.y - 1);
		labelGenerisanBroj = new Label(String.valueOf(generisanBroj));
		if (mreza.izabraniBrojevi.contains(generisanBroj)) {
			balans += dobitak;
			labelBalans.setText("" + balans);
			statusBar.setBackground(Color.GREEN);
		}
		else {
			balans -= ulog;
			labelBalans.setText("" + balans);
			statusBar.setBackground(Color.RED);
		}

	}

	public static void main(String[] args) {
		new Igra();
	}

	public Mreza getMreza() {
		return mreza;
	}
	
	public void updateKvota() {
		kvota = mreza.x * mreza.y / mreza.getIzabranaPolja().size();
		labelKvota.setText("" + kvota);
	} 
	
	public void updateDobitak() {
		ulog = Integer.parseInt(tfUlog.getText());
		dobitak = kvota * ulog;
		labelDobitak.setText("" + dobitak);
	}

}
