import java.util.Random;
import java.util.Scanner;

public class Lingo {
    private String palabraSecreta;
    private static final int MAX_INTENTOS = 5;

    public Lingo() {
        palabraSecreta = generarPalabraSecreta();
    }

    private String generarPalabraSecreta() {
        String[] palabras = {"hueso", "terco", "rueda", "suelo", "largo", "campo", "lucha", "demon", "botas", "piano"};

        Random random = new Random();
        return palabras[random.nextInt(palabras.length)];
    }

    public void jugar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al juego Lingo!");
        System.out.println("Intenta adivinar la palabra de 5 letras.");

        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
            String intentoUsuario = obtenerInputUsuario(intento);
            String hint = generarHint(intentoUsuario);

            System.out.println("Hint: " + hint);

            if (palabraSecreta.equals(intentoUsuario)) {
                System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
                return;
            }
        }

        System.out.println("Lo siento, has agotado todos tus intentos. La palabra era: " + palabraSecreta);
    }

    private String obtenerInputUsuario(int intento) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Intento " + intento + ": ");
        return scanner.nextLine().toLowerCase(); // Convertir a minúsculas para simplificar la comparación
    }

    private String generarHint(String intentoUsuario) {
        StringBuilder hint = new StringBuilder("-----");

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == intentoUsuario.charAt(i)) {
                hint.setCharAt(i, '*');
            } else if (palabraSecreta.contains(String.valueOf(intentoUsuario.charAt(i)))) {
                hint.setCharAt(i, '-');
            }
        }

        return hint.toString();
    }

    public static void main(String[] args) {
        Lingo lingoGame = new Lingo();
        lingoGame.jugar();
    }
}
