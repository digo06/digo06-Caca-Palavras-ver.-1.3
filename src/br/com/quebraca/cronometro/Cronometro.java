package br.com.quebraca.cronometro;

import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Cronometro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel contagemTempo;
	private Timer tm;
	private int contador = 0;

	public Cronometro() {
		this.setOpaque(false);
		this.setBounds(820, 520, 300, 100);

		contagemTempo = new JLabel("00:00:00");
		contagemTempo.setForeground(Color.white);
		contagemTempo.setFont(new Font(contagemTempo.getName(), Font.PLAIN, 50));
		this.add(contagemTempo);

		tm = new Timer();
		tm.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				contador++;
				int seg = contador % 60;
				int min = contador / 60;
				int hora = min / 60;
				min %= 60;
				contagemTempo.setText(String.format("%02d:%02d:%02d", hora, min, seg));

			}
		}, 1000, 1000);
		this.setVisible(true);

	}

	public void para() {
		tm.cancel();
		contador = 0;
	}

	public String getContagemTempo() {
		return contagemTempo.getText();
	}

}
