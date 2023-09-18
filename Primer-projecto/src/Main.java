import java.util.Arrays;

public class Main {

    private static final int TAMANO_TABLERO = 8;
    private static final String[] PIEZAS = {"♖", "♘", "♗", "♕", "♔", "♗", "♘", "♖", "♙"};


    public static void main(String[] args) {
        String[][] tablero = new String[TAMANO_TABLERO][TAMANO_TABLERO];

        // Inicializar el tablero con casillas vacías
        for (int fila = 0; fila < TAMANO_TABLERO; fila++) {
            for (int columna = 0; columna < TAMANO_TABLERO; columna++) {
                tablero[fila][columna] = "-";
            }
        }

        // Colocar las piezas en sus posiciones iniciales
        for (int columna = 0; columna < TAMANO_TABLERO - 2; columna++) {
            tablero[1][columna] = PIEZAS[8];
            tablero[0][columna] = PIEZAS[columna];
            tablero[6][columna] = PIEZAS[8];
        }
        System.out.println(Arrays.toString(tablero));

        // Mostrar el tablero con las piezas
        for (int fila = 0; fila < TAMANO_TABLERO; fila++) {
            for (int columna = 0; columna < TAMANO_TABLERO; columna++) {
                System.out.print(tablero[fila][columna] + " ");
            }
            System.out.println();
        }
    }
}