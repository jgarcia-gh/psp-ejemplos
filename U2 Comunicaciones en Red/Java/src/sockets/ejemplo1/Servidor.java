package sockets.ejemplo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {
        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Esperando conexión de un cliente...");

            try (Socket conexionCliente = server.accept()) {
                System.out.println("¡Cliente conectado!");

                // Obtener los flujos de entrada y salida usando try-with-resources
                try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conexionCliente.getInputStream()));
                     PrintWriter printWriter = new PrintWriter(conexionCliente.getOutputStream(), true)) {

                    // Enviar datos al cliente
                    System.out.println("Envío información al cliente...");
                    printWriter.println("¡Hola! Soy el servidor");

                    // Recibir datos del cliente
                    System.out.println("Y espero una respuesta...");
                    String lineaRecibida = bufferedReader.readLine();
                    System.out.println("El mensaje recibido es: " + lineaRecibida);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}