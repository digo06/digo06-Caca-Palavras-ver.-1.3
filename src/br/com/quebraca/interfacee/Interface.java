package br.com.quebraca.interfacee;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import br.com.quebraca.buttons.FundoB;
import br.com.quebraca.cronometro.Cronometro;
import br.com.quebraca.logica.GerenJogo;

public class Interface extends JFrame implements MouseListener {

	private static final long serialVersionUID = 1L;
	private JButton btInicialNew;
	private JButton btNivelFacil;
	private JButton btNivelMedio;
	private JButton btNivelDificil;
	private JButton SairPartida;
	private JButton voltaMenu;
	private JPanel contentPane;
	private JPanel painelLista;
	private JPanel contentFoto;
	private byte tamanho;
	private byte contadorDeAcertos;
	private String selecao = "";
	private String[] palavrasAchar = { "DESMATAMENTO", "SUSTENTABILIDADE", "LIXO", "RECICLAGEM", "TERRA", "LATAS" };
	private String[] palavrasDefi = { "<html><body>Limpeza ou retirada do mato</body></html>",
			"<html><body>Denso conjunto de arvores que cobrem vasta extensao de terra; mata.</body></html>",
			"<html><body>Qualquer material sem valor ou utilidade, ou detrito oriundo de trabalhos domesticos, industriais etc. que se joga fora.</body></html>",
			"<html><body>Processo que visa transformar materiais usados em novos produtos com vista a sua reutilizacao.</body></html>",
			"<html><body>Planeta do sistema solar, o terceiro quanto a proximidade do Sol</body></html>",
			"<html><body>Folha de flandres.</body></html>" };
	private JLabel[][] labels;
	private JLabel[] labelsPalavras;
	private boolean arrastando = false;
	private GerenJogo g;
	private Cronometro c = null;

	public static void main(String[] args) {
		new Interface().telaInicial();
	}

	public Interface() {
		super("Caca Palavras");
		this.getContentPane().setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);

