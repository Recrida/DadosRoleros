package pruebas2;

import java.awt.*;
import java.awt.event.*;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class Inter2 extends JFrame implements ActionListener {
	private JScrollPane panel5;

	public static JTextField numeroIN;

	public static int numD = 0;

	public static int[] resultado, roller, totales;

	public static int total,x,y;

	public static int Dx = 6;

	private JButton iniciales, botonLanzar;

	private ButtonGroup grupo;

	private JRadioButton rD3, rD4, rD6, rD8, rD10, rD12, rD20, rD100;

	private Paneles panel1, panel2, panel3, panel4;

	private String resuTT = "";

	public static JTable tabla, resultadoDados;

	public static JLabel totalRes;

	private JLabel salir, minim, tituloP_2, tituloP_3, imgTotal,moverPantalla;

	static boolean com1 = false;
	static boolean com2 = false;
	static boolean com3 = false;
	static boolean com4 = false;
	static boolean com5 = false;
	static boolean com6 = false;

	private JLabel imgd8, imgd20, imgd6, imgd12, imgd4, imgd10, imgd3;

	public Inter2() {
		
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		setAlwaysOnTop(true);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\icon3.png"));

		setBounds(100, 100, 652, 471);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel4 = new Paneles();
		panel4.setOpaque(false);
		panel4.setBorder(UIManager.getBorder("EditorPane.border"));
		panel4.setBounds(0, 246, 652, 224);
		panel4.setVisible(false);
		
		moverPantalla = new JLabel("");
		moverPantalla.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent r) {
				
				Point point= MouseInfo.getPointerInfo().getLocation();
				setLocation(point.x - x, point.y-y);
			}
		});
		moverPantalla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				x=e.getX();
				y=e.getY();
			}
		});
		
		moverPantalla.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
		moverPantalla.setBounds(0, 0, 575, 97);
		add(moverPantalla);
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
		tabla.setDefaultRenderer(Object.class, new RenderTabla());
		tabla.setFont(new Font("Ink Free", Font.BOLD, 15));
		tabla.setVisible(true);

		resultadoDados = new JTable();
		resultadoDados.setBorder(null);
		resultadoDados.setAutoCreateRowSorter(true);
		resultadoDados.setOpaque(false);
		resultadoDados.setBounds(0, 0, 610, 157);

		resultadoDados.setToolTipText("Dado (N\u00BA) : (Resultado)");
		resultadoDados.setCellSelectionEnabled(true);

		resultadoDados.setGridColor(new Color(255, 255, 204));
		resultadoDados.setTableHeader(null);
		resultadoDados.setRowMargin(0);
		resultadoDados.setModel(new DefaultTableModel(5, 4));
		resultadoDados.setShowHorizontalLines(false);
		resultadoDados.setBackground(new Color(153, 102, 51));
		resultadoDados.setForeground(new Color(255, 255, 204));
		resultadoDados.setSelectionForeground(new Color(153, 102, 51));
		resultadoDados.setSelectionBackground(new Color(255, 255, 204));
		resultadoDados.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		resultadoDados.setRowHeight(31);
		resultadoDados.setDefaultRenderer(Object.class, new RenderTabla());
		resultadoDados.setFont(new Font("Ink Free", Font.BOLD, 20));
		resultadoDados.setVisible(false);

		panel5 = new JScrollPane(resultadoDados);
		panel5.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(153, 102, 51)));
		panel5.setInheritsPopupMenu(true);
		panel5.setIgnoreRepaint(true);
		panel5.setVerifyInputWhenFocusTarget(false);
		panel5.setBackground(new Color(153, 102, 51));
		panel5.setLocation(21, 11);
		panel5.setSize(610, 158);
		panel5.getVerticalScrollBar().setBackground(new Color(255, 255, 204));

		panel5.getVerticalScrollBar().setUI(new MyScrollBarUI());
