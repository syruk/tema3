import java.util.Scanner;

public class HangmanGame {
    private String palabraSecreta;
    private StringBuilder palabraActual;
    private int intentosRestantes;
    private static final int MAX_INTENTOS = 6;

    public HangmanGame(String palabraSecreta) {
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.palabraActual = new StringBuilder("_".repeat(palabraSecreta.length()));
        this.intentosRestantes = MAX_INTENTOS;
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego del ahorcado!");
        System.out.println("La palabra tiene " + palabraSecreta.length() + " letras.");

        while (intentosRestantes > 0) {
            System.out.println("\nPalabra actual: " + palabraActual.toString());
            System.out.println("Intentos restantes: " + intentosRestantes);

            System.out.print("Ingresa una letra: ");
            char letra = scanner.next().toUpperCase().charAt(0);

            if (adivinarLetra(letra)) {
                System.out.println("¡Bien hecho! La letra está en la palabra.");
            } else {
                System.out.println("Incorrecto. Pierdes un intento.");
                intentosRestantes--;
                dibujarAhorcado(MAX_INTENTOS - intentosRestantes);
            }

            if (palabraActual.indexOf("_") == -1) {
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                return;
            }
        }

        System.out.println("\n¡Lo siento! Has agotado todos tus intentos. La palabra era: " + palabraSecreta);
    }

    private boolean adivinarLetra(char letra) {
        boolean letraAdivinada = false;

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                palabraActual.setCharAt(i, letra);
                letraAdivinada = true;
            }
        }

        return letraAdivinada;
    }

    private void dibujarAhorcado(int intento) {
        switch (intento) {
            case 1:
                System.out.println("  o");
                break;
            case 2:
                System.out.println("  o");
                System.out.println("  |");
                System.out.println("  |");
                break;
            case 3:
                System.out.println("  o");
                System.out.println(" /|");
                System.out.println("  |");
                break;
            case 4:
                System.out.println("  o");
                System.out.println(" /|\\");
                System.out.println("  |");
                break;
            case 5:
                System.out.println("  o");
                System.out.println(" /|\\");
                System.out.println(" / ");
                break;
            case 6:
                System.out.println("  o");
                System.out.println(" /|\\");
                System.out.println(" / \\");
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Primer jugador, ingresa la palabra secreta: ");
        String palabraSecreta = scanner.nextLine();

        // Limpiar la consola
        System.out.print("\033[H\033[2J");
        System.out.flush();

        HangmanGame juego = new HangmanGame(palabraSecreta);
        juego.jugar();
    }
}
