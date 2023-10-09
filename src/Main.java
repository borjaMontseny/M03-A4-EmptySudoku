import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		System.out.println(comprobarSudoku());

	}

	public static boolean comprobarSudoku() {
		char[][] sudoku = {
	            { '-', '-', '-', '5', '-', '9', '2', '-', '7' },
	            { '6', '7', '-', '3', '-', '-', '-', '-', '4' },
	            { '-', '-', '-', '-', '2', '-', '-', '-', '-' },
	            { '-', '4', '9', '2', '-', '-', '-', '8', '5' },
	            { '-', '-', '-', '-', '-', '-', '-', '-', '-' },
	            { '2', '3', '-', '-', '-', '4', '1', '6', '-' },
	            { '-', '-', '-', '1', '-', '-', '-', '-', '-' },
	            { '5', '-', '-', '-', '-', '-', '8', '9', '1' },
	            { '8', '-', '4', '9', '-', '7', '-', '-', '-' }
		};

		int contadorFilaArriba = 0;
		int contadorFilaAbajo = 8; // (sudoku.length - 1)
		char[] filaArriba = transformarFila(sudoku[contadorFilaArriba]);
		char[] filaAbajo = transformarFila(invertirFila(sudoku[contadorFilaAbajo]));

		while (contadorFilaArriba < contadorFilaAbajo) {
			if (!Arrays.equals(filaArriba, filaAbajo)) {
				System.out.println("fila arriba:\n");
				for (int i = 0; i < filaArriba.length; i++) {
					System.out.print(filaArriba[i] + ",");
				}
				System.out.println("\ncontador fila abajo: " + contadorFilaAbajo);
				System.out.println("\ncontador fila abajo: " + contadorFilaArriba);
				System.out.println("\n\nfila abajo:\n");
				for (int i = 0; i < filaAbajo.length; i++) {
					System.out.print(filaAbajo[i] + ",");
				}
				return false;
			} else if (Arrays.equals(filaArriba, filaAbajo)) {
				contadorFilaArriba++;
				contadorFilaAbajo--;
				filaArriba = transformarFila(sudoku[contadorFilaArriba]);
				filaAbajo = transformarFila(invertirFila(sudoku[contadorFilaAbajo]));
				return true;
			}

			
		}

		return true;
	}

	// cambiaré los numeros a X para que sea más facil comprararlos
	public static char[] transformarFila(char[] filaSudoku) {
		char[] filaTransformada = new char[filaSudoku.length];

		for (int i = 0; i < filaSudoku.length; i++) {
			if (filaSudoku[i] != '-') {
				filaTransformada[i] = 'X';
			} else {
				filaTransformada[i] = '-';
			}
		}

		return filaTransformada;
	}

	// das un char[], devuelve uno nuevo invertido del de parámetro
	public static char[] invertirFila(char[] fila) {
		char[] filaInvertida = new char[fila.length];

		int contadorFilaInvertida = 0;

		for (int i = fila.length - 1; i >= 0; i--) {
			filaInvertida[contadorFilaInvertida] = fila[i];
			contadorFilaInvertida++;
		}

		return filaInvertida;
	}

}