//		UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.black));
//		UIManager.put("Button.foreground", new ColorUIResource(Color.black));

		panel4.add(panel5);

		resultadoDados.setVisible(true);
		resultadoDados.setFont(new Font("Ink Free", Font.BOLD, 15));

		imgTotal = new JLabel("");
		imgTotal.setIcon(
				new ImageIcon("C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\pruebas\\src\\pruebas\\total.png"));
		imgTotal.setBounds(234, 171, 114, 53);
		panel4.add(imgTotal);

		totalRes = new JLabel("22");
		totalRes.setHorizontalAlignment(SwingConstants.LEFT);
		totalRes.setForeground(new Color(255, 255, 204));
		totalRes.setFont(new Font("Ink Free", Font.BOLD, 22));
		totalRes.setBounds(328, 171, 129, 53);
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

		JLabel imgd100 = new JLabel("");
		imgd100.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d100.png"));
		imgd100.setBounds(605, 85, 39, 23);
		panel2.add(imgd100);

		JSeparator separador = new JSeparator();
		separador.setBackground(new Color(255, 255, 204));
		separador.setOpaque(true);
		separador.setForeground(new Color(255, 255, 204));
		separador.setOrientation(SwingConstants.VERTICAL);
		separador.setBounds(273, 0, 2, 149);
		panel2.add(separador);

		grupo = new ButtonGroup();

		rD3 = new JRadioButton();
		rD3.setActionCommand("3");
		rD3.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD3.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD3.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD3.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));
		rD3.setOpaque(false);
		rD3.setFocusPainted(false);
		rD3.setRequestFocusEnabled(false);
		rD3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		rD3.setName("3");
		rD3.setForeground(new Color(255, 255, 204));
		rD3.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD3.setBounds(395, 59, 57, 23);

		grupo.add(rD3);
		panel2.add(rD3);

		rD4 = new JRadioButton();
		rD4.setActionCommand("4");
		rD4.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD4.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD4.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD4.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD4.setRequestFocusEnabled(false);
		rD4.setName("4");
		rD4.setForeground(new Color(255, 255, 204));
		rD4.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD4.setOpaque(false);
		rD4.setBounds(454, 59, 57, 23);
		grupo.add(rD4);
		panel2.add(rD4);

		rD6 = new JRadioButton();
		rD6.setActionCommand("6");

		rD6.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD6.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD6.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD6.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD6.setRequestFocusEnabled(false);
		rD6.setName("6");
		rD6.setOpaque(false);
		rD6.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD6.setBorder(null);
		rD6.setBackground(new Color(204, 204, 102));
		rD6.setForeground(new Color(255, 255, 204));
		rD6.setBounds(517, 59, 53, 23);
		rD6.setSelected(true);
		grupo.add(rD6);
		panel2.add(rD6);

		rD8 = new JRadioButton();
		rD8.setActionCommand("8");
		rD8.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD8.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD8.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD8.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD8.setRequestFocusEnabled(false);
		rD8.setName("8");
		rD8.setForeground(new Color(255, 255, 204));
		rD8.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD8.setOpaque(false);
		rD8.setBounds(572, 59, 57, 23);
		grupo.add(rD8);
		panel2.add(rD8);

		rD10 = new JRadioButton();
		rD10.setActionCommand("10");
		rD10.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD10.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD10.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD10.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD10.setRequestFocusEnabled(false);
		rD10.setName("10");
		rD10.setForeground(new Color(255, 255, 204));
		rD10.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD10.setOpaque(false);
		rD10.setBounds(395, 85, 57, 23);
		panel2.add(rD10);
		grupo.add(rD10);

		rD12 = new JRadioButton();
		rD12.setActionCommand("12");
		rD12.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD12.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD12.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD12.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD12.setRequestFocusEnabled(false);
		rD12.setName("12");
		rD12.setForeground(new Color(255, 255, 204));
		rD12.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD12.setOpaque(false);
		rD12.setBounds(454, 85, 57, 23);
		grupo.add(rD12);
		panel2.add(rD12);

		rD20 = new JRadioButton();
		rD20.setActionCommand("20");
		rD20.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD20.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD20.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD20.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD20.setRequestFocusEnabled(false);
		rD20.setName("20");
		rD20.setForeground(new Color(255, 255, 204));
		rD20.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD20.setOpaque(false);
		rD20.setBounds(513, 85, 57, 23);
		grupo.add(rD20);
		panel2.add(rD20);

		rD100 = new JRadioButton();
		rD100.setActionCommand("100");
		rD100.setSelectedIcon(new ImageIcon("src\\pruebas2\\radioimg\\r4.png"));
		rD100.setPressedIcon(new ImageIcon("src/pruebas2/radioimg/r3.png"));
		rD100.setRolloverIcon(new ImageIcon("src/pruebas2/radioimg/r2.png"));
		rD100.setIcon(new ImageIcon("src/pruebas2/radioimg/r1.png"));

		rD100.setRequestFocusEnabled(false);
		rD100.setName("100");
		rD100.setForeground(new Color(255, 255, 204));
		rD100.setFont(new Font("Ink Free", Font.BOLD, 12));
		rD100.setOpaque(false);
		rD100.setBounds(572, 85, 57, 23);
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
		botonLanzar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 204)));
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
		iniciales.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 204)));
		iniciales.setBorderPainted(false);
		iniciales.setRequestFocusEnabled(false);
		iniciales.setForeground(new Color(255, 255, 204));
		iniciales.setBackground(new Color(153, 102, 51));
		iniciales.setFont(new Font("Ink Free", Font.BOLD, 14));

		iniciales.addActionListener(this);

		iniciales.setBounds(66, 86, 140, 39);
		panel2.add(iniciales);

		numeroIN = new JTextField("1");
		numeroIN.setFont(new Font("Ink Free", Font.BOLD, 12));
		numeroIN.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 204)));
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

		imgd8 = new JLabel("");
		imgd8.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d8.png"));
		imgd8.setBounds(605, 59, 39, 23);
		panel2.add(imgd8);

		imgd20 = new JLabel("");
		imgd20.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d20.png"));
		imgd20.setBounds(545, 85, 39, 23);
		panel2.add(imgd20);

		imgd6 = new JLabel("");
		imgd6.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d6.png"));
		imgd6.setBounds(545, 59, 39, 23);
		panel2.add(imgd6);

		imgd12 = new JLabel("");
		imgd12.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d12.png"));
		imgd12.setBounds(485, 85, 39, 23);
		panel2.add(imgd12);

		imgd4 = new JLabel("");
		imgd4.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d4.png"));
		imgd4.setBounds(485, 59, 39, 23);
		panel2.add(imgd4);

		imgd10 = new JLabel("");
		imgd10.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d10.png"));
		imgd10.setBounds(425, 85, 39, 23);
		panel2.add(imgd10);

		imgd3 = new JLabel("");
		imgd3.setIcon(new ImageIcon(
				"C:\\Users\\Usuario\\Desktop\\Programacion\\Java\\cursojava\\Dados\\src\\pruebas2\\radioimg\\d3.png"));
		imgd3.setBounds(425, 59, 39, 23);
		panel2.add(imgd3);

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

	static void rellenaTexto(String texto) {

		long total1 = 0;

		for (int i = 0; i < roller.length; i++) {

			total1 = total1 + roller[i];

		}

		totalRes.setText("" + total1);
	}

	@Override
	public void actionPerformed(ActionEvent e) throws NumberFormatException {
		// TODO Auto-generated method stub

		if (e.getSource() == rD3 || e.getSource() == rD4 || e.getSource() == rD6 || e.getSource() == rD8
				|| e.getSource() == rD10 || e.getSource() == rD12 || e.getSource() == rD20 || e.getSource() == rD100) {
			Dx = Integer.parseInt(e.getActionCommand());

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

		com1 = false;
		com2 = false;
		com3 = false;
		com4 = false;
		com5 = false;
		com6 = false;

		if (e.getSource() == botonLanzar) {

//			System.out.println(panel5.getVerticalScrollBar().setUI(new ScrollBarUI());

			try {
				numD = Integer.parseInt(numeroIN.getText());
			} catch (NumberFormatException j) {

				numD = 0;
			}

			if (numD == 0 || numD > 1000) {
				JOptionPane.showMessageDialog(botonLanzar, "Introduce un valor de 1 a 1000",
						"N�mero de dados Incorrecto", getDefaultCloseOperation());
			}

			if (numD < 16) {
				resultadoDados.setModel(new DefaultTableModel(5, 4));

			} else {

				resultadoDados.setModel(new DefaultTableModel((int) Math.round(numD / 4) + 1, 4));
			}

			roller = new int[numD];
			resuTT = "";


			Dados.rellenarAleatorios(roller, Dx, numD);


			for (int i = 0; i < roller.length; i++) {
				resuTT = resuTT + " D " + (i + 1) + ":  " + Integer.toString(roller[i]) + "\t\t";
			}
			rellenaTexto(resuTT);

			if (panel3.isVisible()) {
				panel3.setVisible(false);
				panel4.setVisible(true);
			}
			panel4.setVisible(true);
		}
	}

	private @SuppressWarnings("serial") static class Paneles extends JPanel {


		public Paneles() {


		}
	}
}
