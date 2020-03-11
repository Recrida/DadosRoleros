package pruebas2;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.border.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.*;

@SuppressWarnings("serial")
public class RenderTabla extends DefaultTableCellRenderer {

	static int contador = 0;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) throws NullPointerException {

		fila = row;
		columna = column;

		if (table == Inter2.tabla) {

			if ((int) table.getValueAt(fila, columna) == Iniciales.menores[0] && columna == 0
					|| (int) table.getValueAt(fila, columna) == Iniciales.menores[1] && columna == 1
					|| (int) table.getValueAt(fila, columna) == Iniciales.menores[2] && columna == 2
					|| (int) table.getValueAt(fila, columna) == Iniciales.menores[3] && columna == 3
					|| (int) table.getValueAt(fila, columna) == Iniciales.menores[4] && columna == 4
					|| (int) table.getValueAt(fila, columna) == Iniciales.menores[5] && columna == 5) {

				if (Inter2.com1 == false && column == 0) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com1 = true;

				} else if (Inter2.com2 == false && column == 1) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com2 = true;

				} else if (Inter2.com3 == false && column == 2) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com3 = true;

				} else if (Inter2.com4 == false && column == 3) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com4 = true;

				} else if (Inter2.com5 == false && column == 4) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com5 = true;

				} else if (Inter2.com6 == false && column == 5) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
					Inter2.com6 = true;

				} else {
					setBackground(new Color(153, 102, 51));
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);

				}

			} else {
				setBackground(new Color(153, 102, 51));
				setForeground(new Color(255, 255, 204));
				setHorizontalAlignment(CENTER);
			}

			if (fila == 4) {
				setOpaque(true);
				setBackground(new Color(153, 204, 0));
				setForeground(new Color(255, 255, 204));
				setHorizontalAlignment(CENTER);
			}

			contador = 0;
		}

		if (table == Inter2.resultadoDados) {

			try {

				if ((int) table.getValueAt(fila, columna) == Inter2.Dx) {

					setBackground(new Color(153, 204, 0));
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);

				} else if ((int) table.getValueAt(fila, columna) == 1) {

					setBackground(Color.red);
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);

				} else {

					setBackground(new Color(153, 102, 51));
					setForeground(new Color(255, 255, 204));
					setHorizontalAlignment(CENTER);
				}
			} catch (NullPointerException e) {

				setBackground(new Color(153, 102, 51));
				setForeground(new Color(255, 255, 204));
				setHorizontalAlignment(CENTER);
			}
		}

		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	}

	static int fila = 0;
	static int columna = 0;
	static int menorI = 0;
}

class MyScrollBarUI extends BasicScrollBarUI {
	Color one, two;

	public MyScrollBarUI() {

		one = new Color(153, 102, 51);
		two = new Color(255, 255, 204);
	}

	protected JButton createDecreaseButton(int orientation) {
		JButton button = new JButton("");
		Dimension zeroDim = new Dimension(15, 15);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		button.setBackground(two);
		button.setBorder(new MatteBorder(0, 0, 2, 0, (Color) one));
		button.setBorderPainted(true);
		return button;
	}

	protected JButton createIncreaseButton(int orientation) {
		JButton button = new JButton("");
		Dimension zeroDim = new Dimension(15, 15);
		button.setPreferredSize(zeroDim);
		button.setMinimumSize(zeroDim);
		button.setMaximumSize(zeroDim);
		button.setBorder(new MatteBorder(2, 0, 0, 0, (Color) one));
		button.setBackground(two);
		return button;
	}

	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(one);
		g.translate(trackBounds.x, trackBounds.y);
		g.fillRect(0, 0, trackBounds.width, trackBounds.height);
		g.translate(-trackBounds.x, -trackBounds.y);
//    	c.setBorder(new MatteBorder(1, 1,1, 1, (Color) Color.black));

	}

	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		g.setColor(two);
		c.setBorder(new MatteBorder(1, 1, 1, 1, (Color) one));
		g.translate(thumbBounds.x, thumbBounds.y);
		g.fillRect(0, 0, thumbBounds.width, thumbBounds.height);
		g.translate(-thumbBounds.x, -thumbBounds.y);
	}
}
