package pruebas2;

public class Dados {
<<<<<<< HEAD

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
=======
  //	static int tiros = Integer.parseInt(JOptionPane.showInputDialog("�Cuantos dados quieres lanzar?"));
  //	static Object opciones[]= {"D4","D6","D8","D10","D12","D20","D100"};

  public static int tiros = 0;
  static Object opciones[] = { "D4", "D6", "D8", "D10", "D12", "D20", "D100" };

  //	static Object hola= "Elige una opci�n.";
  //
  //	static Object objeto=JOptionPane.showOptionDialog(null, hola, "Tipo de Dado", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,opciones[1]);

  static int caras = 0;

  static int total1 = 0;
  static int total2 = 0;
  static int total3 = 0;
  static int tirada1[] = new int[tiros];
  static int tirada2[] = new int[tiros];
  static int tirada3[] = new int[tiros];

  static void rellenarAleatorios(int t1[], int caras, int tiro) {
    tiros = tiro;
    //		if(objeto==(Object)0) {
    //			caras=4;
    //		}else if(objeto==(Object)1){
    //			caras=6;
    //		}else if(objeto==(Object)2) {
    //			caras=8;
    //		}else if(objeto==(Object)3){
    //			caras=10;
    //		}else if(objeto==(Object)4) {
    //			caras=12;
    //		}else if(objeto==(Object)5){
    //			caras=20;
    //		}else if(objeto==(Object)6) {
    //			caras=100;
    //		}

    for (int i = 0; i < t1.length; i++) {
      t1[i] = (int) (Math.random() * caras + 1);
      // t2[i] = (int) (Math.random() * caras + 1);
      // t3[i] = (int) (Math.random() * caras + 1);

      //			Inter2.rellenaTexto( "Lanzamiento [" + (i + 1) + "]=" + t1[i] + "\t");
    }
  }

  static void imprimir(int t1[]) {
    for (int i = 0; i < t1.length; i++) {
      // operaciones(t1[i],t2[i],t3[i]);

      //			Inter2.rellenaTexto("Lanzamiento \" + (i + 1) + \" : \\t");
      //			System.out.print("Lanzamiento " + (i + 1) + " : \t");

      // System.out.print(dado2 + "[" + (i + 1) + "]=" + t2[i] + "\t");
      // System.out.println(dado3 + "[" + (i + 1) + "]=" + t3[i] );

      total1 = total1 + tirada1[i];
      // total2 = total2 + tirada2[i];
      // total3 = total3 + tirada3[i];

    }

    Inter2.totalRes.setName(Integer.toString(total1));
    // "\tTotal 3:" + total3);
  }
>>>>>>> ac87715b8484c320a418f0b998966b9c208852fe
}
