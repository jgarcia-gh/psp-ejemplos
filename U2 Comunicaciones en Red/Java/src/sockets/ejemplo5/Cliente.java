package sockets.ejemplo5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        // Conectamos con el servidor y creamos flujo de entrada del socket
        try (Socket cliente = new Socket("localhost", 1234);
             ObjectInputStream objectInputStream = new ObjectInputStream(cliente.getInputStream());) {

            // Recibimos el objeto
            Perro p = (Perro) objectInputStream.readObject();
            System.out.println("Objeto recibido: " + p);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
