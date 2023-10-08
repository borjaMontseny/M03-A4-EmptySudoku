import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

//		char[] fila1 = { '1', '2', '-' };
//		char[] fila2 = invertirFila(fila1);
//
//		for (int i = 0; i < fila2.length; i++) {
//			System.out.print(fila2[i] + " ");
//		}

	}

	public static boolean comprobarSudoku() {
		char[][] sudoku = { { '-', '-', '-', '5', '-', '9', '2', '-', '7' },
				{ '6', '7', '-', '3', '-', '-', '-', '-', '4' }, { '-', '-', '-', '-', '2', '-', '-', '-', '-' },
				{ '-', '4', '9', '2', '-', '-', '-', '8', '5' }, { '-', '-', '-', '-', '-', '-', '-', '-', '-' },
				{ '2', '3', '-', '-', '-', '4', '1', '6', '-' }, { '-', '-', '-', '1', '-', '-', '-', '-', '-' },
				{ '5', '-', '-', '-', '-', '-', '8', '9', '1' }, { '8', '-', '4', '9', '-', '7', '-', '-', '-' } };

		boolean esCorrecto = true;

		int contadorUltimaFila = (sudoku.length - 1);
		char[] filaArriba;
		char[] filaAbajo = sudoku[contadorUltimaFila];

		for (int i = 0; i < sudoku.length; i++) {
			filaArriba = transformarFila(sudoku[i]);
			filaAbajo = transformarFila(invertirFila(sudoku[contadorUltimaFila]));
			
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
