package pruebas2;

import javax.swing.*;

import java.awt.*;
import javax.swing.table.*;
import javax.swing.text.StyledEditorKit;

import java.awt.event.*;
import java.util.InputMismatchException;

public class Inter2 extends JFrame implements ActionListener {

	JScrollPane scroll;
	private JScrollPane scroll_1;

	public static JTextField numeroIN;
	public static int numD = 0;

	public static JTextArea resultadoDados;

	public static int[] resultado;
	public static int[] roller;

	public static int[] totales;
	public static int total;

	public static int Dx = 6;

	JButton iniciales, botonLanzar;
	ButtonGroup grupo;

	JRadioButton rD3, rD4, rD6, rD8, rD10, rD12, rD20, rD100;

	Paneles panel1, panel4;
	Paneles panel2;
	Paneles panel3;

	public Inter2() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\icon3.png"));
		setUndecorated(true);
		setResizable(false);

		setBounds(100, 100, 652, 471);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		Paneles panel5 = new Paneles();
		panel5.setOpaque(false);
		panel5.setLocation(0, 0);
		panel5.setSize(652, 163);

		panel4 = new Paneles();
		panel4.setOpaque(false);
		panel4.setBorder(UIManager.getBorder("EditorPane.border"));
		panel4.setBounds(0, 246, 652, 224);
		panel4.setVisible(false);
		getContentPane().add(panel4);
		panel4.setLayout(null);

		panel3 = new Paneles();
		panel3.setBounds(0, 246, 652, 224);
		panel3.setOpaque(false);
		panel3.setBackground(new Color(240, 240, 240));
		panel3.setVisible(false);
		getContentPane().add(panel3);
		panel3.setLayout(null);

		tabla = new JTable();
		tabla.setCellSelectionEnabled(true);
		tabla.setToolTipText("");
		tabla.setGridColor(new Color(255, 255, 204));
		tabla.setRowMargin(0);
		tabla.setShowHorizontalLines(false);
		tabla.setOpaque(false);
		tabla.setBackground(new Color(153, 102, 51));
		tabla.setForeground(new Color(255, 255, 204));
		tabla.setSelectionForeground(new Color(153, 102, 51));
		tabla.setSelectionBackground(new Color(255, 255, 204));
		tabla.setBounds(22, 11, 608, 175);
		panel3.add(tabla);
		tabla.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		tabla.setRowHeight(35);
		tabla.setModel(new DefaultTableModel(5, 6));
		tabla.setDefaultRenderer(Object.class, new Render());
		tabla.setFont(new Font("Ink Free", Font.BOLD, 15));
		tabla.setVisible(true);


	
		resultadoDados = new JTextArea();
		resultadoDados.setTabSize(4);
		resultadoDados.setRows(7);
		resultadoDados.setWrapStyleWord(true);
		resultadoDados.setLineWrap(true);
		resultadoDados.setEditable(false);

		resultadoDados.setToolTipText("Dado (N\u00BA) : (Resultado)");
		resultadoDados.setSelectionColor(new Color(204, 153, 0));
		resultadoDados.setSelectedTextColor(new Color(255, 255, 204));
		resultadoDados.setForeground(new Color(255, 255, 204));
		resultadoDados.setBackground(new Color(153, 102, 51));
		resultadoDados.setBounds(22, 11, 608, 161);
		scroll_1 = new JScrollPane(resultadoDados);
		scroll_1.getVerticalScrollBar().setBackground(new Color(255,255,204));
		scroll_1.setBorder(null);
		panel5.add(scroll_1, BorderLayout.CENTER);

		panel4.add(panel5);

		resultadoDados.setVisible(true);
		resultadoDados.setFont(new Font("Ink Free", Font.BOLD, 15));

		imgTotal = new JLabel("");
		imgTotal.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\total.png"));
		imgTotal.setBounds(234, 160, 114, 53);
		panel4.add(imgTotal);

		totalRes = new JLabel("22");
		totalRes.setHorizontalAlignment(SwingConstants.LEFT);
		totalRes.setForeground(new Color(255, 255, 204));
		totalRes.setFont(new Font("Ink Free", Font.BOLD, 22));
		totalRes.setBounds(328, 160, 129, 53);
		panel4.add(totalRes);

		panel1 = new Paneles();
		panel1.setOpaque(false);
		panel1.setBounds(0, 0, 652, 97);
		getContentPane().add(panel1);

		getContentPane().add(panel1);
		panel1.setLayout(null);

		JLabel tituloP = new JLabel("");
		tituloP.setBounds(10, 0, 507, 97);
		tituloP.setIconTextGap(1);
		panel1.add(tituloP);
		tituloP.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\dadosR.png"));

