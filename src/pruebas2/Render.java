package pruebas2;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.lang.reflect.Array;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.*;

public class Render extends DefaultTableCellRenderer {

	static int contador=0;

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		fila = row;
		columna = column;
		
		
//		System.out.print(value);
		if((int) table.getValueAt(fila, columna)==Iniciales.menores[0]&& columna==0 ||
				(int) table.getValueAt(fila, columna)==Iniciales.menores[1]&& columna==1 ||
				(int) table.getValueAt(fila, columna)==Iniciales.menores[2]&& columna==2 ||
				(int) table.getValueAt(fila, columna)==Iniciales.menores[3]&& columna==3 ||
				(int) table.getValueAt(fila, columna)==Iniciales.menores[4]&& columna==4 ||
				(int) table.getValueAt(fila, columna)==Iniciales.menores[5]&& columna==5 )  {
			
			if(contador==0) {
				setBackground(Color.red);
				setForeground(new Color(255, 255, 204));
				setHorizontalAlignment(CENTER);
				
				
				
			}else {
				setBackground(new Color(153, 102, 51));
				setForeground(new Color(255, 255, 204));
				setHorizontalAlignment(CENTER);

				
			}
			
		}else {
			setBackground(new Color(153, 102, 51));
			setForeground(new Color(255, 255, 204));
			setHorizontalAlignment(CENTER);
		}
		
		
		
		
		
		
		
		
		
		
		if (fila == 4) {
			setOpaque(true);
			setBackground(new Color(153,204,0));
			setForeground(new Color(255, 255, 204));
//			setHorizontalTextPosition(CENTER);
			setHorizontalAlignment(CENTER);
			
		
		}
//		else {
//			setBackground(new Color(153, 102, 51));
//			setForeground(new Color(255, 255, 204));
//			setHorizontalAlignment(CENTER);
//
//		}
//		
		contador=0;

		
		return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	}

	static int fila = 0;
	static int columna = 0;
	static int menorI = 0;
}
