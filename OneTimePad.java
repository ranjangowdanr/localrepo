import java.security.SecureRandom;

public class OneTimePad {

    public static byte[] generateOneTimePad(int length) {
        byte[] oneTimePad = new byte[length];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(oneTimePad);
        return oneTimePad;
    }

    public static byte[] encrypt(byte[] message, byte[] oneTimePad) {
        if (message.length != oneTimePad.length) {
            throw new IllegalArgumentException("Message and one-time pad must be the same length.");
        }

        byte[] ciphertext = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            ciphertext[i] = (byte) (message[i] ^ oneTimePad[i]); // XOR operation
        }
        return ciphertext;
    }

    public static byte[] decrypt(byte[] ciphertext, byte[] oneTimePad) {
        if (ciphertext.length != oneTimePad.length) {
            throw new IllegalArgumentException("Ciphertext and one-time pad must be the same length.");
        }

        byte[] decryptedMessage = new byte[ciphertext.length];
        for (int i = 0; i < ciphertext.length; i++) {
            decryptedMessage[i] = (byte) (ciphertext[i] ^ oneTimePad[i]); // XOR operation
        }
        return decryptedMessage;
    }
    public static void main(String[] args) {
        String message = "Anukiran";
        byte[] oneTimePad = generateOneTimePad(message.length());

        byte[] ciphertext = encrypt(message.getBytes(), oneTimePad);
        byte[] decryptedMessageBytes = decrypt(ciphertext, oneTimePad);
        String decryptedMessage = new String(decryptedMessageBytes);

        System.out.println("Original message: " + message);
        System.out.println("One-time pad key: " + new String(oneTimePad));
        System.out.println("Ciphertext: " + new String(ciphertext));
        System.out.println("Decrypted message: " + decryptedMessage);
}
}
