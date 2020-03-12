package pruebas2;

public class Dados {


	public static int tiros = 0;

	static int caras = 0;

	static int total1 = 0;

	static int tirada1[] = new int[tiros];

	static int columna;

	static int fila;

	static void rellenarAleatorios(int t1[], int caras, int tiro) {

		for (int i = 0; i < t1.length; i++) {
			t1[i] = (int) (Math.random() * caras + 1);

		}
		fila = 0;
		columna = 0;

		for (int i = 0; i < t1.length; i++) {

			Inter2.resultadoDados.setValueAt(t1[i], fila, columna);

			columna++;
			if (columna == 4) {
				fila++;
				columna = 0;
			}
		}

	}

	static void imprimir(int t1[]) {
		for (int i = 0; i < t1.length; i++) {

			total1 = total1 + tirada1[i];

		}

		Inter2.totalRes.setName(Integer.toString(total1));
	}

}
