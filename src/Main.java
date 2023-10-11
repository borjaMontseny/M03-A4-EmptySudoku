import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Entrada Sudokus: ");
		int numSudokus = sc.nextInt();
		System.out.println(numSudokus);

		sc.nextLine();
		char[][] sudoku = new char[9][9];
		String linea;

		// veces que machacaremos el sudoku auxiliar
		for (int i = 0; i < numSudokus; i++) {
			sc.nextLine();
			// tomamos toda la linea
			for (int fil = 0; fil < sudoku.length; fil++) {
				linea = sc.nextLine();
				// char por char vamos formando el sudoku
				for (int j = 0; j < linea.length(); j++) {
					sudoku[fil][j] = linea.charAt(j);
				}
			}
			if (comprobarSudoku(sudoku) && (contarCeldasRellenas(sudoku) <= 32)) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
		}

		sc.close();

	}

	public static boolean comprobarSudoku(char[][] sudoku) {

		int contadorFilaArriba = 0;
		int contadorFilaAbajo = (sudoku.length - 1);
		char[] filaArriba = transformarFila(sudoku[contadorFilaArriba]);
		char[] filaAbajo = transformarFila(invertirFila(sudoku[contadorFilaAbajo]));

		while (contadorFilaArriba < contadorFilaAbajo) {
			if (!Arrays.equals(filaArriba, filaAbajo)) {
				return false;
			} else {
				contadorFilaArriba++;
				contadorFilaAbajo--;
				filaArriba = transformarFila(sudoku[contadorFilaArriba]);
				filaAbajo = transformarFila(invertirFila(sudoku[contadorFilaAbajo]));
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

	public static int contarCeldasRellenas(char[][] sudoku) {

		int contadorCeldasRellenas = 0;

		for (int i = 0; i < sudoku.length; i++) {
			for (int j = 0; j < sudoku[i].length; j++) {
				if (sudoku[i][j] != '-') {
					contadorCeldasRellenas++;
				}
			}

		}

		return contadorCeldasRellenas;

	}

}
