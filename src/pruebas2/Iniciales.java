package pruebas2;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.*;

public class Iniciales {
  static int[] tiradaIni = new int[4];
  static int totalIniciales = 0;
  static int[] resultados = new int[6];
  static String[] resST = new String[6];

  static void tiradasIniciales(int t1[], int totalI, int r1[]) {
    n2 = 0;

    for (int d = 0; d < 6; d++) {
      for (int i = 0; i < 4; i++) {
        tiradaIni[i] = (int) (Math.random() * 6 + 1);

        Inter2.tabla.setValueAt(tiradaIni[i], i, d);
        //				System.out.println("Dado " + (i + 1) + " : " + tiradaIni[i] + "\t");
        //				System.out.println("Dado " + (i + 1) + " : " + tiradaIni[i] + "\t");
        totalIniciales = totalIniciales + (int) tiradaIni[i];
      }

      menor = (int) tiradaIni[0];
      posicion = 0;

      for (int i = 0; i < 4; i++) {
        if ((int) tiradaIni[i] < menor) {
          menor = (int) tiradaIni[i];
          posicion = i;
        }
      }

      Inter2.tabla.setValueAt(tiradaIni[posicion], posicion, n2);

      //			Inter2.tabla.getCellRenderer(posicion, d).getTableCellRendererComponent(Inter2.tabla, (int)tiradaIni[posicion], false, false, posicion, n2).setBackground(Color.red);

      menores[d] = (int) tiradaIni[posicion];
      //			System.out.println(menores[d]+"");
      //			Inter2.tabla.getCellRenderer(posicion, d).getTableCellRendererComponent(Inter2.tabla, menor, true, true, posicion, d);

      if (totalIniciales - menor < 8) {
        resultados[d] = 8;
      } else {
        resultados[d] = totalIniciales - menor;
      }

      Render.columna = d;
      Inter2.tabla.setValueAt(resultados[d], 4, d);

      //			System.out.println(Render.contador);
      //			System.out.println(n2);
      //			System.out.println("*****************");

      //			System.out.print(menores[d]+"  ");

      //			System.out.println(posicion + " " + menor);
      // System.out.println("El menor de las tiradas es : " + tiradaIni[posicion]);
      //			System.out.println("El resultado es : " + (totalIniciales - menor));
      // resultados[d]=0;
      // menor=0;
      // posicion=0;
      totalIniciales = 0;
      n2++;
    }
    //n2=0;
  }

  static int menor;
  static int posicion;
  static int[] menores = new int[6];
  static int n2;
}
