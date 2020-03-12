package pruebas2;

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

			menores[d] = (int) tiradaIni[posicion];

			if (totalIniciales - menor < 8) {

				resultados[d] = 8;

			} else {

				resultados[d] = totalIniciales - menor;

			}

			RenderTabla.columna = d;

			Inter2.tabla.setValueAt(resultados[d], 4, d);

			totalIniciales = 0;

			n2++;
		}

	}

	static int menor;
	static int posicion;
	static int[] menores = new int[6];
	static int n2;

}