		contentPane = new JPanel(null);
		this.g = new GerenJogo();
	}

	public void telaInicial() {

		this.setResizable(false);
		this.setBounds(400, 100, 500, 500);

		this.getContentPane().remove(contentPane);
		contentPane = new FundoB("imagens/fundo.png");

		contentPane.setBounds(0, 0, 500, 500);
		contentPane.setLayout(null);

		this.getContentPane().add(contentPane);

		btInicialNew = new JButton();
		btInicialNew.setBorder(null);
		btInicialNew.setContentAreaFilled(false);
		btInicialNew.setBorderPainted(false);

		btInicialNew.setIcon(new ImageIcon("imagens/btn.png"));
		btInicialNew.setBounds(150, 180, 200, 80);

		btInicialNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				telaNiveis();
			}
		});

		contentPane.add(btInicialNew);
		btInicialNew.repaint();

		for (int i = 0; i < labelsPalavras.length; i++) {
			labelsPalavras[i].setBackground(Color.white);
		}
		telaDoJogo();

	}

	public void telaNiveis() {
		this.setResizable(false);
		this.setBounds(400, 100, 500, 500);

		this.getContentPane().remove(contentPane);
		contentPane = new JPanel(null);
		contentPane = new FundoB("imagens/fundo.png");
		contentPane.setBounds(0, 0, 500, 500);
		contentPane.setLayout(null);

		this.getContentPane().add(contentPane);

		btNivelFacil = new JButton();
		btNivelFacil.setContentAreaFilled(false);
		btNivelFacil.setOpaque(false);
		btNivelFacil.setIcon(new ImageIcon("imagens/btnFacil.png"));
		btNivelFacil.setBounds(145, 30, 200, 80);
		btNivelFacil.setBorderPainted(false);
		btNivelFacil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tamanho = 15;
				telaDoJogo();
			}
		});
		contentPane.add(btNivelFacil);
		btNivelFacil.repaint();

		btNivelMedio = new JButton();
		btNivelMedio.setBorderPainted(false);
		btNivelMedio.setContentAreaFilled(false);
		btNivelMedio.setIcon(new ImageIcon("imagens/btnMedio.png"));
		btNivelMedio.setBounds(145, 180, 200, 80);
		btNivelMedio.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tamanho = 20;
				telaDoJogo();

			}

		});
		contentPane.add(btNivelMedio);

		btNivelDificil = new JButton();
		btNivelDificil.setBorderPainted(false);
		btNivelDificil.setContentAreaFilled(false);
		btNivelDificil.setIcon(new ImageIcon("imagens/btnDificil.png"));
		btNivelDificil.setBounds(145, 330, 200, 80);

		btNivelDificil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tamanho = 25;
				telaDoJogo();
			}
		});
		contentPane.add(btNivelDificil);
		btNivelDificil.repaint();
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void telaDoJogo() {

		contadorDeAcertos = 0;

		if (tamanho == 15) {
			g.getGerenteDeNivel().getNivel().nivelFacil();
			labelsPalavras = new JLabel[7];
		} else if (tamanho == 20) {
			g.getGerenteDeNivel().getNivel().nivelMedio();
			labelsPalavras = new JLabel[10];
		} else {
			g.getGerenteDeNivel().getNivel().nivelDificil();
			labelsPalavras = new JLabel[12];
		}

		g.getGerenteDeNivel().carregaMatrizComLetrasAleatorias();

		for (int i = 0; i < palavrasAchar.length; i++) {
			if (i / 2 == 0) {
				g.getGerenteDeNivel().Horizontal(palavrasAchar[i]);
			} else {
				g.getGerenteDeNivel().Vertical(palavrasAchar[i]);

			}
		}

		this.setResizable(false);
		this.setSize(1150, 720);
		this.setLocationRelativeTo(null);
		this.getContentPane().remove(contentPane);

		contentFoto = new FundoB("imagens/fundoJogo.png");

		contentFoto.setBounds(0, 0, 1150, 800);
		contentFoto.setLayout(null);
		this.getContentPane().add(contentFoto);

		this.getContentPane().add(contentFoto);

		contentPane = new JPanel(null);
		contentPane.setBounds(4, 4, 800, 600);
		contentPane.setLayout(new GridLayout(tamanho, tamanho));

		contentFoto.add(contentPane);

		SairPartida = new JButton();
		SairPartida.setBorderPainted(false);
		SairPartida.setContentAreaFilled(false);
		SairPartida.setIcon(new ImageIcon("imagens/btnSair.png"));
		SairPartida.setBounds(30, 630, 120, 50);
		SairPartida.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				System.exit(0);

			}
		});

		contentFoto.add(SairPartida);

		voltaMenu = new JButton();
		voltaMenu.setBorderPainted(false);
		voltaMenu.setContentAreaFilled(false);

		voltaMenu.setIcon(new ImageIcon("imagens/btnVoltaInicio.png"));
		voltaMenu.setBounds(568, 630, 250, 58);
		voltaMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				new Interface().telaInicial();
			}

		});
		contentFoto.add(voltaMenu);

		c = new Cronometro();
		contentFoto.add(c);

		labels = new JLabel[tamanho][tamanho];

		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				JLabel label = new JLabel(
						String.valueOf(g.getGerenteDeNivel().getNivel().getMatriz().getLetras()[i][j].getLetra()));

				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setBackground(new Color(0, 39, 40));
				label.setForeground(Color.WHITE);
				label.setOpaque(true);
				label.addMouseListener(this);
				label.setBounds(10, 10, 15, 15);

				labels[i][j] = label;

				contentPane.add(label);

			}
		}
		painelLista = new JPanel(null);
		painelLista.setLayout(new GridLayout(6, 1));
		painelLista.setBounds(820, 10, 300, 500);

		for (int i = 0; i < palavrasDefi.length; i++) {
			JLabel lbPalavras = new JLabel(palavrasDefi[i]);
			lbPalavras.setHorizontalAlignment(SwingConstants.CENTER);
			lbPalavras.setBackground(new Color(0, 39, 40));
			lbPalavras.setForeground(Color.WHITE);
			lbPalavras.setOpaque(true);
			labelsPalavras[i] = lbPalavras;
			painelLista.add(lbPalavras);

		}
		contentFoto.add(painelLista);

		SwingUtilities.updateComponentTreeUI(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		if (e.getSource() instanceof JLabel) {
			JLabel label = (JLabel) e.getSource();
			if (arrastando) {
				label.setBackground(Color.RED);
				selecao += label.getText();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override

	public void mousePressed(MouseEvent e) {
		if (e.getSource() instanceof JLabel) {
			arrastando = true;
			JLabel label = (JLabel) e.getSource();
			selecao += label.getText();
			label.setBackground(Color.red);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		boolean tem = false;
		arrastando = false;

		for (int i = 0; i < palavrasAchar.length; i++) {

			if (palavrasAchar[i].equalsIgnoreCase(selecao)) {
				labelsPalavras[i].setBackground(Color.RED);
				tem = true;
			}

		}
		if (tem) {
			JOptionPane.showMessageDialog(null, "Acertou a palavra :" + selecao);
			contadorDeAcertos++;

		} else {
			JOptionPane.showMessageDialog(null, "errou a palavra " + selecao + " nao existe na lista");
		}
		if (contadorDeAcertos == palavrasAchar.length) {
			c.para();
			JOptionPane.showMessageDialog(null,
					"Parabens voce Acertou todas as Palavras.\nTempo: " + c.getContagemTempo());
			contadorDeAcertos = 0;
			dispose();
			new Interface().telaInicial();
		}
		selecao = "";
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j < tamanho; j++) {
				labels[i][j].setBackground(new Color(0, 39, 40));
			}
		}
	}

}