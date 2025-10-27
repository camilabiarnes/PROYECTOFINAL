package Modelo;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Utilidad simple para hashear y verificar contraseñas usando PBKDF2.
 * Guarda el valor en formato: base64(salt):base64(hash)
 */
public class PasswordUtils {

    private static final int ITERATIONS = 65536;
    private static final int KEY_LENGTH = 256; // bits
    private static final String ALGORITHM = "PBKDF2WithHmacSHA1";

    private PasswordUtils() {
    }

    public static String hashPassword(String password) {
        byte[] salt = generateSalt();
        byte[] hash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        String sSalt = Base64.getEncoder().encodeToString(salt);
        String sHash = Base64.getEncoder().encodeToString(hash);
        return sSalt + ":" + sHash;
    }

    public static boolean verifyPassword(String password, String stored) {
        if (password == null || stored == null) return false;
        String[] parts = stored.split(":");
        if (parts.length != 2) return false;
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        byte[] hash = Base64.getDecoder().decode(parts[1]);
        byte[] tryHash = pbkdf2(password.toCharArray(), salt, ITERATIONS, KEY_LENGTH);
        if (tryHash.length != hash.length) return false;
        int diff = 0;
        for (int i = 0; i < hash.length; i++) {
            diff |= hash[i] ^ tryHash[i];
        }
        return diff == 0;
    }

    private static byte[] generateSalt() {
        SecureRandom sr = new SecureRandom();
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) {
        try {
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ALGORITHM);
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException("Error al hashear la contraseña", ex);
        }
    }
}
