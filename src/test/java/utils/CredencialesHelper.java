package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Helper para gestionar credenciales de usuarios de SauceDemo
 * Centraliza las credenciales para evitar hardcodeo en Gherkin
 */
public class CredencialesHelper {

    private static final Map<String, Credencial> USUARIOS = new HashMap<>();

    static {
        // Usuarios de prueba configurados
        USUARIOS.put("standard", new Credencial("standard_user", "secret_sauce"));
        USUARIOS.put("locked", new Credencial("locked_out_user", "secret_sauce"));
        USUARIOS.put("problem", new Credencial("problem_user", "secret_sauce"));
        USUARIOS.put("performance", new Credencial("performance_glitch_user", "secret_sauce"));
        USUARIOS.put("error", new Credencial("error_user", "secret_sauce"));
        USUARIOS.put("visual", new Credencial("visual_user", "secret_sauce"));
        USUARIOS.put("invalid", new Credencial("usuario_invalido", "password_incorrecto"));
    }

    public static String obtenerUsername(String tipoUsuario) {
        Credencial credencial = USUARIOS.get(tipoUsuario);
        if (credencial == null) {
            throw new IllegalArgumentException("Tipo de usuario no configurado: " + tipoUsuario);
        }
        return credencial.username;
    }

    public static String obtenerPassword(String tipoUsuario) {
        Credencial credencial = USUARIOS.get(tipoUsuario);
        if (credencial == null) {
            throw new IllegalArgumentException("Tipo de usuario no configurado: " + tipoUsuario);
        }
        return credencial.password;
    }

    private static class Credencial {
        String username;
        String password;

        Credencial(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