		salir = new JLabel("");
		salir.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {

				System.exit(0);
			}

		});
		salir.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\X.png"));
		salir.setBounds(612, 0, 40, 41);
		panel1.add(salir);

		minim = new JLabel("");
		minim.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				setExtendedState(JFrame.ICONIFIED);
			}
		});
		minim.setIcon(new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\min.png"));
		minim.setBounds(566, 0, 46, 49);
		panel1.add(minim);

		panel2 = new Paneles();
		panel2.setOpaque(false);
		panel2.setBounds(0, 97, 652, 149);
		getContentPane().add(panel2);
		panel2.setLayout(null);

		JSeparator separador = new JSeparator();
		separador.setBackground(new Color(255, 255, 204));
		separador.setOpaque(true);
		separador.setForeground(new Color(255, 255, 204));
		separador.setOrientation(SwingConstants.VERTICAL);
		separador.setBounds(273, 0, 2, 149);
		panel2.add(separador);

		grupo = new ButtonGroup();

		rD3 = new JRadioButton("D 3");
		rD3.setRolloverEnabled(false);
		rD3.setIconTextGap(0);
		rD3.setFocusPainted(false);
		rD3.setRequestFocusEnabled(false);
		rD3.setOpaque(false);
		rD3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rD3.setName("3");
		rD3.setForeground(new Color(255, 255, 204));
		rD3.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD3.setBounds(406, 59, 57, 23);

		grupo.add(rD3);
		panel2.add(rD3);

		rD4 = new JRadioButton("D 4");
		rD4.setRequestFocusEnabled(false);
		rD4.setName("4");
		rD4.setForeground(new Color(255, 255, 204));
		rD4.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD4.setOpaque(false);
		rD4.setBounds(465, 59, 57, 23);
		grupo.add(rD4);
		panel2.add(rD4);

		rD6 = new JRadioButton("D 6");
		rD6.setRequestFocusEnabled(false);
		rD6.setName("6");
		rD6.setOpaque(false);
		rD6.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD6.setBorder(UIManager.getBorder("RadioButtonMenuItem.border"));
		rD6.setBackground(new Color(204, 204, 102));
		rD6.setForeground(new Color(255, 255, 204));
		rD6.setBounds(524, 59, 57, 23);
		rD6.setSelected(true);
		grupo.add(rD6);
		panel2.add(rD6);

		rD8 = new JRadioButton("D 8");
		rD8.setRequestFocusEnabled(false);
		rD8.setName("8");
		rD8.setForeground(new Color(255, 255, 204));
		rD8.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD8.setOpaque(false);
		rD8.setBounds(583, 59, 57, 23);
		grupo.add(rD8);
		panel2.add(rD8);

		rD10 = new JRadioButton("D 10");
		rD10.setRequestFocusEnabled(false);
		rD10.setName("10");
		rD10.setForeground(new Color(255, 255, 204));
		rD10.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD10.setOpaque(false);
		rD10.setBounds(406, 85, 57, 23);
		panel2.add(rD10);
		grupo.add(rD10);

		rD12 = new JRadioButton("D 12");
		rD12.setRequestFocusEnabled(false);
		rD12.setName("12");
		rD12.setForeground(new Color(255, 255, 204));
		rD12.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD12.setOpaque(false);
		rD12.setBounds(465, 85, 57, 23);
		grupo.add(rD12);
		panel2.add(rD12);

		rD20 = new JRadioButton("D 20");
		rD20.setRequestFocusEnabled(false);
		rD20.setName("20");
		rD20.setForeground(new Color(255, 255, 204));
		rD20.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD20.setOpaque(false);
		rD20.setBounds(524, 85, 57, 23);
		grupo.add(rD20);
		panel2.add(rD20);

		rD100 = new JRadioButton("D 100");
		rD100.setRequestFocusEnabled(false);
		rD100.setName("100");
		rD100.setForeground(new Color(255, 255, 204));
		rD100.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD100.setOpaque(false);
		rD100.setBounds(583, 85, 63, 23);
		grupo.add(rD100);
		panel2.add(rD100);

		rD3.addActionListener(this);
		rD4.addActionListener(this);
		rD6.addActionListener(this);
		rD8.addActionListener(this);
		rD10.addActionListener(this);
		rD12.addActionListener(this);
		rD20.addActionListener(this);
		rD100.addActionListener(this);

		botonLanzar = new JButton("Lanzar");
		botonLanzar.setBorderPainted(false);
		botonLanzar.setRequestFocusEnabled(false);
		botonLanzar.setBackground(new Color(153, 102, 51));
		botonLanzar.setForeground(new Color(255, 255, 204));
		botonLanzar.setFont(new Font("Ink Free", Font.BOLD, 15));
		botonLanzar.addActionListener(this);
		botonLanzar.setBounds(388, 115, 135, 34);
		panel2.add(botonLanzar);

		// ------------------------------------------------------------------

		iniciales = new JButton("Dados Iniciales");
		iniciales.setBorderPainted(false);
		iniciales.setRequestFocusEnabled(false);
		iniciales.setForeground(new Color(255, 255, 204));
		iniciales.setBackground(new Color(153, 102, 51));
		iniciales.setFont(new Font("Ink Free", Font.BOLD, 14));

		iniciales.addActionListener(this);

		iniciales.setBounds(66, 86, 140, 39);
		panel2.add(iniciales);

		numeroIN = new JTextField("1");
		numeroIN.setToolTipText("Num: 1 - 999.");
		numeroIN.setSelectionColor(new Color(204, 153, 0));
		numeroIN.setSelectedTextColor(new Color(255, 255, 153));
		numeroIN.setForeground(new Color(255, 255, 204));
		numeroIN.setBackground(new Color(153, 102, 51));
		numeroIN.setHorizontalAlignment(SwingConstants.CENTER);
		numeroIN.setBounds(300, 85, 89, 22);
		panel2.add(numeroIN);
		numeroIN.setColumns(10);

		JLabel tituloP_1 = new JLabel("");
		tituloP_1.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\dnd35.png"));
		tituloP_1.setIconTextGap(1);
		tituloP_1.setBounds(56, 10, 150, 72);
		panel2.add(tituloP_1);

		JLabel tituloP_1_1 = new JLabel("");
		tituloP_1_1.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\roleroD.png"));
		tituloP_1_1.setIconTextGap(1);
		tituloP_1_1.setBounds(363, 0, 175, 65);
		panel2.add(tituloP_1_1);

		tituloP_2 = new JLabel("");
		tituloP_2.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\nDados.png"));
		tituloP_2.setIconTextGap(1);
		tituloP_2.setBounds(300, 50, 107, 34);
		panel2.add(tituloP_2);

		JLabel Fondo = new JLabel("");
		Fondo.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\fondo.jpg"));
		Fondo.setBounds(0, 0, 652, 471);
		getContentPane().add(Fondo);

		tituloP_3 = new JLabel("");
		tituloP_3.setIconTextGap(1);
		tituloP_3.setBounds(159, 424, 150, 72);
		getContentPane().add(tituloP_3);

	}

	static void rellenaTexto(String texto)  {
			
		resultadoDados.setText("");
		resultadoDados.append(texto);
		long total1 = 0;
		for (int i = 0; i < roller.length; i++) {

			total1 =total1 + roller[i];
			// total2 = total2 + tirada2[i];
			// total3 = total3 + tirada3[i];
			
		}

		totalRes.setText(""+total1);
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		// TODO Auto-generated method stub

		if (e.getActionCommand() == "D 3" || e.getActionCommand() == "D 4" || e.getActionCommand() == "D 6"
				|| e.getActionCommand() == "D 8" || e.getActionCommand() == "D 10" || e.getActionCommand() == "D 12"
				|| e.getActionCommand() == "D 20" || e.getActionCommand() == "D 100") {

			Dx = Integer.parseInt(e.getActionCommand().subSequence(2, e.getActionCommand().length()).toString());

		}

		if (e.getSource() == iniciales) {

			Iniciales.tiradasIniciales(Iniciales.tiradaIni, Iniciales.totalIniciales, Iniciales.resultados);

			if (panel4.isVisible()) {
				panel4.setVisible(false);
				panel3.setVisible(true);
			} else {
				panel3.setVisible(true);

			}
		}
		if (e.getSource() == botonLanzar) {
			
			try {
			numD = Integer.parseInt(numeroIN.getText());
			}catch(Exception j) {
			if( numD==0 || numD >1000 ) {
				
				
			JOptionPane.showMessageDialog(botonLanzar, "Introduce un valor de 1 a 1000", "Número de dados Incorrecto", getDefaultCloseOperation());
			}else {
				roller = new int[numD];
				resuTT = "";
//				
				Dados.rellenarAleatorios(roller, Dx, numD);

				for (int i = 0; i < roller.length; i++) {

					resuTT = resuTT + " D " + (i + 1) + ":  " + Integer.toString(roller[i]) + "\t\t";

				}
				rellenaTexto(resuTT);

				resultadoDados.setVisible(true);

				if (panel3.isVisible()) {

					panel3.setVisible(false);
					panel4.setVisible(true);
				} else {
					panel4.setVisible(true);
				}

			}
			
			}
		}
	}

	private String resuTT = "";
	public static JTable tabla;
	private JLabel tituloP_2;
	private JLabel tituloP_3;
	private JLabel imgTotal;
	public static JLabel totalRes;
	private JLabel salir;
	private JLabel minim;
}

class Paneles extends JPanel {

	public Paneles() {

	}

}

class Tablas extends JTable implements TableCellRenderer {

	public Tablas() {

	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		// TODO Auto-generated method stub
		return null;
	}
}
