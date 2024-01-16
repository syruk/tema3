public class CaesarCipher {
    public static String encrypt(String message, int shift) {
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char encryptedChar = (char) ((currentChar + shift - 'A') % 26 + 'A');
                encryptedMessage.append(encryptedChar);
            } else if (Character.isDigit(currentChar)) {
                char encryptedDigit = (char) ((currentChar + 1 - '0') % 10 + '0');
                encryptedMessage.append(encryptedDigit);
            } else {
                encryptedMessage.append(currentChar);
            }
        }

        return encryptedMessage.toString();
    }

    // Función para descifrar un mensaje cifrado
    public static String decrypt(String encryptedMessage, int shift) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentChar = encryptedMessage.charAt(i);

            if (Character.isUpperCase(currentChar)) {
                char decryptedChar = (char) ((currentChar - shift - 'A' + 26) % 26 + 'A');
                decryptedMessage.append(decryptedChar);
            } else if (Character.isDigit(currentChar)) {
                char decryptedDigit = (char) ((currentChar - 1 - '0' + 10) % 10 + '0');
                decryptedMessage.append(decryptedDigit);
            } else {
                decryptedMessage.append(currentChar);
            }
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String originalMessage = "HELLO123!"; // Mensaje original
        int shift = 3; // Desplazamiento

        // Cifrar el mensaje
        String encryptedMessage = encrypt(originalMessage, shift);
        System.out.println("Mensaje cifrado: " + encryptedMessage);

        // Descifrar el mensaje cifrado
        String decryptedMessage = decrypt(encryptedMessage, shift);
        System.out.println("Mensaje descifrado: " + decryptedMessage);
    }
}

