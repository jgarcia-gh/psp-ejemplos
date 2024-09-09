package sockets.ejemplo5;

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

                // Obtenemos los flujos de entrada de fichero y salida del socket
                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(conexionCliente.getOutputStream());) {

                    // Creamos un objeto de tipo Perro y lo enviamos
                    Perro p = new Perro("Juanjo", 10);
                    objectOutputStream.writeObject(p);
                    System.out.println("Objeto enviado al cliente");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
