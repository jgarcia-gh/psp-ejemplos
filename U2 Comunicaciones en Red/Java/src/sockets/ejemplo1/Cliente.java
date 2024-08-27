package sockets.ejemplo1;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) {

        System.out.println("---CLIENTE---");

        try (// Conectamos al servidor
             Socket cliente = new Socket("localhost", 1234);

             // Obtenemos los flujos de entrada y salida
             InputStream inputStream = cliente.getInputStream();
             OutputStream outputStream = cliente.getOutputStream();

             // Obtenemos los flujos de datos
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
             PrintWriter printWriter = new PrintWriter(outputStream, true);) {

            // Recibimos datos del servidor
            System.out.println("Espero el saludo del servidor...");
            String lineaRecibida = bufferedReader.readLine();
            System.out.println("El mensaje recibido es: " + lineaRecibida);

            // Enviamos datos al servidor
            System.out.println("Envío información al servidor...");
            printWriter.println("¡Hola! Soy el cliente.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}