package sockets.ejemplo1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) {

        System.out.println("---SERVIDOR---");

        try (ServerSocket server = new ServerSocket(1234)) {

            System.out.println("Esperando conexión de un cliente...");
            try (Socket conexionCliente = server.accept()) { // La llamada al método accept es bloqueante, eso significa que el hilo quedará bloqueado hasta que se conecte un cliente
                System.out.println("¡Cliente conectado!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}