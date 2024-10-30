package sockets.ejemplo6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import com.google.gson.Gson;


public class Servidor {

    public static void main(String[] args) {
        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Esperando conexión de un cliente...");

            try (Socket conexionCliente = server.accept()) {
                System.out.println("¡Cliente conectado!");

                // Obtener los flujos de entrada y salida usando try-with-resources
                try (PrintWriter printWriter = new PrintWriter(conexionCliente.getOutputStream(), true)) {

                    // Enviar datos al cliente
                    System.out.println("Envío información al cliente...");

                    Perro p = new Perro("Toby", 10);
                    Gson gson = new Gson();
                    String json = gson.toJson(p);
                    printWriter.println(json);
                    System.out.println("JSON enviado: " + json);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}